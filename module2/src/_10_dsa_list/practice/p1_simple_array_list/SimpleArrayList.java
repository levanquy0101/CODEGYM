package _10_dsa_list.practice.p1_simple_array_list;

import java.util.Arrays;

public class SimpleArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    private int size = 0;
    public SimpleArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }

        return (E) elements[i];
    }
}
