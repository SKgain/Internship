package question5;

public class StoryBookABC extends StoryBook {
    public StoryBookABC(String name, String author) {
        this.name = name;
        this.author = author;
    }
    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Author: " + this.author);
    }
}
