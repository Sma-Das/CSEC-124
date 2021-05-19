import java.util.*;

class Fibonacci implements Range {
  private int size;

  public Fibonacci() {
    this.size = 20;
  }

  public Fibonacci(int size) {
    this.size = size;
  }

  public int get(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
    
    Double golden_ratio = (1 + Math.sqrt(5)) / 2; // (1+√5)/2

    // O(1)

    Double term1 = Math.pow(golden_ratio, index);

    Double term2 = Math.pow(1 - golden_ratio, index);

    return (int) ((term1 - term2) / Math.sqrt(5));
  }

  public int size() {
    return size;
  }

  public Iterator<Integer> iterator() {
    return new RangeIterator(this);
  }

  public static void main(String[] args) {
    Fibonacci test = new Fibonacci(45);

    for (int t : test) {
      System.out.println(t);
    }
  }
}
