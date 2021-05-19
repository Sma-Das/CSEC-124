import java.text.DecimalFormat;

// class SailBoat
public class SailBoat extends Boat {
  // private data members
  private int numSails;

  // default constructor
  public SailBoat() {
    super();
    numSails = 1;
  }

  // parameterized constructor
  public SailBoat(String color, int length, int numSails) {
    super(color, length);
    setNumSails(numSails);
  }

  // mutator method to set numSails
  public boolean setNumSails(int numSails) {
    if (numSails >= 1 && numSails <= 4) {
      this.numSails = numSails;
      return true;
    }
    return false;
  }

  // accessor returns the numSails
  public int getNumSails() {
    return numSails;
  }

  // calculates the price of the SailBoat
  public double calcPrice() {
    return getLength() * 1000 + numSails * 2000;
  }

  // return a string
  public String toString() {
    String str = new DecimalFormat("#,###.00").format(calcPrice());
    return super.toString() + " Number of Sails = " + numSails + " Price = $" + str;
  }
}
