package _03_array_and_method.practice.p1_reserve_array;

import java.util.Scanner;

public class ReserveArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20){
                System.out.println("Size does not exceed 20");
            }
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < size) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }

        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < size; j++) {
            System.out.print(array[j] + "\t");
        }

        for (int j = 0; j < size/2; j++) {
            int tmp= array[j];
            array[j]= array[size-j-1];
            array[size-j-1]= tmp;
        }

        System.out.printf("%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
