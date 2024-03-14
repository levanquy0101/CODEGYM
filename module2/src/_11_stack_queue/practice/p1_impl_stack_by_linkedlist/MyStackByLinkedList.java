package _11_stack_queue.practice.p1_impl_stack_by_linkedlist;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackByLinkedList<T> {
    private final LinkedList<T> stack;

    public MyStackByLinkedList() {
        stack = new LinkedList<>();
    }

    public void push(T element) {
        stack.addFirst(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
