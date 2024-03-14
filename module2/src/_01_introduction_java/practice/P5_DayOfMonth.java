package _01_introduction_java.practice;

import java.util.Scanner;

public class P5_DayOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month: ");
        int m = Integer.parseInt(sc.nextLine());
        System.out.println(m==2? "28 or 29": checkMonth(m));
    }

    private static int checkMonth(int m){
        return (m==1 || m==3|| m==5 ||m==7||m==8||m==10||m==12)?31:30;
    }
}
