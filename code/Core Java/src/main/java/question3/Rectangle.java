package question3;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public void perimeter() {
        System.out.println("Perimeter of Rectangle: " + 2 * (width + height));
    }

    public void scale(int scaleValue) {
        System.out.println("Scale of Rectangle: " + scaleValue * 2 * area());
    }
}
