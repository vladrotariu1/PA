package com.lab1.optional;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    /*
     * Function that generates random graph
     * */
    public static int[][] generateRandomGraph(int vertexCount) {

        int [][] matrix = new int[vertexCount][vertexCount];

        for (int i = 1; i < vertexCount; i++) {
            for (int j = 0; j < i-1; j++) {

                if (Math.random() > 0.5) {
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
            }
        }

        return matrix;
    }

    /*
     * Function that prints a matrix
     * */
    public static void printMatrix(int[][] matrix) {

        int matrixDimension = matrix.length;

        for (int[] ints : matrix) {
            for (int j = 0; j < matrixDimension; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.print("\n");
        }
    }

    /*
     * Function that performs a recursively DFS search
     * */
    public static void DFS(int[][] matrix, int startNode, Vector<Integer> unvisitedNodes, Vector<Integer> nodes) {

        nodes.add(startNode);

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[startNode][i] == 1 && !nodes.contains(i) && unvisitedNodes.contains(i)) {
                DFS(matrix, i, unvisitedNodes, nodes);
            }
        }
    }

    public static void DFS(int[][] matrix, int startNode, Vector<Integer> nodes, int[] parentsVector) {

        nodes.add(startNode);

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[startNode][i] == 1 && !nodes.contains(i)) {
                parentsVector[i] = startNode + 1;
                DFS(matrix, i, nodes, parentsVector);
            }
        }
    }

    /*
     * Function that returns connect components
     * */
    public static Vector<Vector<Integer>> connectedComponents(int[][] matrix) {

        Vector<Vector<Integer>> components = new Vector<>(16);
        Vector<Integer> unvisitedNodes = new Vector<>(64);
        int vertexCount = matrix.length;

        for (int i = 0; i < vertexCount; i++) {
            unvisitedNodes.add(i);
        }

        while (!unvisitedNodes.isEmpty()) {
            Vector<Integer> component = new Vector<>(16);
            DFS(matrix, unvisitedNodes.firstElement(), unvisitedNodes, component);
            components.add(component);

            for (Integer c : component) {
                unvisitedNodes.remove(c);
            }
        }

        return components;
    }

    /*
     * Function that prints information about the connectivity in the graph
     * */
    public static void connectionInfo(int[][] matrix) {

        Vector<Vector<Integer>> components = connectedComponents(matrix);

        if (components.size() > 1) {

            System.out.println("\nGraph is not connected. Connected components are the following: \n\n");

            for (Vector<Integer> c : components) {
                for (Integer i : c) {
                    System.out.print(i + " ");
                }
                System.out.println("\n");
            }

        } else {
            System.out.println("\nGraph is connected");
        }
    }

    /*
     * Function that prints information about the connectivity in the graph
     * */
    public static boolean isConnected(int[][] matrix) {

        Vector<Vector<Integer>> components = connectedComponents(matrix);

        return components.size() <= 1;
    }

    /*
     * Function to get partial tree adjacency matrix of connected graph
     */
    public static int[][] partialTree(int[][] graph) {
        if (!isConnected(graph)) {
            return null;
        }

        int vertexCount = graph.length;
        int[][] matrix = new int[vertexCount][vertexCount];
        int[] parentsVector = new int[vertexCount];
        DFS(graph,0, new Vector<>(64), parentsVector);

        for (int i = 1; i < parentsVector.length; i++) {
            matrix[i][parentsVector[i] - 1] = 1;
            matrix[parentsVector[i] - 1][i] = 1;
        }

        return matrix;
    }

    public static void main(String[] args) {

        // Creating scanner for stdin
        Scanner scanner = new Scanner(System.in);

        // Read number of vertices from stdin and create matrix
        System.out.print("Type in vertices number: ");
        int vertexCount = scanner.nextInt();
        int [][] matrix = generateRandomGraph(vertexCount);

        // Print the adjacency matrix and display information about the connectivity of the graph
        printMatrix(matrix);
        connectionInfo(matrix);

        // If graph is connected generate an adjacency matrix of partial tree
        if (isConnected(matrix)) {
            int[][] partialTree = partialTree(matrix);
            // Print adjacency matrix of partial tree
            printMatrix(partialTree);
        }
    }
}
