package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private final List<String> authors = new ArrayList<>();

    public Book(String title, String category, String[] authorList, float costValue) {
        super(title, category, costValue);
        if (authorList != null) {
            for (String author : authorList) {
                addAuthor(author);
            }
        }
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book - ");
        if (!authors.isEmpty()) {
            sb.append(String.join(", ", authors)).append(" - ");
        }
        sb.append(getTitle());
        if (getCategory() != null) {
            sb.append(" - ").append(getCategory());
        }
        if (getCost() > 0) {
            sb.append(" - ").append(getCost()).append(" $");
        }

        return sb.toString();
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
