package question9;

public class Percentage implements Discount{
    @Override
    public void calculate(double price){
        System.out.println("You are getting: " + (price-50)+"% discount");
    }
}
