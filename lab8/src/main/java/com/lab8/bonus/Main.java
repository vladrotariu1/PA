package com.lab8.bonus;

import com.lab8.tasks.Task1;
import com.lab8.tasks.Task2;

import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 5; i++) {
            Task1 task = new Task1();
            executor.execute(task);
        }
        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " Milliseconds");

        /*long start = System.currentTimeMillis();
        for (int i = 1; i <= 5; i++) {
            Task2 task = new Task2();
            executor.execute(task);
        }
        executor.shutdown();
        while (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.print("Awaiting completion of threads.");
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " Milliseconds");*/
    }
}
