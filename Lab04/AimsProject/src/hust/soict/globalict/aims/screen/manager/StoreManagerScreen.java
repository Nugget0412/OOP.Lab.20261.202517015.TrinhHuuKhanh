package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

/** The view store screen of the Store Manager application. */
public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar(store, this));
        north.add(createHeader());
        return north;
    }

    /**
     * Creates the "Options" menu bar. It is static and takes the store and the
     * current screen as parameters so that the "Add item" screens can show
     * exactly the same menu bar as the view store screen.
     */
    static JMenuBar createMenuBar(Store store, JFrame currentScreen) {
        MenuListener menuListener = new MenuListener(store, currentScreen);

        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(menuListener);
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addBook.addActionListener(menuListener);
        addCD.addActionListener(menuListener);
        addDVD.addActionListener(menuListener);
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
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

    JPanel createCenter() {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            if (i < mediaInStore.size()) {
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            } else {
                // Fewer than 9 items in the store: keep the grid shape with an empty cell
                center.add(new JPanel());
            }
        }

        return center;
    }

    /** Handles the clicks on the items of the "Options" menu: switches screen. */
    private static class MenuListener implements ActionListener {
        private Store store;
        private JFrame currentScreen;

        MenuListener(Store store, JFrame currentScreen) {
            this.store = store;
            this.currentScreen = currentScreen;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("View store")) {
                new StoreManagerScreen(store);
            } else if (command.equals("Add Book")) {
                new AddBookToStoreScreen(store);
            } else if (command.equals("Add CD")) {
                new AddCompactDiscToStoreScreen(store);
            } else if (command.equals("Add DVD")) {
                new AddDigitalVideoDiscToStoreScreen(store);
            }
            // Close the old screen after the new one has been opened
            currentScreen.dispose();
        }
    }

    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 15.5f);
        cd1.addTrack(new Track("Billie Jean", 5));
        cd1.addTrack(new Track("Beat It", 4));
        store.addMedia(cd1);

        CompactDisc cd2 = new CompactDisc("Abbey Road", "Rock", "The Beatles", 17.0f);
        cd2.addTrack(new Track("Come Together", 4));
        cd2.addTrack(new Track("Something", 3));
        store.addMedia(cd2);

        store.addMedia(new Book("Clean Code", "Programming", 32.5f));
        store.addMedia(new Book("Effective Java", "Programming", 40.0f));

        new StoreManagerScreen(store);
    }
}
