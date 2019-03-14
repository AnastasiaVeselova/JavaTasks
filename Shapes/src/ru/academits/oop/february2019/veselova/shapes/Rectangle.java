package ru.academits.oop.february2019.veselova.shapes;

public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle(double oneSide, double otherSide) {
        if (oneSide <= 0 || otherSide <= 0) {
            throw new IllegalArgumentException("Incorrect figure parameters. A rectangle cannot have negative side lengths.");
        }
        this.height = (oneSide >= otherSide) ? oneSide : otherSide;
        this.width = (oneSide < otherSide) ? oneSide : otherSide;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Rectangle r = (Rectangle) o;
        return width == r.width && height == r.height;
    }

    @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        String formattedNumber = "%.2f";

        return String.format("Rectangle:" + lineSeparator +
                        "Width: " + formattedNumber + " mm" + lineSeparator +
                        "Height: " + formattedNumber + " mm" + lineSeparator +
                        "Area: " + formattedNumber + " sq. mm" + lineSeparator +
                        "Perimeter: " + formattedNumber + " mm" + lineSeparator,
                width, height, getArea(), getPerimeter());
    }
}