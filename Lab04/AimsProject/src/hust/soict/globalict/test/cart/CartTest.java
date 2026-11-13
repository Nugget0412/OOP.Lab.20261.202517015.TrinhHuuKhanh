package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {

    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Test the print method
        cart.print();

        // Test the search methods
        System.out.println("\n--- Search by ID ---");
        cart.searchById(dvd2.getId());   // found
        cart.searchById(999);            // not found

        System.out.println("\n--- Search by title ---");
        cart.searchByTitle("lion");      // found (case-insensitive)
        cart.searchByTitle("Batman");    // not found

        System.out.println("\n--- Sort by title, then cost ---");
        cart.sortByTitleCost();
        cart.print();

        System.out.println("\n--- Sort by cost, then title ---");
        cart.sortByCostTitle();
        cart.print();
    }
}
