package question3;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    public void perimeter() {
        System.out.println("Perimeter of Circle: " + 2 * Math.PI * this.radius);
    }

    public void scale(int scaleValue) {
        System.out.println("Scale of Circle: " + scaleValue * 2 * area());
    }
}
