package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;

import java.util.ArrayList;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    public static final int DELTA_ALMOST_FULL = 5;
    private final ArrayList<Media> itemsOrdered = new ArrayList<>();

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private int qtyOrdered = 0;

    public void addMedia(Media media) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            qtyOrdered++;
            System.out.println("Added: " + media);
            if (qtyOrdered >= MAX_NUMBERS_ORDERED - DELTA_ALMOST_FULL) {
                System.out.println("Warning: The cart is almost full.");
            }
        } else {
            System.out.println("The cart is full. Cannot add more items.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            qtyOrdered--;
            System.out.println("Removed: " + media);
        } else {
            System.out.println("Cannot find the item in the cart.");
        }
    }

    public void displayCart() {
        System.out.println("***********************CART***********************");
        if (qtyOrdered > 0) {
            System.out.println("Ordered items:");
            for (int i = 0; i < qtyOrdered; i++) {
                Media media = itemsOrdered.get(i);
                System.out.printf("%2d. %s\n", i + 1, media.toString());
            }
            System.out.printf("Total cost: %.2f $\n", totalCost());
        } else {
            System.out.println("The cart is empty.");
        }
        System.out.println("**************************************************");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

    public void searchByID(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("Found: " + itemsOrdered.get(i));
                return;
            }
        }
        System.out.println("Cannot find any items in cart with ID " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found: " + itemsOrdered.get(i));
                found = true;
            }
        }
        if(!found)
            System.out.println("Cannot find any items in cart with title: " + title);
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(COMPARE_BY_COST_TITLE);
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }


}
