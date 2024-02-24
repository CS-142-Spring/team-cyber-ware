package UI;

import Utility.FileIO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Introduction extends JPanel {
    private CardLayout cardLayout;
    private JPanel cards;
    private JScrollPane openingScrollPane, keyWordsScrollPane;
    private JTextArea openingText;
    private JTextArea keyWordsText;
    private JButton continueButton, previousButton;
    private JPanel keyWordsPanel, continueButtonPanel, openingPanel, buttonPanel;
    private Image backgroundImage;

    private ViewSwitcher viewSwitcher;

    public Introduction(ViewSwitcher viewSwitcher) {
        String fileName = "src/Resources/openingBackground.jpg";
        backgroundImage = Toolkit.getDefaultToolkit().getImage(fileName);

        // Set up the CardLayout
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        // Create the opening panel
        openingPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Clears the previous painting
                g.clearRect(0, 0, getWidth(), getHeight()); // Clear the area before repainting
                g.clearRect(0, 0, getWidth(), getHeight()); // Clear the area if needed
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); // Draw the image
            }

        };

        openingPanel.setOpaque(false);
        openingText = createTextArea(getOpeningScene());
        openingText.setOpaque(false); // Make the text area transparent

        openingScrollPane = new JScrollPane(openingText);
        openingScrollPane.setBorder(null); // Remove border to keep the noir theme
        openingScrollPane.setOpaque(false);
        openingScrollPane.getViewport().setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black background
        openingPanel.add(openingScrollPane, BorderLayout.CENTER);

        continueButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        continueButtonPanel.setBorder(null);
        continueButtonPanel.setOpaque(false);
        continueButton = new JButton("Continue");
        styleButton(continueButton);
        continueButtonPanel.add(continueButton);
        openingPanel.add(continueButtonPanel, BorderLayout.SOUTH);

        // continue button's action listener
        // when button is clicked change the card to panel with key words
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "KeyWordsPanel");
            }
        });

        // Create the keywords panel
        keyWordsPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Clears the previous painting
                g.clearRect(0, 0, getWidth(), getHeight()); // Clear the area before repainting
                g.clearRect(0, 0, getWidth(), getHeight()); // Clear the area if needed
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); // Draw the image
            }

        };
        keyWordsPanel.setOpaque(false); // Ensure the panel is transparent


        keyWordsText = createTextArea(getKeyWordsHelp());
        keyWordsScrollPane = new JScrollPane(keyWordsText);
        keyWordsScrollPane.setOpaque(false);
        keyWordsScrollPane.setBorder(null);
        keyWordsScrollPane.getViewport().setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black background
        keyWordsPanel.add(keyWordsScrollPane, BorderLayout.CENTER);



        //create buttons
        JButton keyContinueButton = new JButton("Start Game");
        JButton previousButton = new JButton("Previous");
        styleButton(keyContinueButton);
        styleButton(previousButton);

        // buttons to panel
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        buttonPanel.add(keyContinueButton);
        buttonPanel.add(previousButton);


        add(buttonPanel, BorderLayout.SOUTH);
        keyWordsPanel.add(buttonPanel, BorderLayout.SOUTH);

        keyContinueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewSwitcher.switchView("GAMEPLAY");
            }
        });


        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSwitcher.switchView("MENU");
            }
        });


        // Add the panels to the CardLayout
        cards.add(openingPanel, "OpeningPanel");
        cards.add(keyWordsPanel, "KeyWordsPanel");

        // Initially show the opening panel
        cardLayout.show(cards, "OpeningPanel");

        // Add the cards to the Introduction panel
        this.setLayout(new BorderLayout());
        this.add(cards, BorderLayout.CENTER);



    }

    private static String getOpeningScene() {
        // read the opening scene from the txt email
        String filePath = "src/Resources/OpeningScene";
        String content = FileIO.extractContent(filePath);
        return content;
    }

    private static String getKeyWordsHelp() {
        // read the key words tutorial from the txt email
        String filePath = "src/Resources/KeyWordsHelp";
        String content = FileIO.extractContent(filePath);
        return content;
    }

    private JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setEnabled(false);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setForeground(new Color(255, 255, 255, 230)); // Light gray with slight transparency
        textArea.setFont(new Font("Courier New", Font.BOLD, 18)); // Typewriter-like font
        textArea.setBackground(new Color(0, 0, 0, 150)); // Increase the alpha value (0-255) for less transparency
        return textArea;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Courier New", Font.BOLD, 18)); // Set your custom font
        button.setForeground(Color.WHITE); // Button text color
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(Color.WHITE)); // Button border color
        button.setContentAreaFilled(false);
        button.setOpaque(false);
    }


}