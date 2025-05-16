package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCDScreen extends AIMSScreen {
    private JTextField titleField, categoryField, directorField, artistField, costField;

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2, 2, 2));

        JLabel titleLabel = new JLabel("Title: ");
        titleField = new JTextField(20);
        JLabel categoryLabel = new JLabel("Category: ");
        categoryField = new JTextField(20);
        JLabel directorLabel = new JLabel("Director: ");
        directorField = new JTextField(20);
        JLabel artistLabel = new JLabel("Artist: ");
        artistField = new JTextField(20);
        JLabel costLabel = new JLabel("Cost: ");
        costField = new JTextField(20);

        Component[] toBeAdded = {titleLabel, titleField, categoryLabel, categoryField, directorLabel, directorField, artistLabel, artistField, costLabel, costField,};
        for (Component obj : toBeAdded) {
            center.add(obj);
        }

        return center;
    }

    JPanel createBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add CD and Tracks");
        JButton backButton = new JButton("Back");
        JButton resetButton = new JButton("Reset");

        bottom.add(addButton);
        bottom.add(backButton);
        bottom.add(resetButton);

        CDInputListener inputListener = new CDInputListener();
        addButton.addActionListener(inputListener);
        backButton.addActionListener(inputListener);
        resetButton.addActionListener(inputListener);

        return bottom;
    }

    public AddCDScreen(Store store) {
        super(store);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createBottom(), BorderLayout.SOUTH);

        setTitle("Add CD");
        setSize(360, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private class CDInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Add CD and Tracks" -> {
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    String director = directorField.getText();
                    String artist = artistField.getText();
                    String costStr = costField.getText();

                    // Validate inputs
                    if (title.isEmpty() || category.isEmpty() || director.isEmpty() || artist.isEmpty() || costStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        float cost = Float.parseFloat(costStr);
                        // Add CD to store (assuming a method exists in Store class)
                        CompactDisc cd = new CompactDisc(title, category, cost, director, artist);
                        store.addMedia(cd);
                        JOptionPane.showMessageDialog(null, "CD added successfully! Will add tracks now.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new AddTrackToCDScreen(store, cd);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Cost must be a number", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case "Back" -> {
                    dispose();
                    new StoreManagerScreen(store);
                }
                case "Reset" -> {
                    titleField.setText("");
                    categoryField.setText("");
                    directorField.setText("");
                    artistField.setText("");
                    costField.setText("");
                }
            }
        }
    }
}
