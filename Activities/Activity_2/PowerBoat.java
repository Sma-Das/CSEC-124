public class PowerBoat extends Boat {
  private int engineSize;

  public PowerBoat() {
    super();
    engineSize = 5;
  }

  public PowerBoat(String _color, int _length, int _engineSize) {
    super(_color, _length);
    setEngineSize(_engineSize);
  }
  /**
   * Returns value of engineSize
   *
   * @return
   */
  public int getEngineSize() {
    return engineSize;
  }

  /**
   * Sets new value of engineSize
   *
   * @param
   */
  public boolean setEngineSize(int _engineSize) {
    if (_engineSize > 350) {
      System.out.println("Error: That engine is too powerful, must be between 5 - 350");
      return false;
    } else if (_engineSize < 5) {
      System.out.println("Error, that engine is too weak, must be between 5 - 350");
      return false;
    } else {
      engineSize = _engineSize;
      return true;
    }
  }

  public int calcPrice() {
    return 5000 + super.getLength() * 300 + engineSize * 20;
  }

  public String toString() {
    return super.toString() + " Engine Size = " + engineSize + " Price = " + calcPrice();
  }
}
