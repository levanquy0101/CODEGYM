package _11_stack_queue.practice.s1_impl_queue_by_array;

import java.util.Arrays;

public class QQueueByArray<T> {
  private T[] queue;
  private int size;
  private int CAPACITY = 10;

  QQueueByArray() {
    queue = (T[]) new Object[CAPACITY];
  }

  QQueueByArray(int capacity) {
    queue = (T[]) new Object[capacity];
    this.CAPACITY = capacity;
  }

  void enqueue(T t) {
    ensureCapacity();
    queue[size] = t;
    size++;
  }

  T dequeue() {
    if (isEmpty()) {
      // exeption run time not need throws
      throw new IndexOutOfBoundsException("Queue is null");
    }

    T res = queue[0];
    if(size > 1){
      queue = Arrays.copyOfRange(queue, 1, size);
      size--;
    }
    else{
      clear();
    }

    return res;
  }

  boolean isEmpty() {
    return size == 0;
  }

  // not isFull in queue
  /*boolean isFull(){
      return CAPACITY == size;
  }*/

  int size() {
    return size;
  }

  void clear(){
    size = 0;
    queue = (T[]) new Object[CAPACITY];
  }

  void ensureCapacity() {
    if (queue.length <= size) {
      queue = Arrays.copyOf(queue, queue.length * 3 / 2);
    }
  }
}
