package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDVDScreen extends AIMSScreen {
    private JTextField titleField, categoryField, directorField, lengthField, costField;

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2, 2, 2));

        JLabel titleLabel = new JLabel("Title: ");
        titleField = new JTextField(20);
        JLabel categoryLabel = new JLabel("Category: ");
        categoryField = new JTextField(20);
        JLabel directorLabel = new JLabel("Director: ");
        directorField = new JTextField(20);
        JLabel lengthLabel = new JLabel("Length (in minutes): ");
        lengthField = new JTextField(20);
        JLabel costLabel = new JLabel("Cost: ");
        costField = new JTextField(20);

        Component[] toBeAdded = {titleLabel, titleField, categoryLabel, categoryField, directorLabel, directorField, lengthLabel, lengthField, costLabel, costField,};
        for (Component obj : toBeAdded) {
            center.add(obj);
        }

        return center;
    }

    JPanel createBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add DVD");
        JButton backButton = new JButton("Back");
        JButton resetButton = new JButton("Reset");

        bottom.add(addButton);
        bottom.add(backButton);
        bottom.add(resetButton);

        DVDInputListener inputListener = new DVDInputListener();
        addButton.addActionListener(inputListener);
        backButton.addActionListener(inputListener);
        resetButton.addActionListener(inputListener);

        return bottom;
    }

    public AddDVDScreen(Store store) {
        super(store);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createBottom(), BorderLayout.SOUTH);

        setTitle("Add DVD");
        setSize(360, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private class DVDInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            switch (button) {
                case "Add DVD" -> {
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    String director = directorField.getText();
                    String lengthStr = lengthField.getText();
                    String costStr = costField.getText();

                    if (title.isEmpty() || category.isEmpty() || director.isEmpty() || lengthStr.isEmpty() || costStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        int length = Integer.parseInt(lengthStr);
                        float cost = Float.parseFloat(costStr);

                        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                        store.addMedia(dvd);
                        JOptionPane.showMessageDialog(null, "DVD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new StoreManagerScreen(store);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Length and Cost must be numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(null, "Store is full. Cannot add more DVDs.", "Error", JOptionPane.ERROR_MESSAGE);
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
                    lengthField.setText("");
                    costField.setText("");
                }
            }
        }
    }
}
