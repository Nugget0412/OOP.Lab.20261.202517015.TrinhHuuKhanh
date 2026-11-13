package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

/**
 * Parent class of the three "Add item to store" screens. It holds what they
 * all share: the menu bar, the title/category/cost fields and the "Add" button.
 * Each subclass adds its own fields and says how to build its Media.
 */
public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    private JPanel form;

    public AddItemToStoreScreen(Store store, String screenTitle) {
        this.store = store;

        // One row per field: label on the left, text field on the right
        form = new JPanel(new GridLayout(0, 2, 5, 5));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tfTitle = addField("Title: ");
        tfCategory = addField("Category: ");
        tfCost = addField("Cost: ");

        // Put the form at the top of the center so the rows keep their normal height
        JPanel center = new JPanel(new BorderLayout());
        center.add(form, BorderLayout.NORTH);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new AddButtonListener());
        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        south.add(btnAdd);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(StoreManagerScreen.createMenuBar(store, this), BorderLayout.NORTH);
        cp.add(center, BorderLayout.CENTER);
        cp.add(south, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(screenTitle);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        // Not visible yet: the subclass shows the screen after adding its own fields
    }

    /** Adds a "label + text field" row to the form and returns the text field. */
    protected JTextField addField(String label) {
        JTextField textField = new JTextField(20);
        form.add(new JLabel(label));
        form.add(textField);
        return textField;
    }

    /** Builds the Media from what the user typed. Implemented by each subclass. */
    protected abstract Media createMedia();

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Media media = createMedia();
            store.addMedia(media);
            JOptionPane.showMessageDialog(AddItemToStoreScreen.this,
                    "\"" + media.getTitle() + "\" has been added to the store.");

            // Go back to the view store screen to see the new item
            new StoreManagerScreen(store);
            dispose();
        }
    }
}
