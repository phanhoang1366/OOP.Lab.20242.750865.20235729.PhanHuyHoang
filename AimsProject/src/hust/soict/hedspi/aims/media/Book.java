package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private final List<String> authors = new ArrayList<String>();

    public void addAuthor(String author) {
        if (!this.authors.contains(author)) {
            this.authors.add(author);
        }
        else {
            System.out.println("Author already exists in the list.");
        }
    }

    public void removeAuthor(String author) {
        if (this.authors.contains(author)) {
            this.authors.remove(author);
        }
        else {
            System.out.println("Author not found in the list.");
        }
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, float cost) {
        super(title, cost);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
}
