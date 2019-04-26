package ru.academits.oop.february2019.veselova.main;

import ru.academits.oop.february2019.veselova.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Person> people = createPersonList();
        System.out.println(people);
        System.out.println();

        //А)
        System.out.println("А)");
        List<String> uniquePeopleNames = people.stream()
                .map(p -> p.getName())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniquePeopleNames);
        System.out.println();

        //<Б)
        System.out.println("Б)");
        System.out.println("Имена: "
                + uniquePeopleNames
                .stream()
                .collect(Collectors.joining(", ")));
        System.out.println();

        //В)
        System.out.println("В)");
        double averageAge = people
                .stream()
                .filter(p -> p.getAge() < 18)
                .mapToInt(p -> p.getAge())
                .average()
                .orElse(0);

        System.out.println(averageAge);
        System.out.println();

        //Г)
        System.out.println("Г)");
        Map<String, Double> peopleMap = people
                .stream()
                .collect(Collectors.groupingBy(p -> p.getName(), Collectors.averagingDouble(Person::getAge)));

        peopleMap.forEach((name, ages) -> System.out.printf("%s: %.2f%n", name, ages));
        System.out.println();

        //Д)
        System.out.println("Д)");
        String peopleWithAgeBetween20And45 = people
                .stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .map(p -> p.getName())
                .collect(Collectors.joining(", "));
        System.out.println(peopleWithAgeBetween20And45);
    }


    public static List<Person> createPersonList() {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Nastya", 10));
        people.add(new Person("Nastya", 33));
        people.add(new Person("Nina", 81));
        people.add(new Person("Anya", 32));
        people.add(new Person("Julia", 27));
        people.add(new Person("Elizabet", 19));
        people.add(new Person("Elizabet", 23));
        people.add(new Person("Elizabet", 29));

        people.add(new Person("Victor", 44));
        people.add(new Person("Oleg", 37));
        people.add(new Person("Oleg", 67));
        people.add(new Person("Petr", 77));
        people.add(new Person("Valentin", 50));
        people.add(new Person("Alexander", 18));
        people.add(new Person("Alexander", 7));
        people.add(new Person("Vladimir", 100));

        return people;
    }
}
