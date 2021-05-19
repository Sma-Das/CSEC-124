import java.util.*;

/**
 * CSEC.124.601 HW03
 *
 * @author Sma Das
 * @author Haithem Darwish
 * @author Pragun Khanna
 * @author Wissam El Labban
 */
public class Mother {
  public static List findMothers(AdjacencyGraph<String> graph, List values) {
    List<Vertex<String>> mothers = new ArrayList<Vertex<String>>(); // list of mothers

    Set<Vertex<String>> visited = new HashSet<Vertex<String>>(); // visited nodes
    int visitedNode = 0; // how many visited
    for (Vertex<String> value : graph.getVertices().values()) {
      for (Vertex<String> neigh : value.getNeighbours()) {
        if (!visited.contains(neigh)) {
          visitedNode++;
          visited.add(neigh); // add new neighbours
        }
        for (Vertex<String> n : value.getNeighbours()) {
          if (!visited.contains(n)) {
            visitedNode++;
            visited.add(neigh); // add neighbours' neighbours
          }
        }
      }
      if (visitedNode == values.size()) {
        mothers.add(value);
      }
      visited = new HashSet<Vertex<String>>();
    }
    return mothers;
  }

  public static void main(String[] args) {
    // no time to implement tests
  }
}
