package hust.soict.globalict.aims.media;

import java.util.Comparator;

/** Title A-Z; for the same title, the more expensive media comes first. */
public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {
        int byTitle = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (byTitle != 0) {
            return byTitle;
        }
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
