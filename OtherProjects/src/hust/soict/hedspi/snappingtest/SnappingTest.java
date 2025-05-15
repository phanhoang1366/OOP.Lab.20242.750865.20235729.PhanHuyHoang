package hust.soict.hedspi.snappingtest;

import javax.swing.*;
import java.awt.*;

public class SnappingTest {
    public static void main(String[] args) {
        Window window = new Window(null);
        window.setType(Window.Type.UTILITY);
        window.add(new JLabel("Utility window test", SwingConstants.CENTER));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
