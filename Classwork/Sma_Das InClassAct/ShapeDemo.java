public class ShapeDemo {

  public interface Shape {
  
    double area();

    default double volume() {
      return 0.0;
    }
  }

  private double radius, width, height;

  /** Default ShapeDemo constructor */
  public ShapeDemo(double radius, double width, double height) {
    this.radius = radius;
    this.width = width;
    this.height = height;
  }

  public Shape[] makeShapes() {
    Shape circle =
        new Shape() {
          private String name = "Circle", color = "Red";

          @Override
          public double area() {
            return Math.PI * radius * radius;
          }
        };

    Shape rectangle =
        new Shape() {
          private String name = "Rectangle", color = "Blue";

          @Override
          public double area() {
            return width * height;
          }
        };

    Shape sphere =
        new Shape() {
          private String name = "Sphere", color = "Yellow";

          @Override
          public double area() {
            return 4 * Math.PI * radius * radius;
          }

          @Override
          public double volume() {
            return 4 / 3 * Math.PI * Math.pow(radius, 3);
          }
        };

    Shape triangle =
        new Shape() {
          private String name = "Triangle", color = "Green";

          @Override
          public double area() {
            return 0.5 * width * height;
          }
        };

    return new Shape[] {circle, rectangle, sphere, triangle};
  }
}
