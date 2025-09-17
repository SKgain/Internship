package question8;

public class Square extends Shape {
    int height;
    int width;

    public Square(int height) {
        this.height = height;
        this.width = height;
    }

    @Override
    public void area() {
        System.out.println("Square area: " + height*width);
    }
}
