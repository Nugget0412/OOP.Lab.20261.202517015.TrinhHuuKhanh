package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc(String title, String category, String director, int length, float cost) {
        // TODO (section 10.1): call super(...) then set the two Disc fields
        super(title, category, cost);
    }

    public int getLength() {
        return 0; // TODO: return length
    }

    // TODO: getDirector()
}
