/**
 * Implementation of a generic linked list {Activity 4}
 *
 * @author Das, Sma
 * @author Darwish, Haithem
 * @author El Labban, Wissam
 * @author Alshamsi, Ahlam
 */
class linkedlist<T> implements list<T> {
  private Node head;
  private Node tail;
  private int size;

  /** Default construstor for linkedlist */
  public linkedlist() {
    this.head = null;
    this.tail = null;
    size = 0;
  }

  /** @return size of the linkedlist */
  public int getSize() {
    return this.size;
  }

  /** @param data Object to be added to the list */
  public void append(T data) {
    Node newNode = new Node(data);
    if (size == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.setNext(newNode);
      newNode.setPrev(tail);
      tail = newNode;
    }
    size++;
  }

  /**
   * @param index of the node
   * @return Node if found
   */
  public Node get(int index) {
    int counter = 0;
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    } else {
      Node pointer = head;
      while (counter < index) {
        pointer = pointer.Next();
        counter++;
      }
      return pointer;
    }
  }
  /**
   * @param int index, index of the node you want to override
   * @param Object data, the new data of the object
   */
  public void set(int index, T data) {
    Node newNode = new Node(data);
    int counter = 0;
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    } else {
      Node pointer = head;
      while (counter < index) {
        pointer = pointer.Next();
        counter++;
      }
      Node prevNode = pointer.Prev();
      Node nextNode = pointer.Next();
      prevNode.setNext(newNode);
      newNode.setNext(nextNode);
    }

    // A -> B -> C
    // A -> D -> C
  }
  /**
   * toString representation of the class
   *
   * @return String
   */
  public String toString() {
    return "linkedlist [head=" + head + ", tail=" + tail + ", size=" + size + "]";
  }
}
