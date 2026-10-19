package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // TODO (section 17): cost DECREASING; same cost → title A→Z
        return 0;
    }
}
