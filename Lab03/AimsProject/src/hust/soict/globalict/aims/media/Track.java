package hust.soict.globalict.aims.media;

public class Track /* TODO (section 11): implements Playable */ {
    private String title;
    private int length;

    public Track(String title, int length) {
        // TODO (section 10.2)
    }

    // TODO: getTitle(), getLength()

    // TODO (section 11): play() — refuse to play if length <= 0

    @Override
    public boolean equals(Object o) {
        // TODO (section 15): equal when title AND length are equal
        return false;
    }
}
