package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class AimsGUI {
	private static final Store store = new Store();
    private static Cart cart = new Cart();


    public static void storeSetup() {
        // DVD
        DigitalVideoDisc[] dvds = {
            new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 15.99f),
            new DigitalVideoDisc("The Matrix", "Action", "The Wachowskis", 136, 12.99f),
            new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 10.99f)
        };

        store.addMedia(dvds);

        // CD + Track
        CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", "The Beatles", 14.99f);
        cd1.addTrack(new Track("Come Together", 260));
        cd1.addTrack(new Track("Something", 182));

        CompactDisc cd2 = new CompactDisc("1989", "Pop", "Taylor Swift", 13.99f);
        cd2.addTrack(new Track("Blank Space", 231));
        cd2.addTrack(new Track("Style", 233));

        store.addMedia(cd1);
        store.addMedia(cd2);

        // Book
        Book book1 = new Book("To Kill a Mockingbird", "Fiction", 7.99f);
        book1.addAuthor("Harper Lee");
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        book2.addAuthor("George Orwell");
        Book book3 = new Book("The Great Gatsby", "Classic", 9.99f);
        book3.addAuthor("F. Scott Fitzgerald");
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
    }
    
	public static void main(String[] args) {
		storeSetup();
        new StoreManagerScreen(store);
    }
}