package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, String artist,
                       float cost, ArrayList<Track> tracks) {
        this(title, category, director, artist, cost);
        if (tracks != null) {
            for (Track t : tracks) {
                addTrack(t);
            }
        }
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD.");
            return;
        }
        tracks.add(track);
        System.out.println("Track \"" + track.getTitle() + "\" has been added to the CD.");
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD.");
            return;
        }
        tracks.remove(track);
        System.out.println("Track \"" + track.getTitle() + "\" has been removed from the CD.");
    }

    /** The length of a CD is the sum of the lengths of its tracks. */
    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("CD \"" + getTitle() + "\" cannot be played (length is " + getLength() + ").");
            return;
        }
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle()).append(" - ").append(getCategory())
          .append(" - ").append(artist).append(" - ").append(getDirector())
          .append(" - ").append(getLength()).append(": ").append(getCost()).append(" $");
        for (Track t : tracks) {
            sb.append("\n      ").append(t.toString());
        }
        return sb.toString();
    }
}
