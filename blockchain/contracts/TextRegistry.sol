pragma solidity ^0.8.0;

contract TextRegistry {
    string[2] private texts;
    event textAdded(string hash);
    uint index = 0;
    
    function addtext(string memory text) public {
        if (index == 0)
            texts[index++] = text;
        else {
            texts[0] = text;
            index = 0;
        }
        emit textAdded(text);
    }
}