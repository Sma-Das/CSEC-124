public class Car {
  private String make;
  private int year;
  private double speed = 0;

  public Car(String m, int y) {
    this.make = m;
    this.year = y;
  }

  public String toString() {
    return String.format("A %d %s that is going %.1f mph", year, make, speed);
  }
  /**
   * Increases variable speed
   *
   * <p>Increases it by 5, up to 150
   */
  public void accelerate() {
    if (speed < 150) {
      speed += 5;
    }
  }
  /**
   * Decreases variable speed
   *
   * <p>Decreases it by 5, up to 150
   */
  public void brake() {
    if (speed > 0) {
      speed -= 5;
    }
  }

  /**
   * Returns value of make
   *
   * @return Brand name of the car
   */
  public String getMake() {
    return make;
  }
  /*
   * Returns value of year
   *
   * @return Year of manufacture
   */
  public int getYear() {
    return year;
  }
  /*
   * Returns value of speed
   *
   * @return speed of the car
   */
  public double getSpeed() {
    return speed;
  }
}
