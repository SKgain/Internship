package question4;

public class Cow extends Animal {

    public void eat(String food) {
        System.out.println("Cow is eating " + food);
    }

    @Override
    public void sleep() {
        System.out.println("Cow is sleeping.");
    }
}
