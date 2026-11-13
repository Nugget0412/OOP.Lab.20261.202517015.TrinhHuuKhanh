package hust.soict.globalict.aims.screen.manager;

import javax.swing.JTextField;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
        tfAuthors = addField("Authors (separated by commas): ");
        setVisible(true);
    }

    @Override
    protected Media createMedia() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        Book book = new Book(title, category, cost);
        for (String author : tfAuthors.getText().split(",")) {
            if (!author.trim().isEmpty()) {
                book.addAuthor(author.trim());
            }
        }
        return book;
    }
}
