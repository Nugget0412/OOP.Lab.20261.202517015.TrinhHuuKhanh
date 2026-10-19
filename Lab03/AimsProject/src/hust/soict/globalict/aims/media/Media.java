package hust.soict.globalict.aims.media;

import java.util.Comparator;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private static int nbMedia = 0;   // replaces nbDigitalVideoDiscs: one counter for all media ids

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        // TODO (section 14): assign fields, increment nbMedia, set id
    }

    // TODO (section 9): getters for id, title, category, cost (only keep setters you really need)

    public boolean isMatch(String title) {
        // TODO (section 4): reuse your Lab02 matching rule
        return false;
    }

    @Override
    public boolean equals(Object o) {
        // TODO (section 15): equal when titles are equal.
        // Think: what should happen if o is null or not a Media? (answers.txt question)
        return false;
    }

    // Each subclass overrides toString() (section 16)
}
