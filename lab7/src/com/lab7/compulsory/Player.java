package com.lab7.compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Player {

    private String name;
    private Board board;
    private ArrayList<Token> tokens;
    private ArrayList<ArrayList<Token>> tokensFormations;
    private ArrayList<Token> unusedTokens;

    public Player(Board board, String name) {
        this.name = name;
        this.board = board;
        tokens = new ArrayList<>(10);
        tokensFormations = new ArrayList<>(10);
        unusedTokens = new ArrayList<>(10);
    }

    public void chooseToken(int id) {
        Token token = board.getToken(id);
        tokens.add(token);
        unusedTokens.add(token);
    }

    public void chooseToken() {
        Token token = board.getToken();
        tokens.add(token);
        unusedTokens.add(token);
    }

    public void createFormation(int tokenId) {
        tokensFormations.add(new ArrayList<>(Arrays.asList(unusedTokens.get(tokenId))));
    }

    public void addToFormation(int unusedTokenId, int formationId, int positionInFormation) {
        Token token = unusedTokens.remove(unusedTokenId);
        tokensFormations.get(formationId).add(positionInFormation, token);
    }

    public void removeFromFormation(int formationId, int tokenFormationId) {
        Token token = tokensFormations.get(formationId).remove(tokenFormationId);
        unusedTokens.add(token);
    }

    private boolean invalidFormation(int formationId) {
        ArrayList<Token> formation = tokensFormations.get(formationId);

        for (int i = 0; i < formation.size() - 2; i++) {
            Map <Integer, Integer> lastTokenPair = formation.get(i).getPair();
            Map <Integer, Integer> currentTokenPair = formation.get(i+1).getPair();

            if (!lastTokenPair.get(lastTokenPair.keySet().iterator().next()).
                    equals(currentTokenPair.keySet().iterator().next())) {
                return false;
            }
        }

        Map <Integer, Integer> firstTokenPair = formation.get(0).getPair();
        Map <Integer, Integer> lastTokenPair = formation.get(formation.size() - 1).getPair();

        return lastTokenPair.get(lastTokenPair.keySet().iterator().next()).
                equals(firstTokenPair.keySet().iterator().next());
    }
}
