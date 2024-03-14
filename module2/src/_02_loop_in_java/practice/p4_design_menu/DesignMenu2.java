package _02_loop_in_java.practice.p4_design_menu;

import java.util.Scanner;

public class DesignMenu2 {
  public static void main(String[] args) {
    System.out.println("--- Menu ---");
    System.out.println("1. Draw the triangle");
    System.out.println("2. Draw the triangle inverted");
    System.out.println("3. Draw the square");
    System.out.println("4. Draw the rectangle");
    System.out.println("5. Exit");
    System.out.println("Enter your choice: ");
    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();
    printlnMenu(choice);
  }

  private static void printlnMenu(int choice) {
    int length = 10;
    switch (choice) {
      case 1:
        for (int i = 0; i < length; i++) {

          for (int j = 0; j <= i; j++) {
            System.out.print("*");
          }

          System.out.println();
        }
        break;

        //      for (int i = length; i >0 ; i--) {
        //        for (int j = 0; j < length-i; j++) {
        //          System.out.print("*");
        //        }
        //        System.out.println("*");
        //      }
        //      break;

      case 2:
        for (int i = 0; i < length; i++) {
          for (int j = 0; j < length - i; j++) {
            System.out.print("*");
          }
          System.out.println();
        }

        break;
      case 3:
        for (int i = 0; i < length; i++) {

          for (int j = 0; j < length; j++) {
            System.out.printf("%-3s", "*");
          }

          System.out.println();
        }
        break;
      case 4:
        for (int i = 0; i < length /2; i++) {

          for (int j = 0; j < length; j++) {
            System.out.printf("%-3s", "*");
          }

          System.out.println();
        }
        break;
      case 5:
        System.exit(0);
    }
  }
}
