package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    // Constructor loads the background image from a file
    public BackgroundPanel() {
        try {
            // Adjust the path to the location of your image file
            backgroundImage = ImageIO.read(new File("src\\Resources\\background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image, scaling it to fill the entire JPanel
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        if (backgroundImage != null) {
            // Set the preferred size to match the size of the background image
            return new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
        } else {
            return super.getPreferredSize(); // default sizing
        }
    }
}

