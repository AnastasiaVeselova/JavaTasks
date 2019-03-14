package ru.academits.oop.february2019.veselova.shapes;

public class Square implements Shape {

    private double side;

    public Square(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Incorrect figure parameters. A square cannot have negative side lengths.");
        }
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(side);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Square s = (Square) o;
        return side == s.side;
    }

    @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        String formattedNumber = "%.2f";

        return String.format("Square:" + lineSeparator +
                        "Side: " + formattedNumber + " mm" + lineSeparator +
                        "Area: " + formattedNumber + " sq. mm" + lineSeparator +
                        "Perimeter: " + formattedNumber + " mm" + lineSeparator,
                side, getArea(), getPerimeter());
    }
}