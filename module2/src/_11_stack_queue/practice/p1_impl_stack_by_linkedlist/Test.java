package _11_stack_queue.practice.p1_impl_stack_by_linkedlist;

public class Test {
    public static void main(String[] args) {
        System.out.println("----- Stack of integers -----");
        stackOfIntegers();

        System.out.println("----- Stack of Strings -----");
        stackOfIStrings();
    }

    private static void stackOfIntegers() {
        MyStackByLinkedList<Integer> stack = new MyStackByLinkedList();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("Size of stack after push operations: " + stack.size());
        System.out.printf("Pop elements from stack: ");

        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }

        System.out.println("\n Size of stack after pop operations : " + stack.size());
    }

    private static void stackOfIStrings() {
        MyStackByLinkedList<String> stack = new MyStackByLinkedList();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("Size of stack after push operations: " + stack.size());
        System.out.printf("Pop elements from stack : ");

        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }

        System.out.println("\nSize of stack after pop operations : " + stack.size());
    }
}
