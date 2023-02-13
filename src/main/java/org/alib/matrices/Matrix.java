package org.alib.matrices;

import java.util.Scanner;
class Matrix {
    public int[][] matrix;
    private static int  rows;
    private static int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public void setMatrix() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("a" + (i + 1) + (j + 1) + ": ");
                matrix[i][j] = scan.nextInt();
            }
        }

    }

    public void displayMatrix() {
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void displayMatrix(int[][] matrix) {
        System.out.println("Матрица:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] transposeMatrix() {
        if (matrix.length > 0) {
            System.out.println("Transposed matrix:");
        }
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }


}