package ru.academits.oop.february2019.veselova.vector;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Error. Negative dimension of a vector.");
        }

        vector = new double[n];
    }

    public Vector(Vector other) {
        if (other == null) {
            throw new NullPointerException("Vector is null");
        }

        vector = new double[other.getSize()];
        double[] otherArray = other.getVector();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = otherArray[i];
        }
    }

    public Vector(double[] array) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        vector = new double[array.length];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = array[i];
        }
    }


    Vector(int n, double[] array) {
        if (n < 0) {
            throw new IllegalArgumentException("Error. Negative dimension of a vector.");
        }
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        vector = new double[n];
        for (int i = 0; i < array.length; i++) {
            vector[i] = array[i];
        }
    }

    public double[] getVector() {
        return vector;
    }

    public int getSize() {
        return vector.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < vector.length; i++) {
            sb.append(vector[i] + ", ");
        }
        sb.delete(sb.length() - 2, 2);
        sb.append(" }");

        return sb.toString();
    }
}