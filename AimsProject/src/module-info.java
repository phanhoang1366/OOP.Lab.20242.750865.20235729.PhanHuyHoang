module AimsProject {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.base;
    opens hust.soict.hedspi.aims.screen.customer.controller to javafx.fxml;
    opens hust.soict.hedspi.test.screen.customer.store to javafx.graphics;
    opens hust.soict.hedspi.aims.media to javafx.base;
    exports hust.soict.hedspi.aims.screen.customer.controller;
}