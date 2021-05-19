public class Panda {
  String name;
  private Weapon[] weapons;
  private Weapon currentWeapon;
  private int enlightenmentLevel = 0;

  // default constructor
  public Panda(String name, Weapon[] weapons) {
    this.name = name;
    this.weapons = weapons;
    currentWeapon = weapons[0];
  }
  /**
   * Parameterised Constructor for Panda
   *
   * @param String name: name of panda
   * @param Weapon starter: starter of panda
   * @param Weapon intermediate: intermediate of panda
   * @param Weapon expert: expert of panda
   */
  public Panda(String name, Weapon starter, Weapon intermediate, Weapon expert) {
    this.name = name;
    this.weapons = new Weapon[3];
    weapons[0] = starter;
    weapons[1] = intermediate;
    weapons[2] = expert;
    currentWeapon = weapons[0];
  }

  /**
   * change weapon name
   *
   * @param String name: new weapon name
   */
  public void giveWeaponName(String name) {
    currentWeapon.setName(name);
  }
  /** increase enlightenmentLevel of panda and give them a new weapon */
  public void levelUp() {
    if (enlightenmentLevel > 2) {
      System.out.println("Your skills are already fulled developed");
    } else {
      System.out.println("Congratulations Panda! You have levelled up");
      enlightenmentLevel++;
      newCurrentWeapon();
    }
  }
  /** Make the panda perform an attack */
  public void performAttack() {
    System.out.println(currentWeapon);
    if (currentWeapon instanceof Fists) {
      fistAttack((Fists) currentWeapon);
    } else if (currentWeapon instanceof Naginata) {
      Naginata curr = (Naginata) currentWeapon;
      System.out.println(
          "I raise my mighty " + curr.getName() + " and deal " + curr.attack() + " damage!");
    } else if (currentWeapon instanceof Flowers) {
      System.out.println("I have taken away the anger from your heart, join me in the zen");
    } else {
      System.out.println("Weird weapon, dunno how to use it  ¯\\_(ツ)_/¯");
    }
  }
  /** Custom method for fist attack */
  public static void fistAttack(Fists weapon) {
    System.out.println("I am a fist wielding PANDA!");
    int punches = (int) (Math.random() * 5) + 1;
    System.out.println("I am going to punch you " + punches + " times! Feel my fury!");
    int count = 1;
    Double total = 0.0;
    for (Double punch : weapon.combo(punches)) {
      System.out.println("Attack [" + count + "] does " + punch + " damage");
      count++;
      total += punch;
    }
    System.out.println("I did " + total + " damage, make sure you count the decimals ;)");
  }
  /** change current weapon for panda */
  public void newCurrentWeapon() {
    currentWeapon = weapons[enlightenmentLevel];
  }
}
