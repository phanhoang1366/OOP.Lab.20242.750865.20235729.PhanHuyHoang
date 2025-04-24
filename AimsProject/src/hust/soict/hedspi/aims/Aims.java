package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();
        
        // Create new DVDs
        DigitalVideoDisc[] dvds = {
            new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f),
            new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f),
            new DigitalVideoDisc("Aladin", "Animation", 18.99f),
            new DigitalVideoDisc("Harry Potter", "Fantasy", "Chris Columbus", 159, 29.95f),
            new DigitalVideoDisc("The Lord of the Rings", "Fantasy", "Peter Jackson", 178, 39.95f),
            new DigitalVideoDisc("The Matrix", "Science Fiction", "Lana Wachowski", 136, 19.95f),
            new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 14.95f),
            new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 24.95f),
            new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 19.95f),
            new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 29.95f),
            new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 14.95f),
            new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 19.95f),
            new DigitalVideoDisc("The Silence of the Lambs", "Thriller", "Jonathan Demme", 118, 24.95f),
            new DigitalVideoDisc("The Departed", "Crime", "Martin Scorsese", 151, 19.95f),
            new DigitalVideoDisc("The Social Network", "Drama", "David Fincher", 120, 14.95f),
            new DigitalVideoDisc("The Prestige", "Drama", "Christopher Nolan", 130, 19.95f),
            new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 24.95f),
            new DigitalVideoDisc("Guardians of the Galaxy", "Action", "James Gunn", 121, 19.95f),
            new DigitalVideoDisc("Deadpool", "Action", "Tim Miller", 108, 14.95f),
            new DigitalVideoDisc("Mad Max: Fury Road", "Action", "George Miller", 120, 19.95f),
            new DigitalVideoDisc("The Incredibles", "Animation", "Brad Bird", 115, 24.95f)
        };

        for (DigitalVideoDisc dvd : dvds) {
            anOrder.addDigitalVideoDisc(dvd);
        }

        anOrder.displayCart();

        for (DigitalVideoDisc dvd : dvds) {
            anOrder.removeDigitalVideoDisc(dvd);
        }
        
        anOrder.displayCart();

        // Add an array of DVDs
        anOrder.addDigitalVideoDisc(dvds);

        anOrder.displayCart();

        // Remove a DVD
        anOrder.removeDigitalVideoDisc(dvds[0]);

        anOrder.displayCart();
    }
}
