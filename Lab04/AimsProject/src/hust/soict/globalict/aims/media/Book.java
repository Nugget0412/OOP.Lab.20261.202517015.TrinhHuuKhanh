package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();
    private String content = "";

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        if (authors != null) {
            for (String a : authors) {
                addAuthor(a);
            }
        }
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author \"" + authorName + "\" is already in the list.");
            return;
        }
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author \"" + authorName + "\" is not in the list.");
            return;
        }
        authors.remove(authorName);
    }

    public void setContent(String content) {
        this.content = content == null ? "" : content;
    }

    /** Content length = number of tokens (words) in the content. */
    public int getContentLength() {
        String trimmed = content.trim();
        return trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors
                + " - Content length: " + getContentLength() + " tokens: " + getCost() + " $";
    }
}
