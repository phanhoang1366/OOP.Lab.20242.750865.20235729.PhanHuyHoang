package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import java.awt.*;
import java.awt.event.*;

public class ButtonListener implements ActionListener {
    private final Store store;
    private final Window parentWindow;

    public ButtonListener(Store store, Window parentWindow) {
        this.store = store;
        this.parentWindow = parentWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Dispose the parent window
        if (parentWindow != null) {
            parentWindow.dispose();
        }

        // Open the new window based on the command
        switch (command) {
            case "View store" -> new StoreManagerScreen(store);
            case "Add Book" -> new AddBookScreen(store);
            case "Add CD" -> new AddCDScreen(store);
            case "Add DVD" -> new AddDVDScreen(store);
            default -> throw new UnsupportedOperationException("Unknown command: " + command);
        }
    }
}
