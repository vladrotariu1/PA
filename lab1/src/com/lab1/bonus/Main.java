package com.lab1.bonus;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import static com.lab1.optional.Main.*;

public class Main {

    /*
    * Function that generates random tree
    * */
    public static int[][] generateRandomTree(int vertexCount) {

        int[][] graph = generateRandomGraph(vertexCount);
        int[][] tree;

        while (!isConnected(graph)) {
            graph = generateRandomGraph(vertexCount);
        }

        tree = partialTree(graph);
        return tree;
    }

    /*
    * Function that performs a DFS algorithm and displays the graph recursively
    * */
    public static void displayTree(int[][] matrix, int startNode, Vector<Integer> nodes, int level) {

        if (Arrays.stream(matrix[startNode]).sum() == 1 && startNode != 0) {
            for (int x = 0; x < level; x++) {
                System.out.print("\t");
            }
            System.out.print("-node" + (startNode + 1));
        } else {
            for (int x = 0; x < level; x++) {
                System.out.print("\t");
            }
            System.out.print("+node" + (startNode + 1));
        }
        System.out.println();


        nodes.add(startNode);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[startNode][i] == 1 && !nodes.contains(i)) {
                displayTree(matrix, i, nodes, level + 1);
            }
        }
    }

    public static void main(String[] args) {

        // Creating scanner for stdin
        Scanner scanner = new Scanner(System.in);

        // Read number of vertices from stdin and create tree
        System.out.print("Type in vertices number: ");
        int vertexCount = scanner.nextInt();
        int [][] tree = generateRandomTree(vertexCount);

        // Display tree
        displayTree(tree, 0, new Vector<>(64), 0);
    }
}
