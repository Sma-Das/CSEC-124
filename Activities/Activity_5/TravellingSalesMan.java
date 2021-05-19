import java.io.*;
import java.util.*;

/**
 * Activity 5
 *
 * @author Das, Sma
 * @author Darwish, Haithem
 * @author Qadourah, Ahmad
 * @author Alshamsi, Ahlam
 */
public class TravellingSalesMan {
  public static void main(String[] args) {
    ArrayList<City> cities = readFromCSV("52cities.csv");
    wAdjacency<City> map = makeMap(cities);

    Scanner scanner = new Scanner(System.in);

    while (true) {

      System.out.println("Enter origin city: ");
      String origin = scanner.nextLine();
      City Origin = parseInput(origin, cities);
      if (Origin == null) {
        System.out.println("Invalid Origin City");
        continue;
      }

      System.out.println("Enter destination city: ");
      String dest = scanner.nextLine();
      City Dest = parseInput(dest, cities);
      if (Dest == null) {
        System.out.println("Invalid Destination City");
        continue;
      }

      System.out.println(map.nearestNeighbour(Origin, Dest));
    }
  }

  public static ArrayList<City> readFromCSV(String fileName) {
    ArrayList<City> output = new ArrayList<City>();
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File(fileName));
      scanner.nextLine().split(",");
      while (scanner.hasNextLine()) {
        String[] line = scanner.nextLine().split(",");
        Double latitude = Double.parseDouble(line[2]);
        Double longitude = Double.parseDouble(line[3]);
        output.add(new City(line[0], line[1], latitude, longitude));
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally {
      scanner.close();
    }
    return output;
  }

  public static wAdjacency<City> makeMap(ArrayList<City> cities) {
    wAdjacency<City> map = new wAdjacency<City>();

    for (City city : cities) {
      map.add(city);
    }

    for (int i = 0; i < cities.size(); i++) {
      City currCity = cities.get(i);
      for (int j = i + 1; j < cities.size(); j++) {
        City newCity = cities.get(j);
        map.connect(currCity, newCity, currCity.distanceFrom(newCity));
      }
    }

    return map;
  }

  public static City parseInput(String input, ArrayList<City> cities) {
    if (input == null || input.length() == 0) {
      System.out.println("Thank you for using the program");
      System.exit(0);
    }
    String[] cityName = input.split(",");
    if (cityName.length != 2) {
      return null;
    }

    City city = new City(cityName[0], cityName[1]);

    for (City validCity : cities) {
      if (validCity.equals(city)) {
        return validCity;
      }
    }

    System.out.println("City not found, try again");
    return null;
  }
}
