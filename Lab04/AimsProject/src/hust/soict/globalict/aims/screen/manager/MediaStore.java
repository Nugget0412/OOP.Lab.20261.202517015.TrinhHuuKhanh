package hust.soict.globalict.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.media.Disc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

/** One cell of the store grid: shows a single Media item. */
public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new PlayButtonListener());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /** Plays the media in a dialog window when the "Play" button is clicked. */
    private class PlayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Keep the console output from the earlier labs
            ((Playable) media).play();

            JDialog dialog = new JDialog();
            dialog.setTitle("Play " + media.getTitle());
            dialog.setLayout(new GridLayout(2, 1));

            // Every Playable media in AIMS is a Disc (DVD or CD), so it has a length
            int length = ((Disc) media).getLength();
            if (length > 0) {
                dialog.add(new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER));
                dialog.add(new JLabel("Length: " + length, SwingConstants.CENTER));
            } else {
                dialog.add(new JLabel("\"" + media.getTitle() + "\" cannot be played", SwingConstants.CENTER));
                dialog.add(new JLabel("(length is " + length + ")", SwingConstants.CENTER));
            }

            dialog.setSize(350, 150);
            dialog.setLocationRelativeTo(MediaStore.this);
            dialog.setVisible(true);
        }
    }
}
