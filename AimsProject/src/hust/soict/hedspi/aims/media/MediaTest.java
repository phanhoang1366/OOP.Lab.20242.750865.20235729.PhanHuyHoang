package hust.soict.hedspi.aims.media;

import java.util.List;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediaList = List.of(
                new CompactDisc("CD1", "Pop", "Artist1", 75, 10.0f),
                new DigitalVideoDisc("DVD1", "Action", "Director1", 120, 15.0f),
                new Book("Book1", "Fiction", 20.0f)
        );

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
