package _07_abstract_interface.exercise.e1_impl_resizeable;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        Resizeable[] arr= new Resizeable[3];
        Shape[] arr = new Shape[3];
        arr[0]= new Circle(5, "red", true);
        arr[1]= new Rectangle("yellow", false, 5, 9);
        arr[2]= new Square(15,"blue", false);

//        for (Resizeable e: arr){
        for(Shape e : arr){
            if(!(e instanceof Square)){
                e.resize((new Random()).nextInt(100));
                System.out.println(e);
            }
        }
    }
}
