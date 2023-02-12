package org.alib.matrices;

public class MatricesOperations {
    int rows;
    int columns;
    int[][] resultMatrix;

    public MatricesOperations(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        resultMatrix = new int[rows][columns];
    }

    public int[][] findSum(int[][] matrix1, int[][] matrix2){
        if (matrix1.length != rows || matrix2.length != rows || matrix1[0].length != columns ||
                matrix2[0].length != columns) {
            throw new IllegalArgumentException("Размеры матриц должны быть равны !");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    public int[][] findDiff(int[][] matrix1, int[][] matrix2){
        if (matrix1.length != rows || matrix2.length != rows || matrix1[0].length != columns ||
                matrix2[0].length != columns) {
            throw new IllegalArgumentException("Размеры матриц должны быть равны !");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return resultMatrix;
    }



    public int[][] multiplyMatrix(int[][] matrix, int... numbers) {
        int[][] result = matrix;
        for (int number : numbers) {
            result = multiplyByNumber(result, number);
        }
        return result;
    }

    public  int[][] multiplyByNumber(int[][] matrix, int number) {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j] * number;
            }
        }
        return result;
    }
}