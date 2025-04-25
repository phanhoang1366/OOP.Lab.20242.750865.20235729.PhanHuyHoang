package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
    public final int MAX_NUMBERS_DVD = 100;
    private DigitalVideoDisc[] itemsInStore;
    private int totalDVDs = 0;

    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_DVD];
    }

    public void addDVD(DigitalVideoDisc disc) {
        if (totalDVDs < MAX_NUMBERS_DVD) {
            itemsInStore[totalDVDs] = disc;
            totalDVDs++;
            System.out.println("Added DVD: " + disc.getTitle());
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < totalDVDs; i++) {
            if (itemsInStore[i].equals(disc)) {
                itemsInStore[i] = itemsInStore[totalDVDs - 1];
                itemsInStore[totalDVDs - 1] = null;
                totalDVDs--;
                System.out.println("Removed DVD: " + disc.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in store.");
    }

}
