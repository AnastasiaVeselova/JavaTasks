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
        for (int i = 0; i < getSize(); i++) {
            vector[i] = other.vector[i];
        }
    }

    public Vector(double[] array) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        vector = new double[array.length];
        for (int i = 0; i < getSize(); i++) {
            vector[i] = array[i];
        }
    }


    public Vector(int n, double[] array) {
        if (n < 0) {
            throw new IllegalArgumentException("Error. Negative dimension of a vector.");
        }
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        vector = new double[n];

        int m = Math.min(n, array.length);
        for (int i = 0; i < m; i++) {
            vector[i] = array[i];
        }
    }

    public int getSize() {
        return vector.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < getSize(); i++) {
            sb.append(vector[i] + ", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" }");

        return sb.toString();
    }

    public void addVector(Vector other) {
        int m = Math.min(getSize(), other.getSize());

        for (int i = 0; i < m; i++) {
            vector[i] += other.vector[i];
        }
    }

    public void subtractVector(Vector other) {
        int m = Math.min(getSize(), other.getSize());

        for (int i = 0; i < m; i++) {
            vector[i] -= other.vector[i];
        }
    }

    public void multiplyByScalar(double scalarValue) {
        for (int i = 0; i < getSize(); i++) {
            vector[i] *= scalarValue;
        }
    }

    public void revertVector() {
        multiplyByScalar(-1);
    }

    public double getComponentByIndex(int index) {
        if (index >= getSize()) {
            throw new IndexOutOfBoundsException("Error. Out of bounds array.");
        }
        return vector[index];
    }

    public void setComponentByIndex(int index, double value) {
        if (index >= getSize()) {
            throw new IndexOutOfBoundsException("Error. Out of bounds array.");
        }
        vector[index] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Vector other = (Vector) o;
        if (getSize() != other.getSize()) return false;

        for (int i = 0; i < getSize(); i++) {
            if (vector[i] != other.vector[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < getSize(); i++) {
            hash += Double.hashCode(vector[i]);
        }
        return hash;
    }

    public static Vector add(Vector first, Vector second) {
        Vector result;
        if (first.getSize() >= second.getSize()) {
            result = new Vector(first);
            result.addVector(second);
        } else {
            result = new Vector(second);
            result.addVector(first);
        }

        return result;
    }

    //TODO сделать адекватно работающее вычитание static и nonstatic
    public static Vector subtract(Vector first, Vector second) {

        Vector result;
        if (first.getSize() >= second.getSize()) {
            result = new Vector(first);
            result.subtractVector(second);
        } else {
            result = new Vector(second);
            result.subtractVector(first);
        }
        return result;
    }

    public static double scalarProduct(Vector first, Vector second) {
        double calculateScalarProduct = 0;
        int m = Math.min(first.getSize(), second.getSize());
        for (int i = 0; i < m; i++) {
            calculateScalarProduct += first.vector[i] * second.vector[i];
        }
        return calculateScalarProduct;
    }
}