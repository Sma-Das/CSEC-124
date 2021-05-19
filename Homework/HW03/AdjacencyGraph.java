import java.util.*;

public class AdjacencyGraph<E> implements Graph<E> {
  private HashMap<E, Vertex<E>> vertices;

  public AdjacencyGraph() {
    this.vertices = new HashMap<E, Vertex<E>>();
  }

  public void add(E value) {
    if (!contains(value)) {
      vertices.put(value, new Vertex<E>(value));
    }
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
    if (!contains(a) || !contains(b)) {
      return false;
    }
    return vertices.get(a).connected(vertices.get(b));
  }

  public boolean BFS(E a, E b) {
    Vertex<E> A = vertices.get(a);
    Vertex<E> B = vertices.get(b);

    Set<Vertex<E>> visited = new HashSet<Vertex<E>>();

    if (A.getValue() == B.getValue()) {
      return true;
    }

    for (Vertex<E> node : A.getNeighbours()) {
      if (visited.contains(node)) {
        continue;
      }
      visited.add(node);
      if (node.getValue() == B.getValue()) {
        System.out.println(node.getValue());
        return true;
      } else if (this.BFS(node.getValue(), b, visited)) {
        System.out.println(A.getValue());
        return true;
      }
    }
    return false;
  }

  public boolean BFS(E a, E b, Set<Vertex<E>> visited) {
    Vertex<E> A = vertices.get(a);
    Vertex<E> B = vertices.get(b);

    System.out.println("A");
    System.out.println(A);
    System.out.println("B");
    System.out.println(B);

    if (A.getValue().equals(B.getValue())) {
      return true;
    }

    for (Vertex<E> node : A.getNeighbours()) {
      if (visited.contains(node)) {
        continue;
      }
      visited.add(node);
      if (node.getValue() == B.getValue()) {
        System.out.println(node.getValue());
        return true;
      } else if (this.BFS(node.getValue(), b, visited)) {
        System.out.println(A.getValue());
        return true;
      }
    }
    return false;
  }

  public HashMap<E, Vertex<E>> getVertices() {
    return vertices;
  }

  public String toString() {
    return vertices.toString();
  }
}
