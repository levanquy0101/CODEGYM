package _11_stack_queue.practice.p1_impl_stack_by_linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStackQueueBuiltin {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.forEach(System.out::println);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.forEach(System.out::println);

        System.out.println();
        System.out.println(stack.pop());
        System.out.println(queue.remove());
    }
}
