package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;

public class DigitalVideoDisc extends Disc implements Playable {

    public void play() throws PlayerException {
        System.out.println("Playing DVD: " + getTitle());
        if (getLength() < 0) {
            throw new PlayerException("DVD length cannot be negative.");
        }
        System.out.println("DVD length: " + getLength() + " minutes");
    }

    public void playFromGUI() throws PlayerException {
        JDialog dialog = new JDialog((Frame) null, "Play DVD", true);
        dialog.setType(Window.Type.UTILITY);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(300, 100));
        dialog.setResizable(false);

        if (getLength() < 0) {
            throw new PlayerException("DVD length cannot be negative.");
        }
        JLabel label = new JLabel("Playing DVD: " + getTitle() + " - " + getLength() + " minutes", SwingConstants.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }


    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("DVD - ");
        result.append(getTitle());
        if (getCategory() != null) {
            result.append(" - ").append(getCategory());
        }
        if (getDirector() != null) {
            result.append(" - ").append(getDirector());
        }
        if (getLength() > 0) {
            result.append(" - ").append(getLength()).append(" minutes");
        }
        result.append(": ").append(getCost()).append(" $");
        return result.toString();
    }



}

