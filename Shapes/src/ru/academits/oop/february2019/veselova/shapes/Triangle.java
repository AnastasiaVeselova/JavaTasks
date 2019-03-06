package ru.academits.oop.february2019.veselova.shapes;

public class Triangle implements IShape {
    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.max(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.max(y2, y3));
    }

    @Override
    public double getArea() {
        return Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) / 2.0;
    }

    @Override
    public double getPerimeter() {
        double aSide = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double bSide = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double cSide = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));

        return aSide + bSide + cSide;
    }

    @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        String formattedNumber = "%." + 2 + "f";

        return String.format("Треугольник:" + lineSeparator +
                        "Ширина: " + formattedNumber + " мм" + lineSeparator +
                        "Длина: " + formattedNumber + " мм" + lineSeparator +
                        "Площадь: " + formattedNumber + " кв. мм" + lineSeparator +
                        "Периметр: " + formattedNumber + " мм" + lineSeparator,
                getWidth(), getHeight(), getArea(), getPerimeter());
    }
}
