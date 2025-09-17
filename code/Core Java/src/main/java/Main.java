import java.lang.*;

import question1.Employee;
import question10.User;
import question2.Book;
import question3.Circle;
import question3.Rectangle;
import question3.Shape;
import question3.Triangle;
import question4.Cat;
import question4.Cow;
import question5.Author;
import question5.StoryBookABC;
import question6.*;
import question7.Order;
import question7.OrderLine;
import question8.Square;
import question9.Discount;
import question9.DiscountFactory;
import question9.DiscountStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println();
        System.out.println("..Question1..");
        System.out.println();
        Employee employee = new Employee("22103320", "Saikat", "CSE", "Uttara");
        System.out.println(employee.hashCode());
        System.out.println(employee);
        System.out.println(employee.getDepartment());
        System.out.println(employee.getAddress());

        System.out.println();
        System.out.println("..Question2..");
        System.out.println();
        Book book1 = new Book("ISBN 101");
        Book book2 = new Book("ISBN 101");
        Book book3 = new Book("ISBN 103");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        System.out.println("Size of book set: " + bookSet.size());

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        System.out.println("Size of book list: " + bookList.size());


        System.out.println();
        System.out.println("..Question3..");
        System.out.println();
        Shape circle = new Circle(4);
        System.out.println("Area of Circle: " + circle.area());
        circle.perimeter();
        circle.scale(2);

        Shape rectangle = new Rectangle(4, 4);
        System.out.println("Area of Rectangle: " + rectangle.area());
        rectangle.perimeter();
        rectangle.scale(2);

        Shape triangle = new Triangle(4, 4, 4);
        System.out.println("Area of Triangle: " + triangle.area());
        triangle.perimeter();
        triangle.scale(2);

        System.out.println();
        System.out.println("..Question4..");
        System.out.println();

        Cow cow = new Cow();
        cow.eat("Grass");
        cow.sleep();

        Cat cat = new Cat();
        cat.eat("Milk");
        cat.sleep();

        System.out.println();
        System.out.println("..Question5..");
        System.out.println();

        StoryBookABC storyBookABC = new StoryBookABC("ABC", "Saikat");
        storyBookABC.display();

        Author author = new Author("Rifat", storyBookABC);
        author.display();

        System.out.println();
        System.out.println("..Question6..");
        System.out.println();

        Account account = AccountFactory.createAccount("Current");
        assert account != null;
        account.getName();

        System.out.println();
        System.out.println("..Question7..");
        System.out.println();

        Order original = new Order();
        original.addLine(new OrderLine("Book"));


        Order shallow = (Order) original.clone();
        shallow.lines.get(0).product = "Pen";


        Order deep = new Order(original);
        deep.lines.get(0).product = "Laptop";

        System.out.println("Original after shallow change: " + original.lines.get(0).product);
        System.out.println("Original after deep change: " + original.lines.get(0).product);


        System.out.println();
        System.out.println("..Question8..");
        System.out.println();

        Square square = new Square(4);
        square.area();

        question8.Rectangle rect = new question8.Rectangle(2,4);
        rect.area();


        System.out.println();
        System.out.println("..Question9..");
        System.out.println();

        DiscountFactory discountFactory = new DiscountFactory();
        Discount discountType = discountFactory.factory("bogo");
        DiscountStrategy discountStrategy = new DiscountStrategy(discountType);
        discountStrategy.checkOut(500);

        System.out.println();
        System.out.println("..Question10..");
        System.out.println();

        User user1 = new User("admin", "saikat@gmai.com","1234*1234");
        user1.display();
        System.out.println();
        User user2 = new User("user", "saikat@gmai.com","1234*1234");
        user2.display();
        System.out.println();
        User user3 = new User("admin", "saikatgmai.com","1234*1234");
        user3.display();
        System.out.println();
        User user4 = new User("admin", "saikat@gmai.com","1234*");
        user4.display();
        System.out.println();
        User user5 = new User("admin", "saikat@gmai.com","12341234");
        user5.display();

    }
}
