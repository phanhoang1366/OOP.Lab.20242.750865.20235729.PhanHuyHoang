package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CartController {
    private final Store store;
    private final Cart cart;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<?, ?> colMediaCategory;

    @FXML
    private TableColumn<?, ?> colMediaCost;

    @FXML
    private TableColumn<?, ?> colMediaId;

    @FXML
    private TableColumn<?, ?> colMediaTitle;

    @FXML
    private HBox costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private Label totalCost;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            ((Playable) media).playFromGUI();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setTitle("Store");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        if (cart.getItemsOrdered() != null)
            tblMedia.setItems(cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observableValue, media, t1) -> updateButtonBar(t1));

        tfFilter.textProperty().addListener((observableValue, s, t1) -> showFilteredMedia(t1));

        totalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    private void showFilteredMedia(String t1) {
        // if (t1.isEmpty()) {
        //     tblMedia.setItems(cart.getItemsOrdered());
        // } else {
        //     filterCategory.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        //         @Override
        //         public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
        //             if (radioBtnFilterId.isSelected()) {
        //                 tblMedia.setItems(cart.searchByIDToList(Integer.parseInt(t1)));
        //             } else if (radioBtnFilterTitle.isSelected()) {
        //                 tblMedia.setItems(cart.searchByTitleToList(t1));
        //             }
        //         }
        //     });
        // }

        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        filteredList.setPredicate(media -> {
            if (t1 == null || t1.isEmpty()) {
                return true; // No filter applied
            }
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(t1);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(t1.toLowerCase());
            }
            return false;
        });
        tblMedia.setItems(filteredList);
    }

    @FXML
    void onPlaceOrderPressed(ActionEvent event) {
        try {
            cart.placeOrder();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Order Placement Failed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    void updateButtonBar (Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

}
