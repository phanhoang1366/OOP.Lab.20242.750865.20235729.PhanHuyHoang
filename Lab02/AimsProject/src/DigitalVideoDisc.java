public class DigitalVideoDisc {
    private final int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
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
