public class Fists implements Weapon {
  private String name, color;

  // default constructor
  public Fists() {
    this.name = "Fists";
    this.color = "black";
  }
  /**
   * parameterised constructor
   *
   * @param name: name of fists
   * @param color: color of fists
   */
  public Fists(String name, String color) {
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

  public static Double randomDouble(int upper_lim) {
    return (Math.random() * upper_lim) + 1;
  }
  /**
   * attack technique for weapon
   *
   * @return Double: attack damage
   */
  public Double[] combo(int punches) {
    Double[] C = new Double[punches];

    for (int i = 0; i < punches; i++) {
      C[i] = randomDouble(10);
    }

    return C;
  }

  /**
   * Create string representation of Fists for printing
   *
   * @return
   */
  public String toString() {
    return "Fists [name=" + name + ", color=" + color + "]";
  }
}
