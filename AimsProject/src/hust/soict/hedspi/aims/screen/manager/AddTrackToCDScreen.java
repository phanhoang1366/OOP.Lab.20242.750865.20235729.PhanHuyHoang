package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddTrackToCDScreen extends AIMSScreen {
    private JTextField titleField, lengthField;
    private CompactDisc cd;

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 2, 2, 2));

        JLabel titleLabel = new JLabel("Title: ");
        titleField = new JTextField(20);
        JLabel lengthLabel = new JLabel("Length (in seconds): ");
        lengthField = new JTextField(20);

        Component[] toBeAdded = {titleLabel, titleField, lengthLabel, lengthField,};
        for (Component obj : toBeAdded) {
            center.add(obj);
        }

        return center;
    }

    JPanel createBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add Track");
        JButton backButton = new JButton("Back to Manager");
        JButton resetButton = new JButton("Reset");

        bottom.add(addButton);
        bottom.add(backButton);
        bottom.add(resetButton);

        TrackInputListener inputListener = new TrackInputListener();
        addButton.addActionListener(inputListener);
        backButton.addActionListener(inputListener);
        resetButton.addActionListener(inputListener);

        return bottom;
    }

    public AddTrackToCDScreen(Store store, CompactDisc cd) {
        super(store);
        this.cd = cd;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createBottom(), BorderLayout.SOUTH);

        setTitle("Add Track to CD: " + cd.getTitle());
        setSize(320, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class TrackInputListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Add Track" -> {
                    String title = titleField.getText();
                    String length = lengthField.getText();
                    if (title.isEmpty() || length.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                    } else {
                        try {
                            int lengthInMinutes = Integer.parseInt(length);
                            cd.addTrack(new Track(title, lengthInMinutes));
                            JOptionPane.showMessageDialog(null, "Track added successfully!");
                            titleField.setText("");
                            lengthField.setText("");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Length must be a number.");
                        }
                    }
                }
                case "Back to Manager" -> {
                    dispose();
                    new StoreManagerScreen(store);
                }
                case "Reset" -> {
                    titleField.setText("");
                    lengthField.setText("");
                }
            }
        }
    }
}
