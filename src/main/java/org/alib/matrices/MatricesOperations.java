package org.alib.matrices;

public class MatricesOperations {

    //TODO: переписать итеративные алгоритмы

    public static int[][] findSum(int[][] matrix1, int[][] matrix2){
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        int[][] resultMatrix = new int[rows1][columns2];

        if (matrix1.length != rows2 || matrix2.length != rows1 || matrix1[0].length != columns2 ||
                matrix2[0].length != columns1) {
            throw new IllegalArgumentException("Размеры матриц должны быть равны !");
        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    public static int[][] findDiff(int[][] matrix1, int[][] matrix2){

        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;


        if (matrix1.length != rows2 || matrix2.length != rows1 || matrix1[0].length != columns1 ||
                matrix2[0].length != columns1) {
            throw new IllegalArgumentException("Размеры матриц должны быть равны !");
        }

        int[][] result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyByNumbers(int[][] matrix, int... numbers) {
        int[][] result = matrix;
        for (int number : numbers) {
            result = multiplyByNumber(result, number);
        }
        return result;
    }

    public static int[][] multiplyByNumber(int[][] matrix, int number) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j] * number;
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1,int[][] matrix2){

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

    public static int[][] exponentiateMatrix(int[][] matrix, int power) {
        int n = matrix.length;

        if (n != matrix[0].length) {
            throw new IllegalArgumentException("Матрица должна быть квадратной !");
        }

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        int[][] temp = new int[n][n];
        while (power > 0) {
            if (power % 2 == 1) {
                temp = multiplyMatrices(result, matrix);
                result = temp;
            }
            temp = multiplyMatrices(matrix, matrix);
            matrix = temp;
            power /= 2;
        }

        return result;
    }

}