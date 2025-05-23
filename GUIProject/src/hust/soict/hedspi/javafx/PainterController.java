package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup PenEraser;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = Color.BLACK;
        if (PenEraser.getSelectedToggle().toString().contains("Eraser")) {
            color = Color.WHITE;
        }
        Circle circle = new Circle(event.getX(), event.getY(), 5, color);
        drawingAreaPane.getChildren().add(circle);
    }

}

