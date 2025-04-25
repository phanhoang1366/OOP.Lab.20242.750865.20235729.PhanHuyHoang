package hust.soict.hedspi.aims.media;

import java.util.Objects;

public abstract class Media {
    private int id;
    private String title;
    private String category;
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

    public float getCost() {
        return cost;
    }

    public static class nbMedia {
        private static int nbMedia = 0;

        public static int getNbMedia() {
            return nbMedia;
        }

        public static void increment() {
            nbMedia++;
        }
    }

    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Media media = (Media) obj;

        return Objects.equals(title, media.title);
    }

    Media(String title) {
        this.title = title;
        this.id = nbMedia.getNbMedia();
        nbMedia.increment();
    }

    Media(String title, float cost) {
        this.title = title;
        this.cost = cost;
        this.id = nbMedia.getNbMedia();
        nbMedia.increment();
    }

    Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbMedia.getNbMedia();
        nbMedia.increment();
    }
}
