import java.util.*;

// Did not implement Queue class due to excessive errors. Implemented eff. solution

public class TupleQueue<E> {
  private LinkedList<PathTuple<E>> queue;

  public TupleQueue() {
    this.queue = new LinkedList<PathTuple<E>>();
  }

  public void enqueue(PathTuple<E> element) {
    queue.add(element);
  }

  public PathTuple<E> dequeue() {
    Double min = Double.MAX_VALUE;
    PathTuple<E> best=null;
    int ind = 0, count = 0;

    for (PathTuple<E> node : queue) {
      if (node.getDistance() <= min) {
        min = node.getDistance();
        best = node;
        ind = count;
      }
      count++;
    }
    queue.remove(ind);
    return best;
  }

  public int size() {
    return queue.size();
  }

  public String toString() {
    return queue.toString();
  }
}
