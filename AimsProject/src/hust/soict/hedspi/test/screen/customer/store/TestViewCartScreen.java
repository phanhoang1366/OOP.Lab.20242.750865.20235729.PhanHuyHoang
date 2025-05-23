package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import hust.soict.hedspi.aims.Aims;

public class TestViewCartScreen extends Application {
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
        CartController cartController = new CartController(cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();

        cart.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 15.99f));

        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "The Beatles", 14.99f);
        cd.addTrack(new Track("Come Together", 260));
        cd.addTrack(new Track("Something", 182));
        cart.addMedia(cd);

        Book book = new Book("To Kill a Mockingbird", "Fiction", 7.99f);
        book.addAuthor("Harper Lee");
        cart.addMedia(book);

        launch(args);
    }
}
