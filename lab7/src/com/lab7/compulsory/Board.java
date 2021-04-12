package com.lab7.compulsory;

import java.util.ArrayList;

public class Board {

    private final int tokensNumber = 100;
    private ArrayList<Token> tokens;

    public Board() {
        tokens = new ArrayList<>(100);
        generateTokens();
    }

    private void generateTokens() {
        for (int i = 0; i < tokensNumber; i++)
            tokens.add(new Token());
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public Token getToken(int id) {
        return tokens.remove(id);
    }

    public Token getToken() {
        return tokens.remove(tokens.size() - 1);
    }

    public boolean gameOver() {
        return tokens.isEmpty();
    }
}
