package ru.academits.oop.february2019.veselova;

import ru.academits.oop.february2019.veselova.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        IShape[] shapes = {
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

        IShape[] shapesInDescendingOfArea = shapes.clone();

        Arrays.sort(shapesInDescendingOfArea, new Comparator<IShape>() {
            public int compare(IShape a, IShape b) {
                return a.getArea() > b.getArea() ? -1 : a.getArea() == b.getArea() ? 0 : 1;
            }
        });

        IShape[] shapesInDescendingOfPerimeter = shapes.clone();

        Arrays.sort(shapesInDescendingOfPerimeter, new Comparator<IShape>() {
            public int compare(IShape a, IShape b) {
                return a.getPerimeter() > b.getPerimeter() ? -1 : a.getPerimeter() == b.getPerimeter() ? 0 : 1;
            }
        });

        System.out.println("Фигура с наибольшей площадью:" + System.lineSeparator() + shapesInDescendingOfArea[0].toString());

        System.out.println("Фигура со вторым по величине периметром:" + System.lineSeparator() + shapesInDescendingOfPerimeter[1].toString());
    }
}