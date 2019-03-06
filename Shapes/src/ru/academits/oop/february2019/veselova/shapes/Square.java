package ru.academits.oop.february2019.veselova.shapes;

public class Square implements IShape {

    private double side;

    public Square(double side) {
        if (side<0)
            throw new IllegalArgumentException ("Incorrect figure parameters. A square cannot have negative side lengths.");
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
}
