package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

import javax.naming.LimitExceededException;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        try {
            cart.addMedia(dvd1);
            cart.addMedia(dvd2);
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
            System.out.println("Cart limit exceeded: " + e.getMessage());
        }

        cart.displayCart();

        cart.searchByID(2);
        cart.searchByID(5);

        cart.removeMedia(dvd2);
        cart.searchByID(1); // Try to search for the removed DVD

        cart.searchByTitle("lion king");
        cart.searchByTitle("star wars");
    }
}
