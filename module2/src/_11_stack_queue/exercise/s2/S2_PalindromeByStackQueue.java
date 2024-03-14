package _11_stack_queue.exercise.s2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class S2_PalindromeByStackQueue {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        System.out.print("Input a string: ");
        String[] st = new Scanner(System.in).nextLine().split("");

        for (int i = 0; i < st.length; i++) {
            stack.push(st[i]);
            queue.add(st[i]);
        }

        boolean res=true;
        while (!stack.isEmpty()){
            if(!stack.pop().equals(queue.remove())) {
                res = false;
                break;
            }
        }

        System.out.println(res);
    }
}
