package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Track implements Playable {
    private final String title;
    private final int length; // in seconds

    public void play() throws PlayerException {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + calculateLength());
    }

    public void playFromGUI() throws PlayerException {
        JDialog dialog = new JDialog((Frame) null, "Play Track", true);
        dialog.setType(Window.Type.UTILITY);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(300, 100));
        dialog.setResizable(false);

        if (length < 0) {
            throw new PlayerException("Track length cannot be negative.");
        }
        JLabel label = new JLabel("Playing track: " + title + " - " + calculateLength(), SwingConstants.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public String calculateLength() throws PlayerException {
        int minutes = length / 60;
        int seconds = length % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Track track = (Track) obj;

        if (length != track.length) return false;
        return Objects.equals(title, track.title);
    }

    @Override
    public String toString() {
        try {
            return title + " - " + calculateLength();
        } catch (PlayerException e) {
            throw new RuntimeException(e);
        }
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

}
