package ru.academits.oop.february2019.veselova.main;

import ru.academits.oop.february2019.veselova.range.Range;

public class Program {
    public static void main(String[] args) {
        Range a = new Range(12, 20);
        Range b = new Range(1, 7);

        Range c = new Range(10, 14);
        Range d = new Range(17, 25);

        Range e = new Range(14, 18);
        Range f = new Range(10, 22);

        Range g = new Range(a);
        Range h = new Range(16, 20);
        Range i = new Range(12, 14);

        Range j = new Range(20, 30);

        Range intersectionAB = a.getIntersection(b);
        print("intersection", a, b, intersectionAB);
        Range intersectionAC = a.getIntersection(c);
        print("intersection", a, c, intersectionAC);
        Range intersectionAF = a.getIntersection(f);
        print("intersection", a, f, intersectionAF);
        Range intersectionAJ = a.getIntersection(j);
        print("intersection", a, j, intersectionAJ);

        Range[] unionAB = a.getUnion(b);
        print("union", a, b, unionAB);
        Range[] unionAC = a.getUnion(c);
        print("union", a, c, unionAC);
        Range[] unionAF = a.getUnion(f);
        print("union", a, f, unionAF);
        Range[] unionAJ = a.getUnion(j);
        print("union", a, j, unionAJ);

        Range[] complementAB = a.getComplement(b);
        print("complement", a, b, complementAB);
        Range[] complementAC = a.getComplement(c);
        print("complement", a, c, complementAC);
        Range[] complementAD = a.getComplement(d);
        print("complement", a, d, complementAD);
        Range[] complementAE = a.getComplement(e);
        print("complement", a, e, complementAE);
        Range[] complementAF = a.getComplement(f);
        print("complement", a, f, complementAF);
        Range[] complementAG = a.getComplement(g);
        print("complement", a, g, complementAG);
        Range[] complementAH = a.getComplement(h);
        print("complement", a, h, complementAH);
        Range[] complementAI = a.getComplement(i);
        print("complement", a, i, complementAI);
    }

    private static void print(String keyWord, Range first, Range second, Range... result) {
        System.out.printf("%s of %s and %s:\t", keyWord, first.toString(), second.toString());
        if (result.length == 0) {
            System.out.print("null");
        } else {
            for (Range el : result) {
                System.out.printf("%s\t", el);
            }
        }

        System.out.println();
        System.out.println();
    }
}