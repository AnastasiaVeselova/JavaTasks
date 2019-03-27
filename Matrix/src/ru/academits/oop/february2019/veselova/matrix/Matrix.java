package ru.academits.oop.february2019.veselova.matrix;

import ru.academits.oop.february2019.veselova.vector.Vector;

public class Matrix {
    Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException();
        }

        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix other) {
        if (other==null) {
            throw new NullPointerException();
        }

        rows = new Vector[other.getRowsCount()];
        for (int i = 0; i < other.getRowsCount(); i++) {
            rows[i]=new Vector(other.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array==null) {
            throw new NullPointerException();
        }
        if (array.length == 0 || array[0].length == 0) {
            throw new IllegalArgumentException();
        }

        int rowsCount = array.length;
        int columnsCount = array[0].length;

        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            if (array[i].length != columnsCount){
                throw new IllegalArgumentException();
            }
            rows[i]=new Vector(array[i]);
        }
    }

    public Matrix(Vector[] rows) {
        if (rows==null) {
            throw new NullPointerException();
        }
        if (rows.length == 0) {
            throw new IllegalArgumentException();
        }



        int rowsCount = rows.length;
        int columnsCount = rows[0].getSize();

        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            if (rows[i].getSize() != columnsCount){
                throw new IllegalArgumentException();
            }
            rows[i]=new Vector(rows[i]);
        }
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }
}
