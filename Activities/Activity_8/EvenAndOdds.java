/**
 * @author Sma Das
 * @author Ahmad Qadourah
 * @author Adi AlGhfli
 * @author Mohammad Ashiq Vallotte
 */
public class EvenAndOdds {
  private boolean isOdd;
  private int current;
  private static final int MAX = 100;

  public EvenAndOdds() {
    this(true);
  }

  public EvenAndOdds(boolean odd) {
    this(odd, 1);
  }

  public EvenAndOdds(boolean odd, int start) {
    this.isOdd = odd;
    this.current = start;
  }

  public static void main(String[] args) {
    EvenAndOdds test = new EvenAndOdds();

    Thread odd =
        new Thread() {
          @Override
          public void run() {
            test.printOdd();
          }
        };
    Thread even =
        new Thread() {
          @Override
          public void run() {
            test.printEven();
          }
        };

    try {
      odd.start();
      even.start();
      odd.join();
      even.join();
    } catch (InterruptedException IE) {
      IE.printStackTrace();
    }
  }

  public void printOdd() {
    synchronized (this) {
      try {
        while (current < MAX) {
          while (!isOdd) wait();
          System.out.println(current);
          current++;
          isOdd = false;
          notifyAll();
        }
      } catch (InterruptedException IE) {
        IE.printStackTrace();
      }
    }
  }

  public void printEven() {
    synchronized (this) {
      try {
        while (current <= MAX) {
          while (isOdd) wait();
          System.out.println(current);
          current++;
          isOdd = true;
          notifyAll();
        }
      } catch (InterruptedException IE) {
        IE.printStackTrace();
      }
    }
  }
}
