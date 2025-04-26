package hust.soict.hedspi.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private final String title;
    private final int length; // in seconds

    public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + calculateLength());
    }

    public String calculateLength() {
        int minutes = length / 60;
        int seconds = length % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Track track = (Track) obj;

        if (length != track.length) return false;
        return Objects.equals(title, track.title);
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

}
