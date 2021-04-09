package com.lab7.compulsory;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Board {
    public List<Token> board = new ArrayList<>();

    //temporary until list successfully implemented
    public int[][] tokenList;
    Random randomValue = new Random();

    public Board(int maxPositions) {
        for (int position1Counter = 1; position1Counter <= maxPositions; position1Counter++)
            for (int position2Counter = 1; position2Counter <= maxPositions; position2Counter++)
                tokenList[position1Counter][position2Counter] = (randomValue.nextInt(100) + 1);
    }

    //temporary until list successfully implemented
    public void removeValue(int position1, int position2) {
        tokenList[position1][position2] = -1;
    }
}
