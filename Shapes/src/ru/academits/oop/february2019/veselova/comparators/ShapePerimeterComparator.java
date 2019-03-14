package ru.academits.oop.february2019.veselova.comparators;

import ru.academits.oop.february2019.veselova.shapes.Shape;

import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b) {
        return Double.compare(b.getPerimeter(), a.getPerimeter());
    }
}