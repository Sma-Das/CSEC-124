public class Edge<E> implements Comparable<Edge> {
  private Double weight;
  private wVertex<E> from, to;

  public Edge(Double weight, wVertex<E> from, wVertex<E> to) {
    this.weight = weight;
    this.from = from;
    this.to = to;
  }

  public Double getWeight() {
    return weight;
  }

  public int compareTo(Edge other) {
    if (weight == other.getWeight()) {
      return -1;
    }
    return (int) (weight - other.getWeight());
  }

  public wVertex<E> getFrom() {
    return from;
  }

  public wVertex<E> getTo() {
    return to;
  }
  
  public String toString() {
     return "Weight: "+weight+" from: "+from.toString() +" to: "+to.toString(); 
  }
}
