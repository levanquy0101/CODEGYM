package _02_loop_in_java.practice;

import java.util.Scanner;

public class P2_LendingBank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        double money = input.nextDouble();
        System.out.println("Enter number of months: ");
        int month = input.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        double interest_rate = input.nextDouble();

        double total= 0;

        for(int i = 0; i < month; i++){
            total += money * (interest_rate/100)/12 * month;
        }

        System.out.println("Total of interset: " + total);

    }
}
