package _03_array_and_method.exercise.e1_remove_element;

import java.util.Scanner;

public class RemoveElement1 {
  public static void main(String[] args) {
    int[] a = {10, 4, 5, 6, 7, 8, 6};

    System.out.print("Enter value to remove:");
    Scanner scanner = new Scanner(System.in);
    int value = scanner.nextInt();

    int index = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == value) {
        index = i;
        break;
      }
    }

    for (int i = index; i < a.length - 1; i++) {
      a[i] = a[i + 1];
    }

    for (int i = 0; i < a.length - 1; i++) {
      System.out.println(a[i]);
    }
  }
}
