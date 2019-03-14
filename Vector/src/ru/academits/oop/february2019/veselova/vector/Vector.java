package ru.academits.oop.february2019.veselova.vector;

import java.util.Arrays;

public class Vector {
    private double[] numbers;

    public Vector(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Error. Non-positive dimension of a numbers.");
        }
        numbers = new double[length];
    }

    public Vector(Vector other) {
        if (other == null) {
            throw new NullPointerException("Vector is null");
        }
        if (other.getSize() == 0) {
            throw new IllegalArgumentException("Error. Zero dimension of a numbers.");
        }

        numbers = other.numbers.clone();
    }

    public Vector(double[] array) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Error. Zero dimension of a numbers.");
        }

        numbers = array.clone();
    }

    public Vector(int length, double[] array) {
        if (length <= 0) {
            throw new IllegalArgumentException("Error. Non-positive dimension of a numbers.");
        }
        if (array == null) {
            throw new NullPointerException("Array is null");
        }
        numbers = Arrays.copyOf(array, length);
    }

    public int getSize() {
        return numbers.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = ", ";

        sb.append("{ ");
        for (int i = 0; i < getSize(); i++) {
            sb.append(numbers[i]);
            sb.append(delimiter);
        }
        sb.setLength(sb.length() - 2);
        sb.append(" }");

        return sb.toString();
    }

    public void addVector(Vector other) {
        int newLength = other.getSize();
        if (getSize() < newLength) {
            numbers = Arrays.copyOf(numbers, newLength);
        }

        for (int i = 0; i < newLength; i++) {
            numbers[i] += other.numbers[i];
        }
    }

    public void subtractVector(Vector other) {
        int newLength = other.getSize();
        if (getSize() < newLength) {
            numbers = Arrays.copyOf(numbers, newLength);
        }

        for (int i = 0; i < newLength; i++) {
            numbers[i] -= other.numbers[i];
        }
    }

    public void multiplyByScalar(double scalarValue) {
        for (int i = 0; i < getSize(); i++) {
            numbers[i] *= scalarValue;
        }
    }

    public void revert() {
        multiplyByScalar(-1);
    }

    public double getComponentByIndex(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Error. Out of bounds array.");
        }
        return numbers[index];
    }

    public void setComponentByIndex(int index, double value) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Error. Out of bounds array.");
        }
        numbers[index] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector other = (Vector) o;
        if (getSize() != other.getSize()) {
            return false;
        }

        for (int i = 0; i < getSize(); i++) {
            if (numbers[i] != other.numbers[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    public static Vector add(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.addVector(vector2);
        return result;
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.subtractVector(vector2);
        return result;
    }

    public static double scalarProduct(Vector vector1, Vector vector2) {
        double result = 0;
        int minLength = Math.min(vector1.getSize(), vector2.getSize());
        for (int i = 0; i < minLength; i++) {
            result += vector1.numbers[i] * vector2.numbers[i];
        }
        return result;
    }
}