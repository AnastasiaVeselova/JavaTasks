package ru.academits.oop.february2019.veselova.shapes;

public class Circle implements IShape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Incorrect figure parameters. A circle cannot have negative radius.");
        }
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Circle c = (Circle) o;
        return radius == c.radius;
    }

    @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        String formattedNumber = "%." + 2 + "f";

        return String.format("Circle:" + lineSeparator +
                        "Width: " + formattedNumber + " mm" + lineSeparator +
                        "Height: " + formattedNumber + " mm" + lineSeparator +
                        "Area: " + formattedNumber + " sq. mm" + lineSeparator +
                        "Perimeter: " + formattedNumber + " mm" + lineSeparator,
                getWidth(), getHeight(), getArea(), getPerimeter());
    }
}