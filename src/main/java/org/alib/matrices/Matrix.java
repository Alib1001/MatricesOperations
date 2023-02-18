package org.alib.matrices;

import java.io.IOException;
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
            System.out.println("Transposed matrix: ");
        }
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }


    private boolean isSquareMatrix() {
        if (rows != columns) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i].length != columns) {
                return false;
            }
        }

        return true;
    }

    public int[][] getCofactors() {
        int n = matrix.length;
        int[][] cofactors = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactors[i][j] = (int) Math.pow(-1, i + j) * findMinor(i, j);
            }
        }

        return cofactors;
    }

    private int findMinor(int row, int col) {
        int n = matrix.length;
        int[][] submatrix = new int[n-1][n-1];
        int subRow = 0;

        for (int i = 0; i < n; i++) {
            if (i != row) {
                int subCol = 0;
                for (int j = 0; j < n; j++) {
                    if (j != col) {
                        submatrix[subRow][subCol] = matrix[i][j];
                        subCol++;
                    }
                }
                subRow++;
            }
        }

        return findDeterminant(submatrix);
    }

    public void showMinor(int row, int column){
        int minor = findMinor(row,column);
        System.out.println("Минор: " +minor);
    }

    private int findDeterminant(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;


        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        int determinant = 0;

        for (int i = 0; i < n; i++) {
            int sign = (i % 2 == 0) ? 1 : -1;
            int[][] subMatrix = getSubMatrix(matrix, i);
            int subDeterminant = findDeterminant(subMatrix);
            determinant += sign * matrix[0][i] * subDeterminant;
        }

        return determinant;
    }

    public void showDeterminant(int[][] matrix){
        int determinant = findDeterminant(matrix);
        System.out.println("Определитель: " + "|" +determinant+"|");
    }

    private int[][] getSubMatrix(int[][] matrix, int col) {
        int n = matrix.length;
        int[][] subMatrix = new int[n - 1][n - 1];
        int subRow = 0;

        for (int i = 1; i < n; i++) {
            int subCol = 0;
            for (int j = 0; j < n; j++) {
                if (j != col) {
                    subMatrix[subRow][subCol] = matrix[i][j];
                    subCol++;
                }
            }
            subRow++;
        }
        return subMatrix;
    }

}