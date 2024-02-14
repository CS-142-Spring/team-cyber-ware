package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Menu {
    private Image backgroundImage;

    public Menu() {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("src\\Resources\\background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error here - perhaps set a default background or exit
        }

        // Create a custom panel with a background image
        JPanel menuPanel =  new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        // Customize the buttons
        JButton newGameBtn = createStyledButton("New Game");
        JButton resumeBtn = createStyledButton("Resume");
        JButton exitBtn = createStyledButton("Exit");

        // Setup the constraints for the buttons
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add buttons to the panel
        menuPanel.add(newGameBtn, gbc);
        menuPanel.add(resumeBtn, gbc);
        menuPanel.add(exitBtn, gbc);

        // Add the panel to the frame
        frame.add(menuPanel, BorderLayout.CENTER);
        frame.setSize(1000, 2000);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        // Add action listeners to the buttons
        newGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for new game
                new Introduction(frame);
            }
        });

        resumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for resume game
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(new Color(220, 220, 220)); // Set the text color with some transparency
        button.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Set the font
        button.setContentAreaFilled(false); // Transparent button background
        button.setBorderPainted(false); // No border
        button.setFocusPainted(false); // No focus border
        button.setOpaque(false); // Make the button transparent

        // Change cursor to hand cursor when hovering over the button
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add mouse listener for hover effects
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE); // Change color on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(220, 220, 220)); // Change color back on exit
            }
        });

        return button;
    }


    public static void main(String[] args) {
        new Menu();
    }
}
