package ru.academits.oop.february2019.veselova.shapes;

public class Triangle implements Shape {
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
        double aSide = calculateSegmentLength(x1, y1, x2, y2);
        double bSide = calculateSegmentLength(x2, y2, x3, y3);
        double cSide = calculateSegmentLength(x1, y1, x3, y3);

        return aSide + bSide + cSide;
    }

    private double calculateSegmentLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);

        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);

        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
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
        Triangle t = (Triangle) o;
        return x1 == t.x1 && y1 == t.y1 && x2 == t.x2 && y2 == t.y2 && x3 == t.x3 && y3 == t.y3;
    }

    @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        String formattedNumber = "%.2f";

        return String.format("Triangle:" + lineSeparator +
                        "Vertex coordinates: (%.2f, %.2f); (%.2f, %.2f); (%.2f, %.2f)" + lineSeparator +
                        "Area: " + formattedNumber + " sq. mm" + lineSeparator +
                        "Perimeter: " + formattedNumber + " mm" + lineSeparator,
                x1, y1, x2, y2, x3, y3, getArea(), getPerimeter());
    }
}