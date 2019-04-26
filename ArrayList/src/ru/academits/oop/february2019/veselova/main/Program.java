package ru.academits.oop.february2019.veselova.main;

import ru.academits.oop.february2019.veselova.arraylist.ArrayList;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Program {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(15);
        integers.add(10);
        integers.addAll(Arrays.asList(9, 8, 7, 6, 5));
        System.out.println(integers);
        integers.remove((Object) 8);
        integers.retainAll(Arrays.asList(10, 11, 7, 6, 5));
        System.out.println(integers);

        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();

        ArrayList<String> strings = new ArrayList<>(5);

        strings.addAll(Arrays.asList("f", "sd", "wsda", "qwerty", "sd"));
        System.out.println(strings);
        System.out.println(strings.isEmpty());

        System.out.println(strings.contains("sd"));
        System.out.println(strings.indexOf("sd"));
        System.out.println(strings.lastIndexOf("sd"));

        try {
            Iterator<String> iterator = strings.iterator();
            String next = iterator.next();
            strings.add("hi");
            String nextNext = iterator.next();
        } catch (ConcurrentModificationException e) {
            System.out.println("This is ConcurrentModificationException");
        }
        strings.removeAll(Arrays.asList("hi", "qwerty", "sd"));
        System.out.println(strings);

        strings.clear();
        System.out.println(strings.isEmpty());
    }
}