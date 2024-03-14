package _11_stack_queue.practice.s2_impl_queue_by_array;

public class Test {
  public static void main(String[] args) throws Exception {
    //    MyStackByArray myStack = new MyStackByArray(5);
    //    myStack.push(1);
    //    System.out.println(myStack.pop());
    //    myStack.push(2);
    //    myStack.push(3);
    //
    //    System.out.println(myStack.size());
    //    System.out.println(myStack.size());
    //
    //    myStack.push(13);
    //
    //    myStack.push(4);
    //    myStack.push(5);
    //
    //    myStack.read();
    //    while (!myStack.isEmpty()) {
    //      System.out.printf("After: %d", myStack.pop());
    //    }

    QStackByArray<Integer> stack = new QStackByArray<>();
    stack.push(1);
    stack.pop();
    stack.push(2);
    stack.push(3);

    while(!stack.isEmpty()){
      System.out.println(stack.pop());
    }
  }
}
