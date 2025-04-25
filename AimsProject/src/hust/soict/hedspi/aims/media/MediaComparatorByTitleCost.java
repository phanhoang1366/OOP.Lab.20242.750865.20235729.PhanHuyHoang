package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        if (media1.getTitle() != null && media2.getTitle() != null) {
            int titleComparison = media1.getTitle().compareTo(media2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
        }
        return Float.compare(media1.getCost(), media2.getCost());
    }
}
