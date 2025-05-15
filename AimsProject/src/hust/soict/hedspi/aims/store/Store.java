package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public final int MAX_NUMBERS_DVD = 100;
    private final ArrayList<Media> itemsInStore;
    private int totalDVDs = 0;

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    public void displayStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        for (int i = 0; i < totalDVDs; i++) {
            Media media = itemsInStore.get(i);
            System.out.printf("%2d. %s\n", i + 1, media.toString());
        }
        System.out.println("**************************************************");
    }

    public ArrayList<Media> searchByTitle(String title) {
        ArrayList<Media> foundItems = new ArrayList<>();
        for (Media media : itemsInStore) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundItems.add(media);
            }
        }
        return foundItems;
    }

    public void addMedia(Media media) {
        if (totalDVDs < MAX_NUMBERS_DVD) {
            itemsInStore.add(media);
            totalDVDs++;
            System.out.println("Added: " + media.getTitle());
        } else {
            System.out.println("Store is full. Cannot add more items.");
        }
    }

    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            addMedia(media);
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            totalDVDs--;
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Cannot find the item in the store.");
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
