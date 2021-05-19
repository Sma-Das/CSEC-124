public class PathTuple<E> {
  private wVertex<E> vertex, predessor;
  private Double totalDistance;

  public PathTuple(wVertex<E> vertex) {
    this.vertex = vertex;
    this.predessor = null;
    this.totalDistance = Double.MAX_VALUE;
  }

  public wVertex<E> getVertex() {
    return vertex;
  }

  public Double getDistance() {
    return totalDistance;
  }

  public wVertex<E> getPredessor() {
    return predessor;
  }

  public void update(wVertex<E> predessor, Double distance) {
    if (distance < totalDistance) {
      this.predessor = predessor;
      this.totalDistance = distance;
    }
  }

  public String toString() {
    String dist = totalDistance.toString();
    if (totalDistance == Double.MAX_VALUE) {
      dist = "infinity";
    }
    return vertex + ":(" + predessor + "," + dist + ")";
  }
}
