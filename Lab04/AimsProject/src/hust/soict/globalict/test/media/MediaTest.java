package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

/** Section 15 (equals), section 16 (polymorphism with toString) and Playable. */
public class MediaTest {

    public static void main(String[] args) {
        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Quincy Jones", "Michael Jackson", 15.5f);
        cd.addTrack(new Track("Beat It", 258));
        cd.addTrack(new Track("Billie Jean", 294));
        cd.addTrack(new Track("Beat It", 258));      // equal track -> rejected
        cd.removeTrack(new Track("Beat It", 100));   // different length -> not found

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book("Clean Code", "Programming", 32.5f);
        book.addAuthor("Robert C. Martin");
        book.addAuthor("Robert C. Martin");          // duplicate -> rejected
        book.removeAuthor("Someone Else");           // absent -> notified

        // Section 16: polymorphism
        System.out.println("\n--- Polymorphism with toString() ---");
        List<Media> mediae = new ArrayList<Media>();
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }

        // Section 15: equals
        System.out.println("\n--- equals() ---");
        System.out.println("dvd equals DVD with same title: " + dvd.equals(new DigitalVideoDisc("the lion king")));
        System.out.println("dvd equals a String: " + dvd.equals("The Lion King"));

        // Playable
        System.out.println("\n--- play() ---");
        cd.play();
        dvd.play();
        new DigitalVideoDisc("Empty DVD").play();    // length 0 -> cannot be played
    }
}
