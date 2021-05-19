import java.util.*;

public class TupleQueue2<E> implements Queue<PathTuple<E>> {
  private LinkedList<PathTuple<E>> queue;

  public TupleQueue() {
    this.queue = new LinkedList<PathTuple<E>>();
  }

  public void enqueue(PathTuple<E> element) {
    queue.add(element);
  }

  public boolean add(PathTuple<E> element) {
    return queue.add(element);
  }

  public PathTuple<E> dequeue() {
    Double min = Double.MAX_VALUE;
    PathTuple<E> best = null;

    for (PathTuple<E> node : queue) {
      if (node.getDistance() <= min) {
        min = node.getDistance();
        best = node;
      }
    }
    return best;
  }

  public int size() {
    return queue.size();
  }

  public PathTuple<E> peek() {
    throw new UnsupportedOperationException();
  }

  public boolean offer(PathTuple<E> element) {
    throw new UnsupportedOperationException();
  }

  public PathTuple<E> element() {
    throw new UnsupportedOperationException();
  }

  public PathTuple<E> poll() {
    throw new UnsupportedOperationException();
  }

  public PathTuple<E> remove() {
    throw new UnsupportedOperationException();
  }

  public void clear() {
    throw new UnsupportedOperationException();
  }

  public PathTuple<e> retainAll(Collection<?> e) {
    throw new UnsupportedOperationException();
  }
}
