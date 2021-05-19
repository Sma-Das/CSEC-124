public class Main {
   public static void main(String[] args) {
      ShapeDemo test = new ShapeDemo(1.1, 2.2, 3.3);
      
      for (ShapeDemo.Shape shape: test.makeShapes()) {
         System.out.println(shape.area());
      }
      
      ShapeDemo2 test2 = new ShapeDemo2(1.1, 2.2, 3.3);
      
      
      System.out.println("ShapeDemo2");
      for (ShapeDemo2.Shape shape: test2.makeShapes()) {
         System.out.println(shape);
      }
      
      test("Hello");
   }
   
   public static void test( Object...args){
      System.out.println(args);
      }
}