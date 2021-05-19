import java.util.*;

class IntRange implements Range {
  private int start;
  private int stop;
  private int step = 1;

  public IntRange(int stop) {
    this.start = 0;
    this.stop = stop;
  }

  public IntRange(int start, int stop) {
    this.start = start;
    this.stop = stop;
  }

  public IntRange(int start, int stop, int step) {
    this.start = start;
    this.stop = stop;
    this.step = step;
  }

  public int size() {
    return (int) (stop - start) / step + 1; // +1 for the first number
  }

  public int get(int index) {
    if (index >= size()) {
      throw new IndexOutOfBoundsException();
    }

    return start + step * (index);
  }

  public Iterator<Integer> iterator() {
    return new RangeIterator(this);
  }

  public static void main(String[] args) {
    IntRange test1 = new IntRange(10);
    IntRange test2 = new IntRange(1, 5);
    IntRange test3 = new IntRange(1, 50, 2);

    System.out.println("Size test1: " + test1.size());
    System.out.println("Size test2: " + test2.size());
    System.out.println("Size test3: " + test3.size());

    for (Integer t : test1) {
      System.out.println(t);
    }

    Iterator<Integer> test2It = test2.iterator();

    while (test2It.hasNext()) {
      System.out.println(test2It.next());
    }
  }
}
