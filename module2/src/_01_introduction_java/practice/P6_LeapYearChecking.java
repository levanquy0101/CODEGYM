package _01_introduction_java.practice;

import java.util.Scanner;

public class P6_LeapYearChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the year:");
        int y = sc.nextInt();
        System.out.println(y%4== 0? y%100==0 ?y%400==0:true: false);
    }
}
