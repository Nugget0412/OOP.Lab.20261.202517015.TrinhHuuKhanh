package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
 * all share: the menu bar, the header, the title/category/cost fields and the
 * "Add" button. Each subclass adds its own fields and says how to build its Media.
 */
public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    private JPanel form;

    public AddItemToStoreScreen(Store store, String screenTitle) {
        this.store = store;

        // NORTH: same menu bar and "AIMS" header as the view store screen,
        // with the name of this screen on the right of the header
        JLabel aims = new JLabel("AIMS");
        aims.setFont(new Font(aims.getFont().getName(), Font.PLAIN, 50));
        aims.setForeground(Color.CYAN);
        JLabel heading = new JLabel(screenTitle);
        heading.setFont(new Font(heading.getFont().getName(), Font.PLAIN, 24));

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(aims);
        header.add(Box.createHorizontalGlue());
        header.add(heading);
        header.add(Box.createRigidArea(new Dimension(20, 10)));

        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(StoreManagerScreen.createMenuBar(store, this));
        north.add(header);

        // CENTER: a bordered form of fixed width, centered horizontally,
        // with the "Add" button right below it
        form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(20, 30, 20, 30)));
        tfTitle = addField("Title: ");
        tfCategory = addField("Category: ");
        tfCost = addField("Cost: ");

        JButton btnAdd = new JButton("Add");
        btnAdd.setPreferredSize(new Dimension(120, 32));
        btnAdd.addActionListener(new AddButtonListener());

        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(40, 0, 20, 0);
        center.add(form, c);
        c.gridy = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1; // the remaining space goes below the button
        c.anchor = GridBagConstraints.NORTH;
        center.add(btnAdd, c);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(north, BorderLayout.NORTH);
        cp.add(center, BorderLayout.CENTER);

        // Pressing Enter in any field is the same as clicking "Add"
        getRootPane().setDefaultButton(btnAdd);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(screenTitle);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        // Not visible yet: the subclass shows the screen after adding its own fields
    }

    /** Adds a "label + text field" row to the form and returns the text field. */
    protected JTextField addField(String label) {
        int row = form.getComponentCount() / 2;

        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font(lbl.getFont().getName(), Font.PLAIN, 15));
        JTextField textField = new JTextField(28);
        textField.setFont(new Font(textField.getFont().getName(), Font.PLAIN, 15));

        GridBagConstraints c = new GridBagConstraints();
        c.gridy = row;
        c.insets = new Insets(6, 5, 6, 5);

        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_END; // labels are right-aligned next to their field
        form.add(lbl, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        form.add(textField, c);
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
