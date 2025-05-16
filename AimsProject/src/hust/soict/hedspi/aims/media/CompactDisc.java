package hust.soict.hedspi.aims.media;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String Artist;
    private final List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return Artist;
    }

    public void addTrack(Track track) {
        if (!this.tracks.contains(track)) {
            this.tracks.add(track);
        } else {
            System.out.println("Track already exists in the list.");
        }
    }

    public void removeTrack(Track track) {
        if (this.tracks.contains(track)) {
            this.tracks.remove(track);
        } else {
            System.out.println("Track not found in the list.");
        }
    }

    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength() + " minutes");
        for (Track track : tracks) {
            track.play();
        }
    }

    public void playFromGUI() {
        JDialog dialog = new JDialog((Frame) null, "Play CD", true);
        dialog.setType(Window.Type.UTILITY);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.setResizable(false);

        JLabel label = new JLabel("Select a track to play:", SwingConstants.CENTER);
        JComboBox<Track> trackComboBox = new JComboBox<>(tracks.toArray(new Track[0]));
        JButton playButton = new JButton("Play");
        playButton.addActionListener(e -> {
            Track selectedTrack = (Track) trackComboBox.getSelectedItem();
            if (selectedTrack != null) {
                selectedTrack.playFromGUI();
            }
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(trackComboBox);
        panel.add(playButton);
        dialog.add(panel, BorderLayout.CENTER);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength / 60; // Convert seconds to minutes
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CD - ");
        if (getArtist() != null) {
            sb.append(getArtist()).append(" - ");
        }
        sb.append(getTitle());
        if (getCategory() != null) {
            sb.append(" - ").append(getCategory());
        }
        if (getDirector() != null) {
            sb.append(" - ").append(getDirector());
        }
        if (getLength() > 0) {
            sb.append(" - ").append(getLength());
        }
        sb.append(": ").append(getCost()).append(" $");
        return sb.toString();
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category) {
        super(title, category);
    }

    public CompactDisc(String title, String category, String artist) {
        super(title, category);
        this.Artist = artist;
    }

    public CompactDisc(String title, float cost) {
        super(title, cost);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, director, cost);
        this.Artist = artist;
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
}
