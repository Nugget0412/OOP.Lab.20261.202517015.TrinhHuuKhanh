package hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Cannot add \"" + media.getTitle() + "\".");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("\"" + media.getTitle() + "\" is already in the cart.");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("\"" + media.getTitle() + "\" has been added to the cart.");
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("\"" + media.getTitle() + "\" has been removed from the cart.");
        } else {
            System.out.println("\"" + media.getTitle() + "\" is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public int getNumberOfDVDs() {
        int count = 0;
        for (Media m : itemsOrdered) {
            if (m instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public boolean isEmpty() {
        return itemsOrdered.isEmpty();
    }

    public void empty() {
        itemsOrdered.clear();
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("(The cart is empty)");
        }
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f $%n", totalCost());
        System.out.println("***************************************************");
    }

    public Media searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found: " + m);
                return m;
            }
        }
        System.out.println("No media with ID " + id + " in the cart.");
        return null;
    }

    public List<Media> searchByTitle(String title) {
        List<Media> results = new ArrayList<Media>();
        for (Media m : itemsOrdered) {
            if (m.isMatch(title)) {
                results.add(m);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No media matching \"" + title + "\" in the cart.");
        } else {
            for (Media m : results) {
                System.out.println("Found: " + m);
            }
        }
        return results;
    }

    /** Exact (case-insensitive) title lookup, used by the console menus. */
    public Media findByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title.trim())) {
                return m;
            }
        }
        return null;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}
