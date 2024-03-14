package _07_abstract_interface.practice.p2_impl_comparable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        CircleComparable[] circles = new CircleComparable[8];
        circles[0] = new CircleComparable(3.6);
        circles[1] = new CircleComparable(3.1, "indigoA", false);
        circles[2] = new CircleComparable(3.1, "indigoB", false);
        circles[3] = new CircleComparable();
        circles[4] = new CircleComparable(1.5, "indigoC", false);
        circles[5] = new CircleComparable(4.5, "indigoD", false);
        circles[6] = new CircleComparable(3.1, "indigoE", false);
        circles[7] = new CircleComparable(3.6, "indigoE", false);

        System.out.println("Pre-sorted:");
        for (CircleComparable circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (CircleComparable circle : circles) {
            System.out.println(circle);
        }
    }
}
