package _07_abstract_interface.exercise.e2_impl_colorable;

public class Test {
    public static void main(String[] args) {
        Shape[] arr = new Shape[3];
        arr[0]= new Circle(5, "red", true);
        arr[1]= new Rectangle("yellow", false, 5, 9);
        arr[2]= new Square(15,"blue", false);

        for(Shape s : arr){
            System.out.println(s.getClass().getSimpleName() + " with perimeter: " + s.getPerimeter());

            if(s instanceof Square){
                ((Square) s).howToColor();
            }
        }
    }
}
