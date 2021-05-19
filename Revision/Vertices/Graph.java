public interface Graph<E> {
  void add(E value);

  boolean contains(E value);

  int size();

  void connectDirected(E a, E b);

  void connectUndirected(E a, E b);

  boolean connected(E a, E b);
}
