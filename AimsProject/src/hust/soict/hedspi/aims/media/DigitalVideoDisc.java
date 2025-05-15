package hust.soict.hedspi.aims.media;

import javax.swing.*;
import java.awt.*;

public class DigitalVideoDisc extends Disc implements Playable {

    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength() + " minutes");
    }

    public void playFromGUI() {
        JDialog dialog = new JDialog((Frame) null, "Play DVD", true);
        dialog.setType(Window.Type.UTILITY);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Playing DVD: " + getTitle() + " - " + getLength() + " minutes", SwingConstants.CENTER);
        dialog.add(label);

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

