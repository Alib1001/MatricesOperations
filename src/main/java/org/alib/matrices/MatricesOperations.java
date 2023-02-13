package org.alib.matrices;
public class MatricesOperations {
    int rows;
    int columns;
    public MatricesOperations(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

    }
    public int[][] findSum(int[][] matrix1, int[][] matrix2){

        int[][] resultMatrix = new int[rows][columns];

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

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] multiplyByNumbers(int[][] matrix, int... numbers) {
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

    public int[][] multiplyMatrices(int[][] matrix1,int[][] matrix2){

        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        if (columns1 != rows2) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы не равно \n кол-ву строк второй матрицы");
        }

        int[][] result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
}