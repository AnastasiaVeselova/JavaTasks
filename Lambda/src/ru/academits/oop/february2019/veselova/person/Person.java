package ru.academits.oop.february2019.veselova.person;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Negative value of age.");
        }
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{ " + name + " - " + age + " }";
    }
}