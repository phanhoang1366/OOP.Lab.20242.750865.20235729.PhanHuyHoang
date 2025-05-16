package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddBookScreen extends AIMSScreen{
    private JTextField titleField, categoryField, authorField, costField;

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2, 2, 2));

        JLabel titleLabel = new JLabel("Title: ");
        titleField = new JTextField(20);
        JLabel categoryLabel = new JLabel("Category: ");
        categoryField = new JTextField(20);
        JLabel authorLabel = new JLabel("Authors (separated by comma): ");
        authorField = new JTextField(20);
        JLabel costLabel = new JLabel("Cost: ");
        costField = new JTextField(20);

        Component[] toBeAdded = {titleLabel, titleField, categoryLabel, categoryField, authorLabel, authorField, costLabel, costField,};
        for (Component obj : toBeAdded) {
            center.add(obj);
        }

        return center;
    }

    JPanel createBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add book");
        JButton backButton = new JButton("Back");
        JButton resetButton = new JButton("Reset");

        bottom.add(addButton);
        bottom.add(backButton);
        bottom.add(resetButton);

        BookInputListener inputListener = new BookInputListener();
        addButton.addActionListener(inputListener);
        backButton.addActionListener(inputListener);
        resetButton.addActionListener(inputListener);

        return bottom;
    }
    public AddBookScreen(Store store) {
        super(store);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createBottom(), BorderLayout.SOUTH);

        setTitle("Add Book");
        setSize(480, 240);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private class BookInputListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Add book" -> {
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    String authors = authorField.getText();
                    String cost = costField.getText();

                    if (title.isEmpty() || category.isEmpty() || authors.isEmpty() || cost.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                    } else {
                        try {
                            float costValue = Float.parseFloat(cost);
                            String[] authorList = authors.split(",");
                            for (int i = 0; i < authorList.length; i++) {
                                authorList[i] = authorList[i].trim();
                            }
                            Book book = new Book(title, category, authorList, costValue);
                            store.addMedia(book);
                            JOptionPane.showMessageDialog(null, "Book added successfully!");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid cost value. Please enter a valid number.");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "An error occurred while adding the book: " + ex.getMessage());
                        }
                    }
                }
                case "Back" -> {
                    dispose();
                    new StoreManagerScreen(store);
                }
                case "Reset" -> {
                    titleField.setText("");
                    categoryField.setText("");
                    authorField.setText("");
                    costField.setText("");
                }
            }
        }
    }

}
