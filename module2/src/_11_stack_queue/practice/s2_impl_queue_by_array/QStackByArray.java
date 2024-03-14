package _11_stack_queue.practice.s2_impl_queue_by_array;

import java.util.Arrays;

public class QStackByArray<T> {
    private T[] stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    QStackByArray(){
        stack = (T[])new Object[DEFAULT_CAPACITY];
    }

    QStackByArray(int capacity) {
        stack = (T[])new Object[capacity];
    }

    void push(T t){
        ensureCapacity();
        stack[size] = t;
        size++;
    }

    T peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        return stack[size -1];
    }

    T pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        T result = stack[size - 1];
        if(size > 1){
            stack = Arrays.copyOf(stack, size -1);
            size--;
        }
        else{
            clear();
        }

        return result;
    }

    boolean isEmpty(){
        return size == 0;
    }

    void clear(){
        size = 0;
        stack  = (T[])new Object[DEFAULT_CAPACITY];
    }

    void ensureCapacity(){
        if(size >= stack.length){
            stack = Arrays.copyOf(stack, size * 3/2);
        }
    }
}
