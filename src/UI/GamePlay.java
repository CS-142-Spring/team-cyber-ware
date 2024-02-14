package UI;

import Engine.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GamePlay extends JPanel {
    private JTextArea textArea;
    private JButton searchButton, forwardButton, backButton, investigateButton;
    private JPanel buttonPanel, textPanel;
    private int moveIndex = 0;
    public GamePlay() {
        setLayout(new BorderLayout());

        // Create text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textPanel = new JPanel(new BorderLayout());
        textPanel.add(scrollPane, BorderLayout.CENTER);
        add(textPanel, BorderLayout.CENTER);

        // Create buttons
        searchButton = new JButton("Search");
        forwardButton = new JButton("Forward");
        backButton = new JButton("Back");
        investigateButton = new JButton("Investigate");

        // Add buttons to a panel
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(searchButton);
        buttonPanel.add(forwardButton);
        buttonPanel.add(backButton);
        buttonPanel.add(investigateButton);

        // Add button panel to the main panel
        add(buttonPanel, BorderLayout.SOUTH);

        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (moveIndex < 8) {
                        moveIndex++;
                        Engine.move(moveIndex);
                    } else {
                        JOptionPane.showMessageDialog(GamePlay.this, "There is no room to go forward", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (moveIndex > 0) {
                        moveIndex--;
                        Engine.move(moveIndex);
                    } else {
                        JOptionPane.showMessageDialog(GamePlay.this, "There is no room to go back", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
