public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();
        
        // Create new DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.displayCart();

        System.out.print("Total cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);
        
        anOrder.displayCart();
        // Ah, floating point arithmetic is a pain
        // I'll just round it to 2 decimal places
        System.out.printf("Total cost is: %.2f\n", anOrder.totalCost());
    }
}
