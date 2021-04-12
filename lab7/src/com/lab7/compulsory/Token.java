package com.lab7.compulsory;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class Token {

    private static final int maximumPairValue = 10;
    private static final int maximumTokenSpecificValue = 5;
    private final int tokenSpecificValue;
    private final Map<Integer, Integer> pair;

    public Token() {
        tokenSpecificValue = generateTokenSpecificValue();
        pair = Collections.singletonMap(generatePairValue(), generatePairValue());
    }

    public int getTokenSpecificValue() {
        return tokenSpecificValue;
    }

    public static int getMaximumPairValue() {
        return maximumPairValue;
    }

    public static int getMaximumTokenSpecificValue() {
        return maximumTokenSpecificValue;
    }

    public Map<Integer, Integer> getPair() {
        return pair;
    }

    private int generateTokenSpecificValue() {
        Random rand = new Random();
        return rand.nextInt(maximumTokenSpecificValue) + 1;
    }

    private int generatePairValue() {
        Random rand = new Random();
        return rand.nextInt(maximumTokenSpecificValue) + 1;
    }
}
