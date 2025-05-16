package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AIMSScreen extends JFrame {
    protected final Store store;

    protected AIMSScreen(Store store) {
        this.store = store;
    }

    public JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    public JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    public JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        ButtonListener buttonListener = new ButtonListener(store, this);

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(buttonListener);
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");

        String[] commands = {"Add Book", "Add CD", "Add DVD"};
        for (String command : commands) {
            JMenuItem menuItem = new JMenuItem(command);
            menuItem.addActionListener(buttonListener);
            smUpdateStore.add(menuItem);
        }

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
}
