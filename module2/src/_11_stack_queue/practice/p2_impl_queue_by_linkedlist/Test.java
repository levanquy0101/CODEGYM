package _11_stack_queue.practice.p2_impl_queue_by_linkedlist;

public class Test {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}
