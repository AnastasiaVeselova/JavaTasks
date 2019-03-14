package ru.academits.oop.february2019.veselova.comparators;

import ru.academits.oop.february2019.veselova.shapes.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b) {
        return Double.compare(b.getArea(), a.getArea());
    }
}