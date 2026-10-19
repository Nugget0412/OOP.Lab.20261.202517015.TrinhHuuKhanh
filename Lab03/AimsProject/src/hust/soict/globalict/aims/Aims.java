package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class Aims {

    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initStore();
        boolean running = true;
        while (running) {
            showMenu();
            switch (readChoice(0, 3)) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: seeCurrentCart(); break;
                case 0: running = false; break;
                default: break;
            }
        }
        System.out.println("Goodbye!");
    }

    // ------------------------------------------------------------------ menus

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // ------------------------------------------------------------ view store

    private static void viewStore() {
        while (true) {
            store.print();
            storeMenu();
            switch (readChoice(0, 4)) {
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart(askStoreMedia()); break;
                case 3: playMedia(askStoreMedia()); break;
                case 4: seeCurrentCart(); break;
                case 0: return;
                default: break;
            }
        }
    }

    private static void seeMediaDetails() {
        Media media = askStoreMedia();
        if (media == null) {
            return;
        }
        while (true) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int choice = readChoice(0, 2);
            if (choice == 1) {
                addMediaToCart(media);
            } else if (choice == 2) {
                playMedia(media);
            } else {
                return;
            }
        }
    }

    private static Media askStoreMedia() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findByTitle(title);
        if (media == null) {
            System.out.println("No media titled \"" + title + "\" in the store.");
        }
        return media;
    }

    private static void addMediaToCart(Media media) {
        if (media == null) {
            return;
        }
        cart.addMedia(media);
        System.out.println("Number of DVDs in the current cart: " + cart.getNumberOfDVDs());
    }

    private static void playMedia(Media media) {
        if (media == null) {
            return;
        }
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("\"" + media.getTitle() + "\" is a " + media.getClass().getSimpleName()
                    + " and cannot be played. Only CDs and DVDs can be played.");
        }
    }

    // ---------------------------------------------------------- update store

    private static void updateStore() {
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        int choice = readChoice(0, 2);
        if (choice == 1) {
            Media media = readNewMedia();
            if (media != null) {
                store.addMedia(media);
            }
        } else if (choice == 2) {
            Media media = askStoreMedia();
            if (media != null) {
                store.removeMedia(media);
            }
        }
    }

    private static Media readNewMedia() {
        System.out.println("Media type: 1. Book  2. DVD  3. CD");
        int type = readChoice(1, 3);
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return null;
        }
        System.out.print("Category: ");
        String category = scanner.nextLine().trim();
        float cost = readFloat("Cost: ");

        if (type == 1) {
            System.out.print("Authors (separated by commas): ");
            Book book = new Book(title, category, cost);
            for (String a : scanner.nextLine().split(",")) {
                if (!a.trim().isEmpty()) {
                    book.addAuthor(a.trim());
                }
            }
            return book;
        }
        System.out.print("Director: ");
        String director = scanner.nextLine().trim();
        if (type == 2) {
            int length = readInt("Length: ");
            return new DigitalVideoDisc(title, category, director, length, cost);
        }
        System.out.print("Artist: ");
        String artist = scanner.nextLine().trim();
        CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
        int nTracks = readInt("Number of tracks: ");
        for (int i = 1; i <= nTracks; i++) {
            System.out.print("Track " + i + " title: ");
            String trackTitle = scanner.nextLine().trim();
            int trackLength = readInt("Track " + i + " length: ");
            cd.addTrack(new Track(trackTitle, trackLength));
        }
        return cd;
    }

    // ------------------------------------------------------------------ cart

    private static void seeCurrentCart() {
        while (true) {
            cart.print();
            cartMenu();
            switch (readChoice(0, 5)) {
                case 1: filterCart(); break;
                case 2: sortCart(); break;
                case 3: {
                    Media m = askCartMedia();
                    if (m != null) {
                        cart.removeMedia(m);
                    }
                    break;
                }
                case 4: playMedia(askCartMedia()); break;
                case 5:
                    if (cart.isEmpty()) {
                        System.out.println("The cart is empty, nothing to order.");
                    } else {
                        System.out.println("An order has been created. Thank you!");
                        cart.empty();
                    }
                    break;
                case 0: return;
                default: break;
            }
        }
    }

    private static void filterCart() {
        System.out.println("Filter by: 1. ID  2. Title");
        if (readChoice(1, 2) == 1) {
            cart.searchById(readInt("Enter ID: "));
        } else {
            System.out.print("Enter title: ");
            cart.searchByTitle(scanner.nextLine());
        }
    }

    private static void sortCart() {
        System.out.println("Sort by: 1. Title  2. Cost");
        if (readChoice(1, 2) == 1) {
            cart.sortByTitleCost();
        } else {
            cart.sortByCostTitle();
        }
    }

    private static Media askCartMedia() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = cart.findByTitle(title);
        if (media == null) {
            System.out.println("No media titled \"" + title + "\" in the cart.");
        }
        return media;
    }

    // --------------------------------------------------------------- helpers

    private static int readChoice(int min, int max) {
        while (true) {
            int value = readInt("> ");
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("\"" + line + "\" is not a valid number.");
            }
        }
    }

    private static float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Float.parseFloat(line);
            } catch (NumberFormatException e) {
                System.out.println("\"" + line + "\" is not a valid number.");
            }
        }
    }

    private static void initStore() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        Book book = new Book("Clean Code", "Programming", 32.5f,
                new ArrayList<String>(Arrays.asList("Robert C. Martin")));
        book.setContent("Clean code reads like well written prose");
        store.addMedia(book);

        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Quincy Jones", "Michael Jackson", 15.5f);
        cd.addTrack(new Track("Beat It", 258));
        cd.addTrack(new Track("Billie Jean", 294));
        store.addMedia(cd);
    }
}
