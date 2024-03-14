package _11_stack_queue.practice.s2_impl_queue_by_array;

import java.util.Arrays;

public class MyStackByArray {
    private Integer arr[];
    private int size;
    private int index;

    public MyStackByArray(Integer size) throws Exception{
        if(size<=0){
            throw new Exception("size have to greater than 0");
        }

        this.size = size;
        arr= new Integer[size];
    }

    public void push(Integer val){
        ensureCapacity();
        arr[index]= val;
        index++;
    }

    public int pop() throws Exception{
    if (isEmpty()) {
      throw new Exception("Stack is null");
    }

        int res= arr[--index];
        arr= Arrays.copyOf(arr, index);
        size = index;

        return res;
    }

    public int size(){
        return index;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public boolean isFull(){
        return size == index;
    }

    public void read(){
        Arrays.asList(arr).forEach(System.out::println);
    }

    private void ensureCapacity() {
        if (index >= size) {
            arr = Arrays.copyOf(arr, arr.length * 3 / 2);
        }
    }
}
