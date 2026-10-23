The simulated blockchain has two clients. One is a listener which can produce a text-based status update whenever the blockchain notifies it of additions to the ledger and another the editor which can submit a text to the ledger.

Important project files

In blockchain: in /contracts is the contract definition source file and in ignition/modules is the code which provides a wrapper interface to the simulated blockchain for the blockchain clients

In textsync: in src/main/java/com/textsync are the clients of the simulated blockchain

How to run the program
1. Go to the blockchain project directory
2. Enter npx hardhat node to run the blockchain simulation
3. Create new terminal window and enter npx hardhat ignition deploy ./ignition/modules/deploy.js --network localhost to deploy contract to simulation
4. Go to the textsync project directory
5. Compile maven project
6. Open a new terminal or command line window and cd into textsync directory (now you have two, the one where you compiled and the one which you just created)
7. In one of the terminals, enter java -jar target/textsync-1.0.0.jar listener <private_key> <contract_address>
8. In the other, enter java -jar target/textsync-1.0.0.jar editor <private_key> <contract_address>

You get the private key from the output of step 1 and the contract address from the output of step 3. 
