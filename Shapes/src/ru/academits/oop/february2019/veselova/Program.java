package ru.academits.oop.february2019.veselova;

import ru.academits.oop.february2019.veselova.shapes.*;

public class Program {
    public static void main(String[] args) {
        IShape shapes[]={
                new Rectangle(5, 10),
                new Square(20.5),
                new Square(15),
                new Triangle(1,2, 5,8, -4, -7),

                new Rectangle(1, 3),
                new Circle(30),
                new Circle(15),
                new Triangle(-6,58, 12,46, 75, 24),

                new Rectangle(11, 3.14),
                new Circle(4.66)
        };
    }
}
