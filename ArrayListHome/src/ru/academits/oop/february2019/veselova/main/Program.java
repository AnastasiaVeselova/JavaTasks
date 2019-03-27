package ru.academits.oop.february2019.veselova.main;

import ru.academits.oop.february2019.veselova.list.NumberList;
import ru.academits.oop.february2019.veselova.reader.ReadingFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        System.out.println(ReadingFile.readFile("ArrayListHome/src/input.txt"));

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        NumberList.removeEven(numbers);
        System.out.println(numbers);

        ArrayList<Integer> numbersWithReps = new ArrayList<>(Arrays.asList(1,3,5,3,6,6,6,1,2,2,4,4,2,1,7));
        System.out.println(NumberList.removeReps(numbersWithReps));
    }
}
