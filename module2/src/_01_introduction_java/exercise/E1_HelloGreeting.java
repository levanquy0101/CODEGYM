package _01_introduction_java.exercise;

import java.util.Scanner;

public class E1_HelloGreeting {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello: " + name);
    }
}
