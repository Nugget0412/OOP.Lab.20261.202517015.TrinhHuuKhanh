package hust.soict.globalict.aims.media;

public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        if (length <= 0) {
            System.out.println("Track \"" + title + "\" cannot be played (length is " + length + ").");
            return;
        }
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
    }

    /** Two tracks are equal when both title and length are equal. */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Track)) {
            return false;
        }
        Track other = (Track) o;
        return length == other.length && title != null && title.equalsIgnoreCase(other.title);
    }

    @Override
    public int hashCode() {
        return 31 * (title == null ? 0 : title.toLowerCase().hashCode()) + length;
    }

    @Override
    public String toString() {
        return "Track - " + title + " - " + length;
    }
}
