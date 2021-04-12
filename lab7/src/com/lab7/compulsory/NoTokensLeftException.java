package com.lab7.compulsory;

public class NoTokensLeftException extends Exception {
    public NoTokensLeftException() {
        super("There are no tokens left on the board!\n");
    }
}
