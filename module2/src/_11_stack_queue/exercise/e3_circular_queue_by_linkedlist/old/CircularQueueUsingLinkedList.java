package _11_stack_queue.exercise.e3_circular_queue_by_linkedlist.old;

public class CircularQueueUsingLinkedList {
    private int size;

    public void enQueue(Queue q, int val){
        Node node= new Node();
        node.data= val;

        if(q.rear== null) {
            q.font = q.rear = node;
            size++;
            return;
        }

        q.rear.link= node;
        q.rear= node;
        q.rear.link= q.font;
        size++;
    }

    public void deQueue(Queue q){
        if(q.font!= null){
            if(q.font==q.rear){
                q.font=null;
                q.rear= null;
            }
            else {
                q.font= q.font.link;
                q.rear.link= q.font;
            }

            size--;
        }

    }

    public void displayQueue(Queue q){
//        Node tmp= q.font;
//        for (int i = 0; i < size; i++) {
//            System.out.println(tmp.data);
//            tmp= tmp.link;
//        }

        Node tmp= q.font;
        while (tmp.link!=q.font){
            System.out.println(tmp.data);
            tmp= tmp.link;
        }
        System.out.println(tmp.data);
    }

    public static void main(String[] args){
        Queue queue= new Queue();
        CircularQueueUsingLinkedList myLinkedListQueue= new CircularQueueUsingLinkedList();
        myLinkedListQueue.enQueue(queue,2);
        myLinkedListQueue.enQueue(queue,3);
        myLinkedListQueue.enQueue(queue,5);
        myLinkedListQueue.deQueue(queue);
//        myLinkedListQueue.deQueue(queue);
        myLinkedListQueue.displayQueue(queue);
    }
}
