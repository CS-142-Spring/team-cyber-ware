package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class TheEnd extends JPanel {
    private Image backgroundImage;

    // Constructor for TheEnd class
    public TheEnd() {
        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("src/Resources/TheEnd.jpg")); // replace with your image path
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error - maybe set a default background color if the image fails to load?
        }
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image to fit the panel size
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            // Draw a default background (e.g., black) if the image is not found
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
    }
}
