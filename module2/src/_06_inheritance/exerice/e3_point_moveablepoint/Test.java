package _06_inheritance.exerice.e3_point_moveablepoint;

public class Test {
    public static void main(String[] args) {
        Point2D point2D= new Point2D(3,9);
        System.out.println(point2D);

        MoveablePoint moveablePoint= new MoveablePoint(2,5,7,9);
        System.out.println(moveablePoint.move());
    }
}
