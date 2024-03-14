package _07_abstract_interface.practice.p2_impl_comparable;

public class CircleComparable extends Circle implements Comparable<CircleComparable> {

    public CircleComparable() { }

    public CircleComparable(double radius) {
        super(radius);
    }

    public CircleComparable(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(CircleComparable o) {
//        double tmp= getRadius() - o.getRadius();
//        if(tmp > 0){
//            return 1;
//        }
//        else if(tmp < 0){
//            return -1;
//        }
//
//        return 0;

/*        shorthand*/
        return getRadius() > o.getRadius()? 1: -1;
    }
}
