public interface wGraph<E> {

  void add(E value);

  boolean contains(E value);

  int size();

  void connect(E a, E b, Double weight);

  boolean connected(E a, E b);

  Double weight(E a, E b);

  default wPath<E> nearestNeighbour(E start, E end) {
    throw new UnsupportedOperationException();
  }

  default wPath<E> dijkstrasPath(E start, E end) {
    throw new UnsupportedOperationException();
  }
}
