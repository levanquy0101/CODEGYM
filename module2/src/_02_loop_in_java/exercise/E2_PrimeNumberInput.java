package _02_loop_in_java.exercise;

import java.util.Scanner;

public class E2_PrimeNumberInput {
    public static void main(String[] args) {
        System.out.println("Input number prime display:");
        Scanner scanner= new Scanner(System.in);
        int number= scanner.nextInt();
        int count= 0;
        int start=1;
        do
        {
            start++;
            if(isPrime(start)){
                System.out.println(start);
                count++;
            }
        }while (number>count);
    }

    private static boolean isPrime(int val){
        for (int i = 2; i < val; i++){
            if(val % i==0){
                return false;
            }
        }

        return true;
    }
}
