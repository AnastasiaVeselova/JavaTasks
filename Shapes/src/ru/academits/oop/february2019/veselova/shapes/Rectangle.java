package ru.academits.oop.february2019.veselova.shapes;

public class Rectangle implements IShape {
    private final String name = "Прямоугольник";

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

   /* @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        String formattedNumber = FormattedOutputRules.formRealNumberOutputString();
        return String.format(super.toString() +
                        "Длина (размер длинной стороны): " + formattedNumber + " мм" + lineSeparator +
                        "Ширина (размер короткой стороны): " + formattedNumber + " мм" + lineSeparator +
                        "Длина диагонали: " + formattedNumber + " мм",
                getHeight(), getWidth(), computeDiagonal());
    }*/

}
