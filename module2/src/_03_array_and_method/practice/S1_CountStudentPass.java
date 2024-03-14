package _03_array_and_method.practice;

import java.util.Scanner;

public class S1_CountStudentPass {
    public static void main(String[] args) {
        int size;
        int[] array;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 30){
                System.out.println("Size should not exceed 30");
            }
        } while (size > 30);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            int mark= scanner.nextInt();
            if(mark>10 || mark<0){
                System.out.println("Cannot greater than 10 or less than 0");
            }
            else {
                array[i]= mark;
                i++;
            }
        }

        int count = 0;
        System.out.print("List of mark: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10)
                count++;
        }

        System.out.print("\n The number of students passing the exam is " + count);
    }
}
