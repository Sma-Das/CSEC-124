import java.util.*;

public class wPath<E> {
  private LinkedList<E> values;
  private Double weight;

  public wPath(Double weight) {
    this.values = new LinkedList<E>();
    this.weight = weight;
  }

  public wPath(E value, Double weight) {
    this(weight);
    this.values.add(value);
  }

  public void append(E value) {
    values.add(value);
  }

  public void prepend(E value) {
    values.add(0, value);
  }

  public int size() {
    return values.size();
  }

  public Double weight() {
    return weight;
  }

  public E get(int index) {
    return values.get(index);
  }

  public String toString() {
    String output = "Path length: " + weight + "\nPath: - ";

    for (E value : values) {
      output += value.toString() + " - ";
    }

    return output;
  }
}
