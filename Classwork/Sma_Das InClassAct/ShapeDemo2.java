public class ShapeDemo2 {
  public abstract class Shape {
    private String name, color;

    public Shape(String name, String color) {
      this.name = name;
      this.color = color;
    }

    public double volume() {
      return 0.0;
    }

    public abstract double area();

    @Override
    public String toString() {
      return "name = " + name + "\ncolor= " + color + "\narea= " + area() + "\nvolume= " + volume();
    }
  }

  private double radius, width, height;

  /** Default ShapeDemo constructor */
  public ShapeDemo2(double radius, double width, double height) {
    this.radius = radius;
    this.width = width;
    this.height = height;
  }

  public Shape[] makeShapes() {
    Shape circle =
        new Shape("Circle", "Red") {
          @Override
          public double area() {
            return Math.PI * radius * radius;
          }
        };

    Shape rectangle =
        new Shape("Rectangle", "Blue") {
          @Override
          public double area() {
            return width * height;
          }
        };

    Shape sphere =
        new Shape("Sphere", "Yellow") {

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
        new Shape("Triangle", "Green") {
          @Override
          public double area() {
            return 0.5 * width * height;
          }
        };

    return new Shape[] {circle, rectangle, sphere, triangle};
  }
}
