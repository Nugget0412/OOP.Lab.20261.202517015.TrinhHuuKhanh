package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book = new Book("Clean Code", "Programming", 32.5f);

        System.out.println("--- Add ---");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(new DigitalVideoDisc("star wars")); // duplicate title -> rejected
        store.print();

        System.out.println("--- Remove ---");
        store.removeMedia(dvd2);
        store.removeMedia(dvd2); // already removed -> notified
        store.print();
    }
}
