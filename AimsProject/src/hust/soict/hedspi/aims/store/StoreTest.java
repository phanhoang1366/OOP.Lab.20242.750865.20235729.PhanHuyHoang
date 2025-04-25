package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class StoreTest {

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Store store = new Store();
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);

        store.removeDVD(dvd2);
        store.removeDVD(dvd4);
        store.removeDVD(dvd4); // Attempt to remove a DVD that is not in the store
    }
}
