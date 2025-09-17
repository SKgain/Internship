package question8;

public class Rectangle extends Shape {
    private int height;
    private int width;
    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void area() {
        System.out.println("Rectangle area: " + height*width);
    }
}
