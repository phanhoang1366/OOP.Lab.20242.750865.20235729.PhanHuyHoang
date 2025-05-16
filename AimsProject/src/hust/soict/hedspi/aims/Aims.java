package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
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
        store.addMedia(book1);
        store.addMedia(book2);
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
        // TODO Clear screen after adding media
        System.out.println("Welcome to AIMS");
		Scanner keyboard = new Scanner(System.in);
		int choice;
        do {
            showMenu();
            choice = keyboard.nextInt();
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
                    System.out.println("Exiting AIMS.");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
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
	        choice = keyboard.nextInt();
	        switch (choice) {
	            case 1:
	                System.out.print("Enter the title of the media: ");
                    keyboard.nextLine(); // Consume newline
	                String title = keyboard.nextLine();
	                ArrayList<Media> mediaList = store.searchByTitle(title);
	                if (mediaList != null && !mediaList.isEmpty()) {
	                    System.out.println("Media found:");
                        for (int i = 1; i <= mediaList.size(); i++) {
                            System.out.println(i + ". " + mediaList.get(i - 1));
                        }
                        System.out.print("Enter the index of the media to add to cart or play: ");
                        int index = keyboard.nextInt();
                        Media media = mediaList.get(index - 1);
                        mediaDetailsMenu();
                        int subChoice = keyboard.nextInt();
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
                    keyboard.nextLine(); // Consume newline
	                String mediaTitle = keyboard.nextLine();
	                ArrayList<Media> mediaToAdd = store.searchByTitle(mediaTitle);

	                if (mediaToAdd != null && !mediaToAdd.isEmpty()) {
                        System.out.println("Media found:");
                        for (int i = 1; i <= mediaToAdd.size(); i++) {
                            System.out.println(i + ". " + mediaToAdd.get(i - 1));
                        }
                        System.out.print("Enter the index of the media to add to cart: ");
                        int index = keyboard.nextInt();
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
                    keyboard.nextLine(); // Consume newline
	                String playTitle = keyboard.nextLine();
	                ArrayList<Media> mediaToPlay = store.searchByTitle(playTitle);
                    Media mediumToPlay = null;
                    if (mediaToPlay != null && !mediaToPlay.isEmpty()) {
                        System.out.println("Media found:");
                        for (int i = 1; i <= mediaToPlay.size(); i++) {
                            System.out.println(i + ". " + mediaToPlay.get(i - 1));
                        }
                        System.out.print("Enter the index of the media to play: ");
                        int index = keyboard.nextInt();
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
	    // keyboard.close();
	}
	public static void handleUpdateStore() {
	    System.out.println("Update Store:");
	    System.out.println("1. Add media");
	    System.out.println("2. Remove media");
	    System.out.print("Choose an option: ");
	    Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
	    System.out.print("Enter media title: ");
        keyboard.nextLine(); // Consume newline
	    String title = keyboard.nextLine();
	    ArrayList<Media> media = store.searchByExactTitle(title);
	    switch (choice) {
	        case 1:
	            if (media == null || media.isEmpty()) {
	                System.out.print("Enter media type ([B]ook/[D]VD/[C]D): ");
	                String type = keyboard.nextLine().toLowerCase();
	                System.out.print("Enter category: ");
	                String category = keyboard.nextLine();
	                System.out.print("Enter cost: ");
	                float cost = Float.parseFloat(keyboard.nextLine());
                    switch (type) {
                        case "b" -> {
                            Book book = new Book(title, category, cost);
                            System.out.println("Enter the (List of) author(s) of the book (Press # to stop): ");
                            while (true) {
                                String bookAuthor = keyboard.nextLine();
                                if (bookAuthor.equals("#")) break;
                                book.addAuthor(bookAuthor);
                            }
                            store.addMedia(book);
                        }
                        case "d" -> {
                            System.out.print("Enter director: ");
                            String director = keyboard.nextLine();
                            System.out.print("Enter length: ");
                            int length = keyboard.nextInt();
                            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                            store.addMedia(dvd);
                        }
                        case "c" -> {
                            System.out.print("Enter director: ");
                            String director = keyboard.nextLine();
                            System.out.print("Enter artist: ");
                            String artist = keyboard.nextLine();
                            CompactDisc cd = new CompactDisc(title, category, cost, director, artist);
                            System.out.println("Do you want to add tracks to your CD?\n (1) Yes (0) No:");
                            int addTrack = keyboard.nextInt();
                            if (addTrack == 1) {
                                System.out.println("Enter the number of tracks: ");
                                int numTracks = keyboard.nextInt();
                                keyboard.nextLine();
                                for (int i = 0; i < numTracks; i++) {
                                    System.out.println("Enter the title of track " + (i + 1) + ": ");
                                    String trackTitle = keyboard.nextLine();
                                    System.out.println("Enter the length of track " + (i + 1) + " (in seconds): ");
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
                    for (int i = 1; i <= media.size(); i++) {
                        System.out.println(i + ". " + media.get(i - 1));
                    }
                    System.out.print("Enter the index of the media to remove: ");
                    int index = keyboard.nextInt();
                    Media medium = media.get(index - 1);
	                store.removeMedia(medium);
	            } else {
	                System.out.println("Media not in store");
	            }
	            break;

	        default:
	            System.out.println("Invalid option");
	    }
	    // keyboard.close();
	}
	public static void handleCart() {
		Scanner keyboard = new Scanner(System.in);
		int choice;
	    do {
	        cart.displayCart();
	        cartMenu(); 
	        choice = keyboard.nextInt();
	        switch (choice) {
	            case 1:
	                System.out.println("Filter by: 1. ID, 2. Title");
	                int filterChoice = keyboard.nextInt();
	                keyboard.nextLine();
	                if (filterChoice == 1) {
	                    System.out.print("Enter ID: ");
	                    int id = keyboard.nextInt();
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
                    try {
                        throw new UnsupportedOperationException("Place order functionality not implemented yet.");
                    }
                    catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                    cart = new Cart();
                    break;
	            case 0:
	                System.out.println("Returning to main menu...");
	                break;

	            default:
	                System.out.println();
	        }
	    } while (choice != 0 && choice != 5); // also exit if place order
	    // keyboard.close();
	}
}