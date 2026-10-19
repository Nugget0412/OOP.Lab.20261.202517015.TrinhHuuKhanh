package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc /* TODO (section 11): implements Playable */ {

    // TODO (section 14): bring over your Lab02 overloaded constructors,
    // rewritten to chain to super(title, category, director, length, cost)
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    // TODO (section 11): play() — refuse to play if length <= 0

    @Override
    public String toString() {
        // TODO (section 4): "DVD - [Title] - [Category] - [Director] - [Length]: [Price] $"
        return "";
    }
}
