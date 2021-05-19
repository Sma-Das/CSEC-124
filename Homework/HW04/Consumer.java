import java.util.*;

/** @author Sma Das Homework 4 */
public class Consumer extends Thread {
  private int id;
  private LinkedList queue;

  /** parameterised constructor for Consumer */
  public Consumer(int id, LinkedList queue) {
    this.id = id;
    this.queue = queue;
  }

  public Consumer(int id) {
    this(id, new LinkedList<String>());
  }

  @Override
  public void run() {
    while (true) {
      synchronized (queue) {
        if (queue.isEmpty()) {
          System.out.println("Queue is empty");
          try {
            queue.wait();
            continue;
          } catch (InterruptedException err) {
            System.err.println(err.getMessage());
          }
        }

        String out = (String) queue.pop();
        System.out.println("Customer: " + id + " message: " + out);
      }
    }
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList<String>(Arrays.asList("Hello", "Bye"));

    Consumer consumer = new Consumer(0, list);

    consumer.start();
  }
}
