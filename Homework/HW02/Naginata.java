public class Naginata implements Weapon {
  private String name, color;

  // default constructor
  public Naginata() {
    this.name = "Naginata";
    this.color = "Blue";
  }

  /**
   * parameterised constructor
   *
   * @param name: name of naginata
   * @param color: color of naginata
   */
  public Naginata(String name, String color) {
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
   * attack technique for weapon
   *
   * @return Double: attack damage
   */
  public Double attack() {
    return (Math.random() * 100) + 1;
  }

  /**
   * Create string representation of Naginata for printing
   *
   * @return
   */
  public String toString() {
    return "Naginata [name=" + name + ", color=" + color + "]";
  }
}
