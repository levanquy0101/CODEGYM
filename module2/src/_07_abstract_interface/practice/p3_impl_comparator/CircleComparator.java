package _07_abstract_interface.practice.p3_impl_comparator;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        return o1.getRadius()> o2.getRadius()? 1: -1;
    }
}
