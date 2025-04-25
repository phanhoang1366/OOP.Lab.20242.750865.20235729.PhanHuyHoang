package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength() + " minutes");
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, float cost) {
        super(title, cost);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("DVD - ");
        result.append(getTitle());
        if (getCategory() != null) {
            result.append(" - ").append(getCategory());
        }
        if (getDirector() != null) {
            result.append(" - ").append(getDirector());
        }
        if (getLength() > 0) {
            result.append(" - ").append(getLength());
        }
        result.append(": ").append(getCost()).append(" $");
        return result.toString();
    }



}

