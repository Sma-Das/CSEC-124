public class HW02Tester {
  public static void main(String[] args) {
    Weapon flowers = new Flowers();
    Weapon fists = new Fists();
    Weapon naginata = new Naginata();

    Panda panda = new Panda("Po", fists, naginata, flowers);
    for (int i = 0; i < 3; i++) {
      panda.performAttack();
      panda.levelUp();
    }
    // System.out.println(flowers);
    // System.out.println(flowers instanceof Flowers);
  }
}
