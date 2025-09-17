package question9;

public class DiscountStrategy {
    private final  Discount discount;
    public DiscountStrategy(Discount discount) {
        this.discount = discount;
    }

    public void checkOut(double amount){
        discount.calculate(amount);
    }
}
