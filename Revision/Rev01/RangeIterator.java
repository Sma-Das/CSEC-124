import java.util.*;

class RangeIterator implements Iterator<Integer> {
  private int count;
  private Range range;

  public RangeIterator(Range range) {
    count = 0;
    this.range = range;
  }

  public boolean hasNext() {
    return count < range.size();
  }

  public Integer next() {
    if (hasNext()) {
      int current = range.get(count);
      count++;
      return current;
    }
    throw new NoSuchElementException();
  }
}
