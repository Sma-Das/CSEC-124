import java.util.HashSet;

public class Vertex<E> {
  private E value;
  private HashSet<Vertex<E>> neighbours;

  public Vertex(E value) {
    this.value = value;
    neighbours = new HashSet<Vertex<E>>();
  }

  public E getValue() {
    return value;
  }

  public void connect(Vertex<E> neighbour) {
    neighbours.add(neighbour);
  }

  public boolean connected(Vertex<E> neighbour) {
    return neighbours.contains(neighbour);
  }

  public HashSet<Vertex<E>> getNeighbours() {
    return neighbours;
  }
}
