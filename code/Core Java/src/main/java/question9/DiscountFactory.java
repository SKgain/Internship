package question9;

public class DiscountFactory {
    public Discount factory(String type) {
        switch (type) {
            case "percent"-> {
                return new Percentage();
            }
            case "flat"-> {
                return new Flat();
            }
            case "bogo"-> {
                return new Bogo();
            }
            default -> {
                return null;
            }
        }
    }
}
