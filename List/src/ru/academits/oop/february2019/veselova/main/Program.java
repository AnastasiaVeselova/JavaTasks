package ru.academits.oop.february2019.veselova.main;

import ru.academits.oop.february2019.veselova.list.SinglyLinkedList;

public class Program {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();

        numbers.addFirstItem(1);
        numbers.addFirstItem(2);

        numbers.insertByIndex(3, 2);
        numbers.insertByIndex(4, 2);

        numbers.insertByIndex(5, 4);

        System.out.println(numbers);

        numbers.removeByValue(4);
        numbers.removeFirstItem();

        numbers.removeByValue(5);

        System.out.println(numbers);

        numbers.addFirstItem(6);
        numbers.addFirstItem(7);

        numbers.reverse();

        System.out.println(numbers);

        SinglyLinkedList<Integer> copyNumbers = numbers.copy();
        numbers.setByIndex(8, 1);
        numbers.setByIndex(9, 0);
        numbers.setByIndex(10, 3);

        System.out.println(numbers);
        System.out.println(copyNumbers);

        SinglyLinkedList<String> lines = new SinglyLinkedList<>();

        lines.addFirstItem(null);
        lines.addFirstItem("123");
        lines.addFirstItem(null);
        System.out.println(lines);

        lines.removeFirstItem();
        lines.removeByValue(null);
        System.out.println(lines);

        lines.addFirstItem("456");
        lines.addFirstItem(null);
        System.out.println(lines);

        SinglyLinkedList<String> linesCopy = lines.copy();
        System.out.println(linesCopy.getFirstItem());
        lines.reverse();
        System.out.println(lines);

        lines.setByIndex(null, 1);
        System.out.println(lines);
        System.out.println(linesCopy);

        lines.insertByIndex(null, 3);
        System.out.println(lines);
        lines.removeByIndex(3);
        System.out.println(lines);
    }
}