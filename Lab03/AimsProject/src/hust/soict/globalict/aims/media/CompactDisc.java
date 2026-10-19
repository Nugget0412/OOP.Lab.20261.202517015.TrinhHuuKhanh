package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc /* TODO (section 11): implements Playable */ {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String artist, String director, float cost) {
        // CD length comes from its tracks, so pass 0 here and override getLength()
        super(title, category, director, 0, cost);
        // TODO: set artist
    }

    // TODO: getArtist()

    public void addTrack(Track track) {
        // TODO (section 10.3): check duplicates (contains() uses your equals()), inform user
    }

    public void removeTrack(Track track) {
        // TODO (section 10.3): check presence, inform user
    }

    @Override
    public int getLength() {
        // TODO (section 10.3): sum of track lengths
        return 0;
    }

    // TODO (section 11): play() — print CD title + length, then play every track

    @Override
    public String toString() {
        // TODO (section 7): CD info, then every track's info
        return "";
    }
}
