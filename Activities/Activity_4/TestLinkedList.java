class TestLinkedList {

  public static void main(String[] s) {
    linkedlist<String> LL = new linkedlist<String>();

    LL.append("Sma");
    LL.append("Haithem");
    LL.append("Ahlam");
    LL.append("Wissem");
    
    System.out.println(LL);

    try {
      System.out.println("Get element at 2nd index");
      System.out.println(LL.get(2));
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Out of bounds");
    }

    try {
      System.out.println("Get element at 4th index");
      System.out.println(LL.get(4));
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Out of bounds");
    }
  }
}
