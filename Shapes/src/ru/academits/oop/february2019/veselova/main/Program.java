package ru.academits.oop.february2019.veselova.main;

import ru.academits.oop.february2019.veselova.comparators.ShapeAreaComparator;
import ru.academits.oop.february2019.veselova.comparators.ShapePerimeterComparator;
import ru.academits.oop.february2019.veselova.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(5, 10),
                new Square(20.5),
                new Square(15),
                new Triangle(1, 2, 5, 8, -4, -7),

                new Rectangle(1, 3),
                new Circle(31),
                new Circle(15),
                new Triangle(-6, 58, 12, 46, 75, 24),

                new Rectangle(1, 90),
                new Circle(4.66)
        };

        Shape[] shapesInDescendingOfArea = shapes.clone();

        Arrays.sort(shapesInDescendingOfArea, new ShapeAreaComparator());

        Shape[] shapesInDescendingOfPerimeter = shapes.clone();

        Arrays.sort(shapesInDescendingOfPerimeter, new ShapePerimeterComparator());

        System.out.println("Shape with the largest area:" + System.lineSeparator() + shapesInDescendingOfArea[0].toString());

        System.out.println("Shape with the second largest perimeter:" + System.lineSeparator() + shapesInDescendingOfPerimeter[1].toString());
    }
}