public class TestCar {

  public static void main(String[] args) {
    Car oneCar = new Car("Toyota", 2004);
    Car twoCar = new Car("Nissan", 2006);

    // checking if it exceeds 150
    for (int i = 0; i < 50; i++) {
      System.out.println(oneCar);
      oneCar.accelerate();
    }
    // checking if it goes below 0
    for (int i = 0; i < 100; i++) {
      System.out.println(oneCar);
      oneCar.brake();
    }
      
    // testing initial values
    System.out.println(twoCar.getMake());
    System.out.println(twoCar.getYear());
    System.out.println(twoCar.getSpeed());
  }
}
