package _10_dsa_list.exercise.e2_impl_linkedlist;

public class CustomLinkedList<E> implements Cloneable {
  private Node<E> head;
  private int numNodes;

  public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E e) {
      data = e;
      next = null;
    }

    public Node(E e, Node nodeRef) {
      data = e;
      next = nodeRef;
    }

    public E getData() {
      return data;
    }
  }

  void addFirst(E e) {
    Node tmp = head;

    head = new Node(e, tmp);

    //    head = new Node(e);
    //    head.next = tmp;

    numNodes++;
  }

  void addLast(E e) {
    Node tmp = head;

    if (tmp == null) {
      addFirst(e);
    } else {
      while (tmp.next != null) {
        tmp = tmp.next;
      }

      tmp.next = new Node(e);
    }

    numNodes++;
  }

  void add(int index, E e) {
    if (index < 0 || numNodes > numNodes) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      addFirst(e);
    } else {
      Node tmp = head;
      for (int i = 0; i < index - 1; i++) {
        tmp = tmp.next;
      }

      Node node = new Node(e, tmp.next);
      tmp.next = node;
    }

    numNodes++;
  }

  E get(int index) {
    if (index < 0 || numNodes > numNodes) {
      throw new IndexOutOfBoundsException();
    }

    Node<E> tmp = head;
    if (tmp.next == null) {
      return getFirst();
    }

    for (int i = 0; i < index; i++) {
      tmp = tmp.next;
    }

    return tmp.data;
  }

  E getFirst() {
    return head != null ? head.data : null;
  }

  E getLast() {
    Node<E> tmp = head;

    if (tmp.next == null) {
      return getFirst();
    }

    while (tmp.next != null) {
      tmp = tmp.next;
    }

    return tmp.data;
  }

  void clear() {
    numNodes = 0;
    head = null;
  }

  boolean contains(E e) {
    Node tmp = head;

    if (tmp != null) {
      do {
        if (tmp.data.equals(e)) {
          return true;
        }

        tmp = tmp.next;
      } while (tmp != null);
    }

    return false;
  }

  int indexOf(E e) {
    Node tmp = head;

    if (tmp != null) {
      for (int i = 0; i < numNodes; i++) {
        if (tmp.data.equals(e)) {
          return i;
        }

        tmp = tmp.next;
      }
    }

    return -1;
  }

  E removeFirst() {
    E result = head.data;

    if (head.next != null) {
      head = head.next;
    } else {
      head = null;
    }

    numNodes--;
    return result;
  }

  E removeLast() {
    E result = null;
    Node tmp = head;

    if (tmp.next != null) {
      while (tmp.next.next != null) {
        tmp = tmp.next;
      }

      result = (E) tmp.data;
      tmp.next = null;
    } else {
      result = removeFirst();
    }

    numNodes--;
    return result;
  }

  public E remove(int index) {
    E result = null;
    Node tmp = head;

    if (index == 0) {
      removeFirst();
    } else {
      for (int i = 0; i < index - 1; i++) {
        tmp = tmp.next;
      }

      result = (E) tmp.next.data;
      tmp.next = tmp.next.next;
    }

    numNodes--;
    return result;
  }

  int size() {
    return numNodes;
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
