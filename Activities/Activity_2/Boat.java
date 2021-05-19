public class Boat {
  private String color;
  private int length;

  public Boat() {
    color = "white";
    length = 20;
  }

  public Boat(String _color, int _length) {
    setColor(_color);
    setLength(_length);
  }

  /**
   * Returns value of color
   *
   * @return
   */
  public String getColor() {
    return color;
  }

  /**
   * Sets new value of color
   *
   * @param _color
   * @return boolean
   */
  public boolean setColor(String _color) {
    if (color.equals("white")
        || color.equals("blue")
        || color.equals("red")
        || color.equals("yellow")) {
      color = _color;
      return true;
    }
    return false;
  }

  /**
   * Returns value of length
   *
   * @return
   */
  public int getLength() {
    return length;
  }

  /**
   * Sets new value of length
   *
   * @param
   */
  public boolean setLength(int _length) {
    if (_length < 20) {
      System.out.println("Too small of a length");
      return false;
    } else if (_length > 50) {
      System.out.println("Too large of a length");
      return false;
    } else {
      length = _length;
      return true;
    }
  }

  public String toString() {
    return String.format("Color = %s Length =  %d", color, length);
  }
}
