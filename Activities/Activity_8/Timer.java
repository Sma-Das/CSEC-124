import java.util.*;

/**
 * @author Sma Das
 * @author Ahmad Qadourah
 * @author Adi AlGhfli
 * @author Mohammad Ashiq Vallotte
 *     <p>The Vector will run slower as it it synced, whereas the ArrayList is not. Synchronized
 *     objects run slower than non-synced objects. Vector also grows by 100% whenever it needs to
 *     increase size. ArrayList grows by 50% which can aid better performance and Arraylists are
 *     also fail-fast.
 */
public class Timer {
  public static void main(String[] args) {
    final int numValues = 1000000;
    new Thread() {
      @Override
      public void run() {
        fillNumValues("Arraylist", new ArrayList<Integer>(), numValues);
      }
    }.start();
    new Thread() {
      @Override
      public void run() {
        fillNumValues("Vector", new Vector<Integer>(), numValues);
      }
    }.start();
  }

  public static void fillNumValues(String name, List<Integer> list, int numValues) {
    long start_time = System.nanoTime();
    for (int i = 0; i < numValues; i++) {
      list.add(i);
    }
    long total_time = System.nanoTime() - start_time;
    System.out.println(
        String.format("Filled %s with %d values in %,dns", name, numValues, total_time));
  }
}
