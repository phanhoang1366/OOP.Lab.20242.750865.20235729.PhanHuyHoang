public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();
        
        // Create new DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter", "Fantasy", "Chris Columbus", 159, 29.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lord of the Rings", "Fantasy", "Peter Jackson", 178, 39.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Matrix", "Science Fiction", "Lana Wachowski", 136, 19.95f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 14.95f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 24.95f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 19.95f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 29.95f);
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 14.95f);
        DigitalVideoDisc dvd12 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 19.95f);
        DigitalVideoDisc dvd13 = new DigitalVideoDisc("The Silence of the Lambs", "Thriller", "Jonathan Demme", 118, 24.95f);
        DigitalVideoDisc dvd14 = new DigitalVideoDisc("The Departed", "Crime", "Martin Scorsese", 151, 19.95f);
        DigitalVideoDisc dvd15 = new DigitalVideoDisc("The Social Network", "Drama", "David Fincher", 120, 14.95f);
        DigitalVideoDisc dvd16 = new DigitalVideoDisc("The Prestige", "Drama", "Christopher Nolan", 130, 19.95f);
        DigitalVideoDisc dvd17 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 24.95f);
        DigitalVideoDisc dvd18 = new DigitalVideoDisc("Guardians of the Galaxy", "Action", "James Gunn", 121, 19.95f);
        DigitalVideoDisc dvd19 = new DigitalVideoDisc("Deadpool", "Action", "Tim Miller", 108, 14.95f);
        DigitalVideoDisc dvd20 = new DigitalVideoDisc("Mad Max: Fury Road", "Action", "George Miller", 120, 19.95f);
        DigitalVideoDisc dvd21 = new DigitalVideoDisc("The Incredibles", "Animation", "Brad Bird", 115, 24.95f);

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(dvd4);
        anOrder.addDigitalVideoDisc(dvd5);
        anOrder.addDigitalVideoDisc(dvd6);
        anOrder.addDigitalVideoDisc(dvd7);
        anOrder.addDigitalVideoDisc(dvd8);
        anOrder.addDigitalVideoDisc(dvd9);
        anOrder.addDigitalVideoDisc(dvd10);
        anOrder.addDigitalVideoDisc(dvd11);
        anOrder.addDigitalVideoDisc(dvd12);
        anOrder.addDigitalVideoDisc(dvd13);
        anOrder.addDigitalVideoDisc(dvd14);
        anOrder.addDigitalVideoDisc(dvd15);
        anOrder.addDigitalVideoDisc(dvd16);
        anOrder.addDigitalVideoDisc(dvd17);
        anOrder.addDigitalVideoDisc(dvd18);
        anOrder.addDigitalVideoDisc(dvd19);
        anOrder.addDigitalVideoDisc(dvd20);
        anOrder.addDigitalVideoDisc(dvd21);

        anOrder.displayCart();

        System.out.printf("Total cost is: %.2f\n", anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);
        
        anOrder.displayCart();
        System.out.printf("Total cost is: %.2f\n", anOrder.totalCost());
    }
}
