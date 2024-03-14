package _11_stack_queue.practice.s1_impl_queue_by_array;

public class MyQueueByArray {
    private static final int CAPACITY = 10;
    private int queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueueByArray(){
        queueArr = new int[CAPACITY];
    }

    public MyQueueByArray(int capacity) {
        queueArr= new int[capacity];
    }

    public void enqueue(int val){
        if(isFull())
            throw  new IndexOutOfBoundsException();

        if(isEmpty()){
            head=tail=val;
        }
        else {
            tail=val;
        }

        queueArr[currentSize]= val;
        currentSize++;
    }

    // bug if dequeue then enqueue, because of create new arr with length -1
    // fix remove isfull and implement ensureCapacity
    public void dequeue(){
        if(!isEmpty()){
            int[] tmp= new int[currentSize -1];
            System.arraycopy(queueArr,1,tmp, 0, currentSize-1);
            queueArr= tmp;
            currentSize--;

            if(currentSize > 0){
                tail= queueArr[currentSize-1];
            }
        }
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    // qg not have isfull, because not have ensure capcity
    public boolean isFull(){
        return currentSize == CAPACITY;
    }

    // qg should be not have read
    public void read(){
        for (int i = 0; i < currentSize; i++) {
            System.out.println(queueArr[i]);
        }
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
