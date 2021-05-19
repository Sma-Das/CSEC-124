public class Inventory {
  PowerBoat A = new PowerBoat("blue", 22, 60);
  SailBoat B = new SailBoat("white", 18, 1);
  SailBoat C = new SailBoat("red", 42, 3);
  PowerBoat D = new PowerBoat("yellow", 35, 80);
  PowerBoat E = new PowerBoat("red", 50, 120);
  SailBoat F = new SailBoat("blue", 33, 2);
  PowerBoat G = new PowerBoat("white", 14, 10);
  Boat Boats[] = {A, B, C, D, E, F, G};

  public int totalPrice() {
    int total = 0;
    for (Boat B : Boats) {
      total += B.calcPrice();
    }
    return total;
  }

  public void findExpensive() {}
}
