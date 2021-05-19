import java.util.*;

public class wAdjacency<E> implements wGraph<E> {
  private HashMap<E, wVertex<E>> vertices;

  public wAdjacency() {
    this.vertices = new HashMap<E, wVertex<E>>();
  }

  public void add(E value) {
    vertices.put(value, new wVertex<E>(value));
  }

  public boolean contains(E value) {
    return vertices.containsKey(value);
  }

  public int size() {
    return vertices.size();
  }

  public void connect(E a, E b, Double weight) {
    if (this.contains(a) && this.contains(b)) {
      vertices.get(a).connect(vertices.get(b), weight);
      vertices.get(b).connect(vertices.get(a), weight);
    }
  }

  public boolean connected(E a, E b) {
    System.out.println(vertices.get(a).getNeighbours());
    return vertices.get(a).getNeighbours().contains(vertices.get(b));
  }

  public Double weight(E a, E b) {
    return vertices.get(a).getEdge(vertices.get(b)).getWeight();
  }

  public wPath<E> dijkstrasPath(E start, E end) {
    wVertex<E> Start = vertices.get(start);
    wVertex<E> End = vertices.get(end);

    HashMap<wVertex<E>, PathTuple<E>> nodes = new HashMap<wVertex<E>, PathTuple<E>>();

    TupleQueue<E> pool = new TupleQueue<E>();

    for (wVertex<E> vertex : this.vertices.values()) {
      PathTuple<E> node = new PathTuple<E>(vertex);
      nodes.put(vertex, node);
      pool.enqueue(node);
    }
    nodes.get(Start).update(null, 0.0);

    while (pool.size() > 0) {
      PathTuple<E> vert = pool.dequeue();
      Double pathLength = vert.getDistance();

      if (pathLength == Double.MAX_VALUE) {
        break;
      }

      wVertex<E> vertNode = vert.getVertex();

      for (wVertex<E> neighbour : vert.getVertex().getNeighbours()) {
        nodes.get(neighbour).update(vertNode, vertNode.getEdge(neighbour).getWeight() + pathLength);
      }
    }

    return this.reconstructPath(nodes.get(End), nodes);
  }

  private wPath<E> reconstructPath(PathTuple<E> end, HashMap<wVertex<E>, PathTuple<E>> nodes) {
    Double totalDistance = end.getDistance();
    if (totalDistance == Double.MAX_VALUE) {
      return null;
    }

    wPath<E> path = new wPath<E>(totalDistance);

    PathTuple<E> pointer = end;

    while (pointer != null) {
      path.prepend(pointer.getVertex().getValue());
      pointer = nodes.get(pointer.getPredessor());
    }

    return path;
  }

  public String toString() {
    return vertices.toString();
  }
}
