package _11_stack_queue.exercise.s1;

import java.util.Scanner;
import java.util.Stack;

public class S1_ConvertDecimalToBinary {
    public static void main(String[] args) {
        System.out.print("Input a number: ");
        int input = new Scanner(System.in).nextInt();

        Stack<Integer> res = new Stack<>();
        while (input != 0) {
            res.push(input % 2);
            input /= 2;
        }

        while (!res.isEmpty()){
            System.out.print(res.pop());
        }

//        System.out.println(Integer.toBinaryString(3));
    }
}
