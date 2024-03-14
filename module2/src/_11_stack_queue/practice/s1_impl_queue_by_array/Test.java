package _11_stack_queue.practice.s1_impl_queue_by_array;

public class Test {
  public static void main(String[] args) {
//    MyQueueByArray myQueue = new MyQueueByArray(3);
//    myQueue.enqueue(1);
//    myQueue.dequeue();
//    myQueue.enqueue(8);
//    myQueue.enqueue(4);
//    System.out.println(myQueue.getHead());
//    System.out.println(myQueue.getTail());
//    myQueue.dequeue();
//    myQueue.dequeue();
//    myQueue.read();
//    System.out.println(myQueue.getCurrentSize());
//    System.out.println(myQueue.isEmpty());
//    System.out.println(myQueue.isFull());

    QQueueByArray<Integer> queue = new QQueueByArray<>(3);
    queue.enqueue(1);
    queue.dequeue();
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.isEmpty());
    System.out.println(queue.size());
  }
}
