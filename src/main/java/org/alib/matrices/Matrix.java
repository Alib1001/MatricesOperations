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

    private int findDeterminant(int[][] matrix) {
        int determinant = 0;
        int length = matrix.length;

        if (!isSquareMatrix()) {
            throw new IllegalArgumentException("Матрица должна быть квадратной !");
        }
        if (length == 1) {
            determinant = matrix[0][0];
        } else if (length == 2) {
            determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        } else {
            for (int i = 0; i < length; i++) {
                int[][] subMatrix = new int[length-1][length-1];
                for (int j = 1; j < length; j++) {
                    for (int k = 0; k < length; k++) {
                        if (k < i) {
                            subMatrix[j-1][k] = matrix[j][k];
                        } else if (k > i) {
                            subMatrix[j-1][k-1] = matrix[j][k];
                        }
                    }
                }
                determinant += matrix[0][i] * Math.pow(-1, i) * findDeterminant(subMatrix);
            }
        }
        return determinant;
    }

    public void showDeterminant(int[][] matrix){
        int determinant = findDeterminant(matrix);
        System.out.println("Определитель: " + "|" +determinant+"|");
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

}