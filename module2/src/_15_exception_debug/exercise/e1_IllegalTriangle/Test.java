package _15_exception_debug.exercise.e1_IllegalTriangle;

public class Test {
    public static void main(String[] args) {
/*        Scanner scanner= new Scanner(System.in);
        System.out.printf("Input side 1: ");
        double side1= Double.parseDouble(scanner.nextLine());
        System.out.printf("Input side 2: ");
        double side2= Double.parseDouble(scanner.nextLine());
        System.out.printf("Input side 3: ");
        double side3= Double.parseDouble(scanner.nextLine());

        Triangle triangle= new Triangle(side1, side2, side3);*/

        // runtime no need try catch
        try {
            Triangle triangle = new Triangle(-1, 6, 8);
            System.out.println(triangle.getPerimeter());
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
//             do action again
//            System.out.printf("Input again");
        }
    }
}
