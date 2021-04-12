package com.lab7.compulsory;

public class Game {
    private final Board board = new Board();
    private final Player p1 = new Player(board, "Vlad");
    private final Player p2 = new Player(board, "Cristi");

    public void playGame() {
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(p1.getName());
        System.out.println(p2.getName());
    }
}
