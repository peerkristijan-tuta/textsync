package com.textsync;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.abi.EventEncoder;
import java.util.Scanner;

public class TextsyncApplication {
    public static void main(String[] args) throws Exception {
        Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
        Credentials credentials = Credentials.create(args[1]);
        TextRegistry contract = TextRegistry.load(args[2], web3, credentials, new DefaultGasProvider());

        if (args[0].equals("listener")) {
            contract.textAddedEventFlowable(
                new EthFilter(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST, args[2])
                    .addSingleTopic(EventEncoder.encode(TextRegistry.TEXTADDED_EVENT))
            ).subscribe(event -> System.out.println("Received: " + event.hash));
            while (true) {}
        } else {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter text to submit: ");
                contract.addtext(scanner.nextLine()).send();
            }
        }
    }
}