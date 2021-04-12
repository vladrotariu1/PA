package com.lab7.compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player implements Runnable{

    private final String name;
    private final Board board;
    private ArrayList<Token> tokens;
    private ArrayList<ArrayList<Token>> tokensFormations;
    private ArrayList<Token> unusedTokens;
    private Lock lock = new ReentrantLock();

    public Player(Board board, String name) {
        this.name = name;
        this.board = board;
        tokens = new ArrayList<>(10);
        tokensFormations = new ArrayList<>(10);
        unusedTokens = new ArrayList<>(10);
    }

    public String getName() {
        return name;
    }

    public void chooseToken(int id) {
        Token token = board.getToken(id);
        tokens.add(token);
        unusedTokens.add(token);
    }

    public void chooseToken() throws NoTokensLeftException {
        synchronized(board) {
            if (board.gameOver())
                throw new NoTokensLeftException();
        }
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

    private int formationScore(int formationId) {
        int score = 0;
        ArrayList<Token> formation = tokensFormations.get(formationId);

        for (Token token : formation) {
            score += token.getTokenSpecificValue();
        }

        return formation.size() == Token.getMaximumPairValue() ? score * 2 : score;
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < tokensFormations.size(); i++) {
            if (!invalidFormation(i)) {
                score += formationScore(i);
            }
        }
        return score;
    }

    @Override
    public void run() {
        while(!board.gameOver()) {
            lock.lock();
            try {
                chooseToken();
            } catch (NoTokensLeftException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}
