/**
 * Implementation of a generic Node {Activity 4}
 *
 * @author Das, Sma
 * @author Darwish, Haithem
 * @author El Labban, Wissam
 * @author Alshamsi, Ahlam
 */
class Node<T> {
  private T data;
  private Node prev;
  private Node next;

  /**
   * Default constructor for Node class
   *
   * @param T data, generic data type
   */
  public Node(T data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }

  /**
   * Setter for next
   *
   * @param Node next, next node
   */
  public void setNext(Node<T> next) {
    this.next = next;
  }

  /**
   * Setter for prev
   *
   * @param Node prev, previous node
   */
  public void setPrev(Node<T> prev) {
    this.prev = prev;
  }

  /**
   * Getter for data
   *
   * @return T data
   */
  public T getData() {
    return data;
  }

  /**
   * Getter for next
   *
   * @return Node next, next node
   */
  public Node<T> Next() {
    return next;
  }

  /**
   * Getter for prev
   *
   * @return Node prev, previous node
   */
  public Node<T> Prev() {
    return prev;
  }

  /**
   * toString representation of Node class
   *
   * @return String
   */
  public String toString() {
    return "[data=" + data + "]";
  }
}
