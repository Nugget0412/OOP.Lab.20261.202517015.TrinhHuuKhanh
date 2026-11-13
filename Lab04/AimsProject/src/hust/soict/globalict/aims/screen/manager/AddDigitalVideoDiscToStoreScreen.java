package hust.soict.globalict.aims.screen.manager;

import javax.swing.JTextField;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");
        tfDirector = addField("Director: ");
        tfLength = addField("Length: ");
        setVisible(true);
    }

    @Override
    protected Media createMedia() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        float cost = Float.parseFloat(tfCost.getText());
        return new DigitalVideoDisc(title, category, director, length, cost);
    }
}
