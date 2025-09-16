package question4;

public class Cat extends Animal {

    public void eat(String food) {
        System.out.println("Cat is eating " + food);
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping.");
    }
}
