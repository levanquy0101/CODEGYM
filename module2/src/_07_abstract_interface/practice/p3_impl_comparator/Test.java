package _07_abstract_interface.practice.p3_impl_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Circle[] circles = new Circle[6];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle(3.1, "indigo", false);
        circles[2] = new Circle(3.1, "indigo", false);
        circles[3] = new Circle();
        circles[4] = new Circle(1.5, "indigo", false);
        circles[5] = new Circle(4.5, "indigo", false);

        System.out.println("Pre-sorted:");
        Arrays.stream(circles).forEach(System.out::println);


        //sort normal by comparator
/*        Arrays.sort(circles, new CircleComparator());
        Collections.sort(Arrays.asList(circles), new CircleComparator());*/

        //sort by lamda, note for double cast to int; with built in Comparator.comparing
        Arrays.sort(circles, (o1, o2)-> (int)(o1.getRadius()- o2.getRadius()));
        Arrays.sort(circles, Comparator.comparing(Circle::getRadius));

        System.out.println("After-sorted:");
        Arrays.stream(circles).forEach(System.out::println);

         //sort by stream, note: list string or int have default sort comparable so just use sort without param,
         //else sort object need use sort with param comparator interface
         //stream need return to a variable for foreach
/*        Arrays.stream(circles).sorted(new CircleComparator()).forEach(System.out::println);*/
    }
}
