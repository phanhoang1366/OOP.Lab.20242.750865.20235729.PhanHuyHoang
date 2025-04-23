package hust.soict.hedspi.aims.disc;


public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungle = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderella = new DigitalVideoDisc("Cinderella");

        swap(jungle, cinderella);
        System.out.println("jungle: " + jungle.getTitle());
        System.out.println("cinderella: " + cinderella.getTitle());

        changeTitle(jungle, cinderella.getTitle());
        System.out.println("jungle: " + jungle.getTitle());
    }

    public static void swap(Object a, Object b) {
        Object temp = a;
        a = b;
        b = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String newTitle) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(newTitle);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}