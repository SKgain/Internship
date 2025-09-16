import java.lang.*;

import question1.Employee;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
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


    }
}
