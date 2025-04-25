package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	private static final Store store = new Store();
    private static Cart cart = new Cart();


    public static void storeSetup(){
        // DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Guy Ritchie", 89, 18.99f);
        store.addMedia(dvd1); store.addMedia(dvd2); store.addMedia(dvd3);

        // CD + Track
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 9.99f);
        Track track1 = new Track("Billie Jean", 236);
        Track track2 = new Track("Beat It", 252);
        Track track3 = new Track("Man in the Mirror", 331);
        cd1.addTrack(track1); cd1.addTrack(track2); cd1.addTrack(track3);

        CompactDisc cd2 = new CompactDisc("Kind of Blue", "Jazz","Miles Davis", 12.99f);
        Track track4 = new Track("So What", 431);
        Track track5 = new Track("Freddie Freeloader", 539);
        cd2.addTrack(track4); cd2.addTrack(track5);

        CompactDisc cd3 = new CompactDisc("Bohemian Rhapsody", "Rock", "Queen", 14.99f);
        Track track6 = new Track("Bohemian Rhapsody", 355);
        Track track7 =  new Track("Killer Queen", 205);
        Track track8 = new Track("Somebody to Love", 296);
        cd3.addTrack(track6); cd3.addTrack(track7); cd3.addTrack(track8);

        store.addMedia(cd1); store.addMedia(cd2); store.addMedia(cd3);

        // Book
        Book book1 = new Book("Hannibal", "Crime Thriller", 8.99f);
        book1.addAuthor("Thomas Harris");
        Book book2 = new Book("Red Dragon", "Crime Thriller", 9.11f);
        book2.addAuthor("Thomas Harris");
        Book book3 = new Book("The Martian", "Science Fiction", 8.97f);
        book3.addAuthor("Andy Weir");
        store.addMedia(book1); store.addMedia(book2); store.addMedia(book3);
    }
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    
	public static void main(String[] args) {
		storeSetup();
		Scanner keyboard = new Scanner(System.in);
		int choice;
        do {
            showMenu();
            choice = Integer.parseInt(keyboard.nextLine());
            switch (choice) {
                case 1:
                    handleViewStore();
                    break;
                case 2:
                    handleUpdateStore();
                    break;
                case 3:
                    handleCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);
        keyboard.close();
    }
	public static void handleViewStore() {
		Scanner keyboard = new Scanner(System.in);
		int choice;
	    do {
	        store.displayStore();
	        storeMenu();
	        choice = Integer.parseInt(keyboard.nextLine());
	        switch (choice) {
	            case 1:
	                System.out.print("Enter the title of the media: ");
	                String title = keyboard.nextLine();
	                ArrayList<Media> mediaList = store.searchByTitle(title);
	                if (mediaList != null && !mediaList.isEmpty()) {
	                    System.out.println("Media found:");
                        for (int i = 1; i <= mediaList.size(); i++) {
                            System.out.println(i + ". " + mediaList.get(i - 1));
                        }
                        System.out.print("Enter the index of the media to add to cart or play: ");
                        int index = Integer.parseInt(keyboard.nextLine());
                        Media media = mediaList.get(index - 1);
                        mediaDetailsMenu();
                        int subChoice = Integer.parseInt(keyboard.nextLine());
                        if (subChoice == 1) {
                            cart.addMedia(media);
                            if (media instanceof DigitalVideoDisc) {
                                int dvdCount = 0;
                                for (Media m : cart.getItemsOrdered()) {
                                    if (m instanceof DigitalVideoDisc) {
                                        dvdCount++;
                                    }
                                }
                                System.out.println("There are currently " + dvdCount + " DVDs in the cart.");
                            }
                        } else if (subChoice == 2) {
                            if (media instanceof Playable) {
                                ((Playable) media).play();
                            } else {
                                System.out.println("This media cannot be played");
                            }
                        }
	                } else {
	                    System.out.println("Media not found");
	                }
	                break;

	            case 2:
	                System.out.print("Enter the title of the media to add to cart: ");
	                String mediaTitle = keyboard.nextLine();
	                ArrayList<Media> mediaToAdd = store.searchByTitle(mediaTitle);

	                if (mediaToAdd != null && !mediaToAdd.isEmpty()) {
                        System.out.println("Media found:");
                        for (int i = 1; i <= mediaToAdd.size(); i++) {
                            System.out.println(i + ". " + mediaToAdd.get(i - 1));
                        }
                        System.out.print("Enter the index of the media to add to cart: ");
                        int index = Integer.parseInt(keyboard.nextLine());
                        Media mediumToAdd = mediaToAdd.get(index - 1);
	                    cart.addMedia(mediumToAdd);
	                    if (mediumToAdd instanceof DigitalVideoDisc) {
	                        int dvdCount = 0;
	                        for (Media m : cart.getItemsOrdered()) {
	                            if (m instanceof DigitalVideoDisc) {
	                                dvdCount++;
	                            }
	                        }
	                        System.out.println("There are currently " + dvdCount + " DVDs in the cart.");
	                    }
	                } else {
	                    System.out.println("Media not found");
	                }
	                break;

	            case 3:
	                System.out.print("Enter the title of the media to play: ");
	                String playTitle = keyboard.nextLine();
	                ArrayList<Media> mediaToPlay = store.searchByTitle(playTitle);
                    Media mediumToPlay = null;
                    if (mediaToPlay != null && !mediaToPlay.isEmpty()) {
                        System.out.println("Media found:");
                        for (int i = 1; i <= mediaToPlay.size(); i++) {
                            System.out.println(i + ". " + mediaToPlay.get(i - 1));
                        }
                        System.out.print("Enter the index of the media to play: ");
                        int index = Integer.parseInt(keyboard.nextLine());
                        mediumToPlay = mediaToPlay.get(index - 1);
                    }
	                if (mediumToPlay instanceof Playable) {
	                    ((Playable) mediumToPlay).play();
	                } else if (mediumToPlay != null) {
	                    System.out.println("This media cannot be played");
	                } else {
	                    System.out.println("Media not found");
	                }
	                break;

	            case 4:
	                cart.displayCart();
	                break;

	            case 0:
	                System.out.println("Returning to main menu...");
	                break;

	            default:
	                System.out.println("Invalid option");
	        }
	    } while (choice != 0);
	    keyboard.close();
	}
	public static void handleUpdateStore() {
	    System.out.println("Update Store:");
	    System.out.println("1. Add media");
	    System.out.println("2. Remove media");
	    System.out.print("Choose an option: ");
	    Scanner keyboard = new Scanner(System.in);
		int choice = Integer.parseInt(keyboard.nextLine());
	    System.out.print("Enter media title: ");
	    String title = keyboard.nextLine();
	    ArrayList<Media> media = store.searchByTitle(title);
	    switch (choice) {
	        case 1:
	            if (media == null || media.isEmpty()) {
	                System.out.print("Enter media type (book/dvd/cd): ");
	                String type = keyboard.nextLine().toLowerCase();
	                System.out.print("Enter category: ");
	                String category = keyboard.nextLine();
	                System.out.print("Enter cost: ");
	                float cost = Float.parseFloat(keyboard.nextLine());
                    switch (type) {
                        case "book" -> {
                            Book book = new Book(title, category, cost);
                            System.out.println("Enter the (List of) author(s) of the book (Press 0 to stop): ");
                            while (true) {
                                String bookAuthor = keyboard.nextLine();
                                if (bookAuthor.equals("0")) break;
                                book.addAuthor(bookAuthor);
                            }
                            store.addMedia(book);
                        }
                        case "dvd" -> {
                            System.out.print("Enter director: ");
                            String director = keyboard.nextLine();
                            System.out.print("Enter length: ");
                            int length = Integer.parseInt(keyboard.nextLine());
                            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                            store.addMedia(dvd);
                        }
                        case "cd" -> {
                            System.out.print("Enter director: ");
                            String director = keyboard.nextLine();
                            System.out.print("Enter artist: ");
                            String artist = keyboard.nextLine();
                            CompactDisc cd = new CompactDisc(title, category, cost, director, artist);
                            System.out.println("Do you want to add tracks to your CD?\n (1) Yes (0) No:");
                            int addTrack = Integer.parseInt(keyboard.nextLine());
                            if (addTrack == 1) {
                                System.out.println("Enter the number of tracks: ");
                                int numTracks = keyboard.nextInt();
                                keyboard.nextLine();
                                for (int i = 0; i < numTracks; i++) {
                                    System.out.println("Enter the title of track " + (i + 1) + ": ");
                                    String trackTitle = keyboard.nextLine();
                                    System.out.println("Enter the length of track " + (i + 1) + ": ");
                                    int trackLength = keyboard.nextInt();
                                    keyboard.nextLine();
                                    cd.addTrack(new Track(trackTitle, trackLength));
                                }
                            }
                            store.addMedia(cd);
                        }
                        default -> System.out.println("Media type not supported");
                    }
	            } else {
	                System.out.println("Media already in the store");
	            }
	            break;

	        case 2:
	            if (media != null && !media.isEmpty()) {
                    System.out.println("Media found:");
                    for (Media m : media) {
                        System.out.println(m.toString());
                    }
                    System.out.print("Enter the ID of the media to remove: ");
                    int id = Integer.parseInt(keyboard.nextLine());
                    Media medium = null;
                    for (Media m : media) {
                        if (m.getId() == id) {
                            medium = m;
                            break;
                        }
                    }
	                store.removeMedia(medium);
	            } else {
	                System.out.println("Media not in store");
	            }
	            break;

	        default:
	            System.out.println("Invalid option");
	    }
	    keyboard.close();
	}
	public static void handleCart() {
		Scanner keyboard = new Scanner(System.in);
		int choice;
	    do {
	        cart.displayCart();
	        cartMenu(); 
	        choice = Integer.parseInt(keyboard.nextLine());
	        switch (choice) {
	            case 1:
	                System.out.println("Filter by: 1. ID, 2. Title");
	                int filterChoice = keyboard.nextInt();
	                keyboard.nextLine();
	                if (filterChoice == 1) {
	                    System.out.print("Enter ID: ");
	                    int id = Integer.parseInt(keyboard.nextLine());
	                    cart.searchByID(id);
	                } else if (filterChoice == 2) {
	                    System.out.print("Enter title: ");
	                    String title = keyboard.nextLine();
	                    cart.searchByTitle(title);
	                } else {
	                    System.out.println("Invalid option");
	                }
	                break;

	            case 2:
	                System.out.println("Sort by: 1. Title, 2. Cost");
	                int sortChoice = keyboard.nextInt();
	                keyboard.nextLine();
	                if (sortChoice == 1) {
	                    cart.sortByTitleCost();
	                } else if (sortChoice == 2) {
	                    cart.sortByCostTitle();
	                } else {
	                    System.out.println("Invalid option");
	                }
	                break;

	            case 3:
	                System.out.print("Enter the title of the media to remove: ");
	                String removeTitle = keyboard.nextLine();
	                Media toRemove = null;
	                for (Media m : new ArrayList<>(cart.getItemsOrdered())) {
	                    if (m.getTitle().equalsIgnoreCase(removeTitle)) {
	                        toRemove = m;
	                        break;
	                    }
	                }
	                if (toRemove != null) {
	                    cart.removeMedia(toRemove);
	                } else {
	                    System.out.println("Media not in cart");
	                }
	                break;

	            case 4:
	                System.out.print("Enter title to play: ");
	                String playTitle = keyboard.nextLine();
	                for (Media m : new ArrayList<>(cart.getItemsOrdered())) {
	                    if (m.getTitle().equalsIgnoreCase(playTitle) && m instanceof Playable) {
	                        ((Playable) m).play();
	                        break;
	                    }
	                }
	                break;

	            case 5:
	                System.out.println("Order id created");
	                cart = new Cart();  
	                break;
	            case 0:
	                System.out.println("Returning to main menu...");
	                break;

	            default:
	                System.out.println();
	        }
	    } while (choice != 0);
	    keyboard.close();
	}
}