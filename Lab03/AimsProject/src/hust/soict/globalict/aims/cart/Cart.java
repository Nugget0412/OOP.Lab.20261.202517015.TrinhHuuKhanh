package hust.soict.globalict.aims.cart;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        // TODO (section 12): respect MAX_NUMBERS_ORDERED, reject duplicates, inform user
    }

    public void removeMedia(Media media) {
        // TODO (section 12)
    }

    public float totalCost() {
        // TODO (section 12)
        return 0f;
    }

    public void print() {
        // TODO (section 4): exact CART format from the handout, using each item's toString()
    }

    public void searchById(int id) {
        // TODO (section 4): print match or "not found"
    }

    public void searchByTitle(String title) {
        // TODO (section 4): use Media.isMatch(), print all matches or "not found"
    }

    public void sortByTitleCost() {
        // TODO (section 17): Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST)
    }

    public void sortByCostTitle() {
        // TODO (section 17)
    }

    public Media findByTitle(String title) {
        // TODO (section 18): needed by the console app; return null if absent
        return null;
    }

    public void empty() {
        // TODO (section 18): used by "Place order"
    }
}
