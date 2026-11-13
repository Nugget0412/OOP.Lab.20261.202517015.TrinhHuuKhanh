package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("\"" + media.getTitle() + "\" is already in the store.");
            return;
        }
        itemsInStore.add(media);
        System.out.println("\"" + media.getTitle() + "\" has been added to the store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("\"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("\"" + media.getTitle() + "\" is not in the store.");
        }
    }

    public Media findByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title.trim())) {
                return m;
            }
        }
        return null;
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("(The store is empty)");
        }
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("****************************************************");
    }
}
