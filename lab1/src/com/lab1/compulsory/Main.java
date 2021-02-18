package com.lab1.compulsory;

public class Main {

    /*
     * Method that computes digit sum of the parameter
     * */
    static int digitSum(int n) {

        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;

    }

    /*
     * Method that computes the control number of parameter n
     * */
    static int controlNumber(int n) {

        int controlNumber = digitSum(n);

        while (controlNumber > 9) {
            controlNumber = digitSum(controlNumber);
        }

        return controlNumber;

    }

    public static void main(String[] args) {

        System.out.println("Hello World");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        // Generating random number
        int n = (int) (Math.random() * 1000000);

        // Applying operations on the random generated number
        n += 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
        int result = controlNumber(n);

        // Printing the language I want to learn
        System.out.println("Willy-nilly, this semester I will learn " + languages[result] + ".");

    }
}
