package ru.academits.oop.february2019.veselova.main;

import ru.academits.oop.february2019.veselova.vector.Vector;

public class Program {
    public static void main(String[] args) {
        Vector v1 = new Vector(new double[]{1, 2, 3, 4, 5});

        Vector v2 = new Vector(3, new double[]{1, 2, 3, 4});

        Vector v3 = new Vector(v2);

        Vector v4 = new Vector(4);

        Vector v5 = new Vector(new double[]{10, 20});

        System.out.printf("%s - %s = ", v1, v2);
        v1.subtractVector(v2);
        System.out.printf("%s\n\n", v1);

        System.out.printf("%s - %s = ", v5, v3);
        v5.subtractVector(v3);
        System.out.printf("%s\n\n", v5);

        System.out.printf("10 * %s = ", v2);
        v2.multiplyByScalar(10);
        System.out.printf("%s\n\n", v2);

        System.out.printf("- %s = ", v3);
        v3.revertVector();
        System.out.printf("%s\n\n", v3);

        v4.setComponentByIndex(0, 0);
        v4.setComponentByIndex(1, -1);
        v4.setComponentByIndex(2, -2);
        v4.setComponentByIndex(3, -3);

        System.out.printf("v4  = %s\n\n", v4);


        Vector v6 = new Vector(v5);

        System.out.printf("%s == %s ? %b\n\n", v5, v6, v5.equals(v6));

        System.out.printf("%s == %s ? %b\n\n", v2, v3, v2.equals(v3));

        System.out.printf("%s + %s = %s\n\n", v1, v2, Vector.add(v1, v2));

        System.out.printf("%s + %s = %s\n\n", v5, v4, Vector.add(v5, v4));

        System.out.printf("%s * %s = %f\n", v2, v3, Vector.scalarProduct(v2, v3));
    }
}