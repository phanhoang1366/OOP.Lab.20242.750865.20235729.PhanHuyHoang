package hust.soict.hedspi.aims.media;

import javax.swing.*;
import java.awt.*;

public interface Playable {
    default void play() {
        System.out.println("Playing media...");
    }

    default void playFromGUI() {
        // JFrame frame = new JFrame("Play Media");
        // JLabel label = new JLabel("Playing media...");
        // label.setHorizontalAlignment(SwingConstants.CENTER);
        // frame.add(label);
        // frame.setSize(300, 200);
        // frame.setVisible(true);
        JDialog dialog = new JDialog();
        dialog.setTitle("Play Media");
        dialog.setModal(true);
        dialog.setType(Window.Type.UTILITY);
        JLabel label = new JLabel("Playing media...");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(label);
        // dialog.setSize(300, 200);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
        dialog.dispose();
    }
}
