package _02_loop_in_java.exercise;

import java.util.Scanner;

public class E1_DisplaySharp {
    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            display(choice);
        }
    }

    private static void display(int a) {
        switch (a) {
            case 1:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print("*");
                    }

                    System.out.println();
                }
                break;
            case 2:
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print("*");
                    }

                    System.out.println();
                }
                break;
            case 3:
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7 - i; j++) {
                        System.out.print("*");
                    }

                    System.out.println();
                }
                ;
                break;
            default:
                System.exit(0);
        }
    }
}
