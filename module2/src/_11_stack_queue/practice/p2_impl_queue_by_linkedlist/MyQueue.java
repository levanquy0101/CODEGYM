package _11_stack_queue.practice.p2_impl_queue_by_linkedlist;

public class MyQueue {
    private Node head;
    private Node tail;

    public MyQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key) {
        Node temp = new Node(key);

        // ref head, tail to heap with one value tmp
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }

        // link tail.next = tmp
        this.tail.next = temp;

        // just assign again tail
        this.tail = temp;
    }

    public Node dequeue() {
        if (this.head == null){
            return null;
        }

        Node temp = this.head;
        this.head = this.head.next;

        if (this.head == null){
            this.tail = null;
        }

        return temp;
    }
}
