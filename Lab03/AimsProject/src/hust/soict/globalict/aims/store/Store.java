package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {
    // Section 5 uses an array of DVDs; section 13 changes it to this. Final version shown.
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        // TODO (section 13)
    }

    public void removeMedia(Media media) {
        // TODO (section 13)
    }

    public Media findByTitle(String title) {
        // TODO (section 18)
        return null;
    }

    public void print() {
        // TODO (section 18): list every item for "View store"
    }
}
