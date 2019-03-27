package ru.academits.oop.february2019.veselova.list;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
    public static void removeEven(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    public static List<Integer> removeReps(ArrayList<Integer> numbers) {
        ArrayList<Integer> numbersWithoutReps = new ArrayList<>();
        for (Integer number : numbers) {
            if (!numbersWithoutReps.contains(number)) {
                numbersWithoutReps.add(number);
            }
        }
        return numbersWithoutReps;
    }
}