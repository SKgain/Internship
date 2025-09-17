package question9;

public class Bogo implements Discount{
    @Override
    public void calculate(double price) {
        System.out.println("You are getting by two get one free discount");
    }
}
