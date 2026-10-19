package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        // TODO (section 8): add only if not already in the list, inform the user either way
    }

    public void removeAuthor(String authorName) {
        // TODO (section 8): remove only if present, inform the user either way
    }

    @Override
    public String toString() {
        // TODO (section 7): title, category, author list, content length (number of tokens), cost
        return "";
    }
}
