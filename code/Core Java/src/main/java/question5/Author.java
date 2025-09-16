package question5;

public class Author {
    public String name;
    public StoryBook book;

    public Author(String name, StoryBook book) {
        this.name = name;
        this.book = book;
    }

    public void display() {
        System.out.println("Author name: "+ this.name);
        System.out.println("Book name: "+ this.book.name);
    }
}
