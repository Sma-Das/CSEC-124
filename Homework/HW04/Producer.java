import java.util.*;

/** @author Sma Das Homework 4 */
public class Producer extends Thread {
  private int id;
  private LinkedList<String> queue;
  /** parameterised constructor for Producer */
  public Producer(int id, LinkedList<String> queue) {
    this.id = id;
    this.queue = queue;
  }

  public Producer(int id) {
    this(id, new LinkedList<String>());
  }

  @Override
  public void run() {
    try {
      while (true) {
        synchronized (queue) {
          if (queue.isEmpty()) {
            this.addToList();
          }
          queue.notifyAll();
          Thread.sleep(100);
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  /** adds numbers to the queue as random messages */
  public void addToList() {
    for (int i = 0; i < (Math.random() * 4 + 1); i++) {
      queue.add(id + ":" + i);
    }
    System.out.println("Loaded list, size: " + queue.size());
  }

  public static void main(String[] args) {
    LinkedList<String> queue = new LinkedList<String>(Arrays.asList("Hello", "Bye"));
    Producer producer1 = new Producer(0, queue);
    Producer producer2 = new Producer(1, queue);

    for (int i = 0; i < 5; i++) {
      new Consumer(i, queue).start();
    }

    producer1.start();
    producer2.start();
  }
}
