package hust.soict.globalict.aims.media;

import java.util.Comparator;

public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private static int nbMedia = 0;

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        this.id = ++nbMedia;
    }

    public Media(String title) {
        this();
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Kept because TestPassingParameter (debug exercise) changes a title
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    /**
     * Title matching rule (from Lab 02): case-insensitive, the media matches
     * if its title contains the given keyword.
     */
    public boolean isMatch(String title) {
        if (title == null || this.title == null) {
            return false;
        }
        return this.title.toLowerCase().contains(title.trim().toLowerCase());
    }

    /** Two media are equal when they have the same title. */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Media)) {
            return false; // not a Media: never equal (no ClassCastException)
        }
        Media other = (Media) o;
        return title != null && title.equalsIgnoreCase(other.title);
    }

    @Override
    public int hashCode() {
        return title == null ? 0 : title.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + title + " - " + category + ": " + cost + " $";
    }
}
