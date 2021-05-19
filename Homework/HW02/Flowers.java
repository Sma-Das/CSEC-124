public class Flowers implements Weapon {
  private String name, color;
  // default constructor
  public Flowers() {
    this.name = "Flowers";
    this.color = "Pink and Blue";
  }
  /**
   * parameterised constructor
   *
   * @param name: name of flowers
   * @param color: color of flowers
   */
  public Flowers(String name, String color) {
    this.name = name;
    this.color = color;
  }

  /**
   * getter for name
   *
   * @return String:name
   */
  public String getName() {
    return name;
  }
  /**
   * getter for color
   *
   * @return String:color
   */
  public String getColor() {
    return color;
  }
  /**
   * setter for color
   *
   * @param String:color
   */
  public void setColor(String color) {
    this.color = color;
  }
  /**
   * setter for name
   *
   * @param String:name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Create string representation of Flowers for printing
   *
   * @return
   */
  public String toString() {
    return "Flowers [name=" + name + ", color=" + color + "]";
  }
}
