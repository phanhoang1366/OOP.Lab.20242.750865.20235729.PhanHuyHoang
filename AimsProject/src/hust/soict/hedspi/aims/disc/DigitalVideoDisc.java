package hust.soict.hedspi.aims.disc;


public class DigitalVideoDisc {
    private final int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // public DigitalVideoDisc() {
    //     this.id = nbDigitalVideoDiscs.getNbDiscs();
    //     nbDigitalVideoDiscs.increment();
    // }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = nbDigitalVideoDiscs.getNbDiscs();
        nbDigitalVideoDiscs.increment();
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs.getNbDiscs();
        nbDigitalVideoDiscs.increment();
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs.getNbDiscs();
        nbDigitalVideoDiscs.increment();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs.getNbDiscs();
        nbDigitalVideoDiscs.increment();
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

    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    public static class nbDigitalVideoDiscs {
        private static int nbDiscs = 0;

        public static int getNbDiscs() {
            return nbDiscs;
        }

        public static void increment() {
            nbDiscs++;
        }
    }
}

