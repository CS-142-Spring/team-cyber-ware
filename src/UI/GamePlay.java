package UI;

import Engine.Engine;
import Utility.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
        investigateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    // Specify the path to your JSON file
                    ObjectMapper objectMapper = new ObjectMapper();
                    ArrayList<String> items = new ArrayList<>();
                    File file = new File("src/Resources/Locations.json");
                String Location = null;
                try {
                    Location = Engine.currLocation();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JsonNode jsonNode = null;
                try {
                    jsonNode = objectMapper.readTree(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Iterator<JsonNode> locations = jsonNode.iterator();
                JsonNode location =locations.next();
                    while(locations.hasNext()){
                        if (location.get("accessibility").asBoolean() && location.get("name").asText().equals(Location)) {
                            System.out.println(location.get("name").asText());
                            break;
                        }
                        location = locations.next();
                    }
                JsonNode itemsNode = location.get("items");
                int count = 0;
                for (JsonNode item : itemsNode) {
                    count++;
                    items.add(count+". "+ item.asText());
                }
                System.out.println(items);
                StringBuilder yp = new StringBuilder();
                for(String i:items){
                    yp.append(i+"\n");
                }
                //Code for a new window
                final String l = Location;
                SwingUtilities.invokeLater(() -> {
                    JDialog newDialog = new JDialog();
                    newDialog.setTitle("Items in " + l);
                    newDialog.setSize(300, 200);
                    newDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    newDialog.setModal(true);

                    JTextArea textArea = new JTextArea();
                    Font largerFont = new Font("Times New Roman", Font.PLAIN, 25);
                    textArea.setFont(largerFont);
                    textArea.setEditable(false);
                    items.forEach(item -> textArea.append(item + "\n"));

                    JScrollPane scrollPane = new JScrollPane(textArea);
                    newDialog.getContentPane().add(scrollPane);

                    newDialog.setVisible(true);


                });
            }
            });

    }
}
