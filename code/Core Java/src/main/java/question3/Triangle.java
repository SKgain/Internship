package question3;

public class Triangle extends Shape {
    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }


    public double area() {
        double s = (firstSide + secondSide + thirdSide) / 2;
        return Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));
    }

    public void perimeter() {
        System.out.println("Perimeter of Triangle: " + (firstSide + secondSide + thirdSide));
    }

    public void scale(int scaleValue){
        System.out.println("Scale of Triangle: " + scaleValue * 2 * area());
    }
}
