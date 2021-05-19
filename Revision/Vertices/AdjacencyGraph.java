import java.util.HashMap;

public class AdjacencyGraph<E> implements Graph<E> {
  private HashMap<E, Vertex<E>> vertices;

  public void add(E value) {
    vertices.put(value, new Vertex<E>(value));
  }

  public boolean contains(E value) {
    return vertices.containsKey(value);
  }

  public int size() {
    return vertices.size();
  }

  public void connectDirected(E a, E b) {
    Vertex<E> A = vertices.get(a);
    Vertex<E> B = vertices.get(b);

    A.connect(B);
  }

  public void connectUndirected(E a, E b) {
    Vertex<E> A = vertices.get(a);
    Vertex<E> B = vertices.get(b);

    A.connect(B);
    B.connect(A);
  }

  public boolean connected(E a, E b) {
    return vertices.get(a).connected(vertices.get(b));
  }
}
