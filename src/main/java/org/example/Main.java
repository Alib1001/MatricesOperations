package org.example;

public class Main {
    public static void main(String[] args) {
        int rowsFirst = 3;
        int columnsFirst = 3;

        int rowsSecond = 3;
        int columnsSecond = 3;

        Matrix firstMatrix = new Matrix(rowsFirst, columnsFirst);
        firstMatrix.setMatrix();
        firstMatrix.displayMatrix();

        Matrix secondMatrix = new Matrix(rowsSecond, columnsSecond);
        secondMatrix.setMatrix();
        secondMatrix.displayMatrix();

        MatricesOperations matricesOperations = new MatricesOperations(rowsFirst,columnsFirst);
        firstMatrix.displayMatrix(matricesOperations.multiplyMatrix(firstMatrix.matrix, 2,5));

    }
}