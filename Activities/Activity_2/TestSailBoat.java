// class TestSailBoat
public class TestSailBoat {
  // main method
  public static void main(String[] args) {
    SailBoat sboat = new SailBoat("red", 25, 2);
    System.out.println(sboat);

    if (!sboat.setColor("purple")) {
      System.out.println("\nError: Boats can only be white, red, blue, or yellow.");
    }

    if (!sboat.setLength(55)) {
      System.out.println("\nError: Sail Boats can only be between 20 and 50 feet, inclusively.");
    }
  }
}
