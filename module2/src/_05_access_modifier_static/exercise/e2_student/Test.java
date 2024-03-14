package _05_access_modifier_static.exercise.e2_student;

public class Test {
    public static void main(String[] args) {
        Student student= new Student();
        student.setName("David");
        student.setClasses("C04");
        System.out.println(student);
    }
}
