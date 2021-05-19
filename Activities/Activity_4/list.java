/**
 * Implementation of a generic interface list {Activity 4}
 *
 * @author Das, Sma
 * @author Darwish, Haithem
 * @author El Labban, Wissam
 * @author Alshamsi, Ahlam
 */
interface list<T> {
  /**
   * Size of the list
   *
   * @return int size
   */
  int getSize();

  /**
   * add an element to the list
   *
   * @param T data
   */
  void append(T data);

  /**
   * get a Node at a specific index
   *
   * @param int index
   * @return Node
   */
  Node get(int index);

  /**
   * set the value of a node at a specific index
   *
   * @param int index - index of the new node
   * @param T data, generic type of the data
   */
  void set(int index, T data);
}
