package ru.academits.oop.february2019.veselova.program;

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

        Range intersectionAB = a.computeIntersection(b);
        print("intersection", a, b, intersectionAB);
        Range intersectionAC = a.computeIntersection(c);
        print("intersection", a, c, intersectionAC);
        Range intersectionAF = a.computeIntersection(f);
        print("intersection", a, f, intersectionAF);

        Range[] unionAB = a.computeUnion(b);
        print("union", a, b, unionAB);
        Range[] unionAC = a.computeUnion(c);
        print("union", a, c, unionAC);
        Range[] unionAF = a.computeUnion(f);
        print("union", a, f, unionAF);

        Range[] complementAB = a.computeComplement(b);
        print("complement", a, b, complementAB);
        Range[] complementAC = a.computeComplement(c);
        print("complement", a, c, complementAC);
        Range[] complementAD = a.computeComplement(d);
        print("complement", a, d, complementAD);
        Range[] complementAE = a.computeComplement(e);
        print("complement", a, e, complementAE);
        Range[] complementAF = a.computeComplement(f);
        print("complement", a, f, complementAF);
        Range[] complementAG = a.computeComplement(g);
        print("complement", a, g, complementAG);
        Range[] complementAH = a.computeComplement(h);
        print("complement", a, h, complementAH);
        Range[] complementAI = a.computeComplement(i);
        print("complement", a, i, complementAI);
    }

    private static void print(String keyWord, Range first, Range second, Range... result) {
        System.out.printf("%s of %s and %s:\t", keyWord, first.toString(), second.toString());
        if (result.length == 0) {
            System.out.print("null");
        } else {
            for (Range el : result
            ) {
                System.out.printf("%s\t", el);
            }
        }

        System.out.println();
        System.out.println();
    }
}