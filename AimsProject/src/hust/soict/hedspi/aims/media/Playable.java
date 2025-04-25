package hust.soict.hedspi.aims.media;

public interface Playable {
    default void play() {
        System.out.println("Playing media...");
    }
}
