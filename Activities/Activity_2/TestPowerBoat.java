public class TestPowerBoat {
  public static void main(String[] args) {
    PowerBoat powerBoat = new PowerBoat();
    PowerBoat powerBoat2 = new PowerBoat("blue", 32, 275);

    System.out.println(powerBoat);

    powerBoat.setEngineSize(375);
    System.out.println(powerBoat);

    powerBoat.setEngineSize(0);
    System.out.println(powerBoat);

    powerBoat.setEngineSize(250);
    System.out.println(powerBoat);

    powerBoat2.setEngineSize(375);
    System.out.println(powerBoat2);

    powerBoat2.setEngineSize(0);
    System.out.println(powerBoat2);

    powerBoat2.setEngineSize(250);
    System.out.println(powerBoat2);
  }
}
