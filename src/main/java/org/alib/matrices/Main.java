package org.alib.matrices;

public class Main {
    public static void main(String[] args) {

        int rowsFirst = 3;
        int columnsFirst = 3;

        int rows2 = 3;
        int columns2 = 3;
        Matrix firstMatrix = new Matrix(rowsFirst, columnsFirst);
        firstMatrix.setMatrix();
        firstMatrix.displayMatrix();

        Matrix secondtMatrix = new Matrix(rows2, columns2);
        secondtMatrix.setMatrix();
        secondtMatrix.displayMatrix();




    }
}