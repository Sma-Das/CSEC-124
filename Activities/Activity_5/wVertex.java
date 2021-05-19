import java.util.*;

public class wVertex<E> {
  private E value;
  private HashMap<wVertex<E>, Edge<E>> neighbours;

  public wVertex(E value) {
    this.value = value;
    neighbours = new HashMap<wVertex<E>, Edge<E>>();
  }

  public E getValue() {
    return value;
  }

  public void connect(wVertex<E> newNeighbour, Double weight) {
    neighbours.put(newNeighbour, new Edge<E>(weight, this, newNeighbour));
  }

  public Edge<E> getEdge(wVertex<E> neighbour) {
    return neighbours.get(neighbour);
  }

  public HashSet<Edge<E>> edges() {
    ArrayList<Edge<E>> edges = new ArrayList<Edge<E>>(neighbours.values());
    Collections.sort(edges);
    return new HashSet<Edge<E>>(edges);
  }

  public Set<wVertex<E>> getNeighbours() {
    return neighbours.keySet();
  }

  public String toString() {
    return "" + value;
  }
}
