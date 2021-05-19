/**
 * Activity 5
 *
 * @author Das, Sma
 * @author Darwish, Haithem
 * @author Qadourah, Ahmad
 * @author Alshamsi, Ahlam
 */
public class City {
  private String name, state;
  private Double latitude, longitude;

  /** Default empty City constructor */
  public City() {
    this("Dubai", "Dubai", 0.0, 0.0);
  }

  public City(String name, String state) {
    this(name, state, 0.0, 0.0);
  }

  /** Default City constructor */
  public City(String name, String state, Double latitude, Double longitude) {
    this.name = name;
    this.state = state;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * equals method for City, does not check for Long and Lat values
   *
   * @return boolean
   */
  public boolean equals(Object other) {
    if (!(other instanceof City)) {
      return false;
    }

    City city = (City) other;

    if (!city.getName().equalsIgnoreCase(name)) {
      return false;
    } else if (!city.getState().equalsIgnoreCase(state)) {
      return false;
    }
    return true;
  }

  /**
   * Returns value of name
   *
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Returns value of state
   *
   * @return
   */
  public String getState() {
    return state;
  }

  /**
   * Returns value of latitude
   *
   * @return
   */
  public Double getLatitude() {
    return latitude;
  }

  /**
   * Returns value of longitude
   *
   * @return
   */
  public Double getLongitude() {
    return longitude;
  }

  /**
   * @param City otherCity
   * @return Double distance from this city to other city
   */
  public Double distanceFrom(City otherCity) {
    return Math.sqrt(
        Math.pow(longitude - otherCity.getLongitude(), 2)
            + Math.pow(latitude - otherCity.getLatitude(), 2));
  }

  public String toString() {
    return name + ", " + state;
  }
}
