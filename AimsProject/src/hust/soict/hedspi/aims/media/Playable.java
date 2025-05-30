package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;

public interface Playable {
    default void play() throws PlayerException {
        System.out.println("Playing media...");
    }

    default void playFromGUI() throws PlayerException {
        JDialog dialog = new JDialog((Frame) null, "Play Media", true);
        dialog.setType(Window.Type.UTILITY);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(300, 100));
        dialog.setResizable(false);

        JLabel label = new JLabel("Playing media...", SwingConstants.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
