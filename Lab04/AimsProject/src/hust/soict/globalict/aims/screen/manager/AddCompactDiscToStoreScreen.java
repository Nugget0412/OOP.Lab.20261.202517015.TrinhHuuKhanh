package hust.soict.globalict.aims.screen.manager;

import javax.swing.JTextField;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;
    private JTextField tfDirector;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");
        tfArtist = addField("Artist: ");
        tfDirector = addField("Director: ");
        setVisible(true);
    }

    @Override
    protected Media createMedia() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        String artist = tfArtist.getText();
        float cost = Float.parseFloat(tfCost.getText());
        return new CompactDisc(title, category, director, artist, cost);
    }
}
