package _10_dsa_list.exercise.e1_impl_arraylist;

import java.util.Arrays;

public class CustomArrayList<E> implements Cloneable {
  private int DEFAULT_CAPACITY = 10;
  private E[] elements;
  private int size;

  CustomArrayList() {
    elements = (E[]) new Object[DEFAULT_CAPACITY];
  }

  CustomArrayList(int initCapacity) {
    elements = (E[]) new Object[initCapacity];
  }

  void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    ensureCapacity();

    for (int i = size; i > index; i--) {
      elements[i] = elements[i - 1];
    }

    elements[index] = element;
    size++;
  }

  boolean add(E e) {
    add(size, e);
    //        ensureCapacity();
    //        elements[size] = e;
    //        size++;
    return true;
  }

  E remove(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }

    E res = elements[index];
    if(size > 1){
      E[] tmp = (E[]) new Object[size - 1];

      for (int i = 0, j = 0; i < size; i++) {
        if (i != index) {
          tmp[j++] = elements[i];
        }
      }

      elements = tmp;
      size--;
    }
    else{
      //qq cannot init arr with size 0
      clear();
    }

    return res;

    /*        // the way two
    for (int j = 0, k = 0; j < size; j++) {
        if (j == i)
            continue;
        tmp[k++] = data[j];
    }*/
  }

  int size() {
    return size;
  }

  E get(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    return elements[index];
  }

  boolean contains(E e) {
    for (int i = 0; i < size; i++) {
      if (elements[i].equals(e)) {
        return true;
      }
    }

    return false;
  }

  int indexOf(E e) {
    for (int i = 0; i < size; i++) {
      if (elements[i].equals(e)) {
        return i;
      }
    }

    return -1;
  }

  void clear() {
    size = 0;
    elements = (E[]) new Object[DEFAULT_CAPACITY];
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  private void ensureCapacity() {
    if (size >= elements.length) {
      elements = Arrays.copyOf(elements, elements.length * 3 / 2);
    }
  }
}
