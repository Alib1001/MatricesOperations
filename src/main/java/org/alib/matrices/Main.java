package org.alib.matrices;

public class Main {
    public static void main(String[] args) {
        int rowsFirst = 3;
        int columnsFirst = 1;

        int rowsSecond = 1;
        int columnsSecond = 3;

        Matrix firstMatrix = new Matrix(rowsFirst, columnsFirst);
        firstMatrix.setMatrix();
        firstMatrix.displayMatrix();

        Matrix secondMatrix = new Matrix(rowsSecond, columnsSecond);
        secondMatrix.setMatrix();
        secondMatrix.displayMatrix();

        MatricesOperations matricesOperations = new MatricesOperations(rowsFirst,columnsFirst);
        Matrix.displayMatrix(matricesOperations.multiplyMatrices(firstMatrix.matrix, secondMatrix.matrix));

    }
}