package UI;

import Engine.Engine;
import Inventory.Clue;
import Utility.JsonUtil;

import Location.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.util.Iterator;
import static Engine.Engine.currLocation;

public class GamePlay extends JPanel {
    private JTextArea textArea;
    private JButton searchButton, forwardButton, backButton, interactButton, inventoryButton,nb ;
    private JPanel buttonPanel, textPanel, inventoryPanel;
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
        interactButton = new JButton("Interact");
        inventoryButton = new JButton("Inventory");
        // Add buttons to a panel
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(searchButton);
        buttonPanel.add(forwardButton);
        buttonPanel.add(backButton);
        buttonPanel.add(interactButton);
        inventoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        inventoryPanel.add(inventoryButton);
        // Add button panel to the main panel
        add(buttonPanel, BorderLayout.SOUTH);
        add(inventoryPanel, BorderLayout.NORTH);
        forwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (moveIndex < 8) {
                        moveIndex++;
                        Engine.move(moveIndex, textArea);
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
                        Engine.move(moveIndex, textArea);
                    } else {
                        JOptionPane.showMessageDialog(GamePlay.this, "There is no room to go back", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Location> locations;
                try {
                    locations = JsonUtil.getAllLocations();
                    List<Clue> items = new ArrayList<>();
                    for (Location location : locations) {
                        if (location.getName().equals(currLocation())) {
                            items = location.getItems();
                            break;
                        }
                    }

                    int count = 1;
                    textArea.append("\nYou discovered: \n");
                    for(Clue clue : items){
                        textArea.append("   " + count + ". " + clue.getName() + "\n");
                        count++;
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        interactButton.addActionListener(new ActionListener() {
            @Override
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
                for (JsonNode item : itemsNode) {
                    items.add(item.asText());
                }
                System.out.println(items);
                StringBuilder yp = new StringBuilder();
                for(String i:items){
                    yp.append(i+"\n");

                }
                //New window
                final String l = Location;
                SwingUtilities.invokeLater(() -> {
                    JDialog newDialog = new JDialog();
                    newDialog.setTitle("Items available");
                    newDialog.setSize(300, 200);
                    newDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    newDialog.setModal(true);

                    JPanel checkBoxPanel = new JPanel();
                    checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
                    for(String i: items){
                        JCheckBox checkBox = new JCheckBox(i,false);
                        checkBoxPanel.add(checkBox);
                    }
                    // Create a new button
                    nb = new JButton("Add to Notebook");
                    // Add an ActionListener to the button
                    ArrayList<String> itemsToRemove = new ArrayList<>();
                    nb.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Iterate over the checkboxes
                            for (Component component : checkBoxPanel.getComponents()) {
                                if (component instanceof JCheckBox) {
                                    JCheckBox checkBox = (JCheckBox) component;
                                    if (checkBox.isSelected()) {
                                        // If the checkbox is selected, get its label and adds it to the arrayList
                                        String item = checkBox.getText();
                                        itemsToRemove.add(item);
                                    }
                                }
                            }

                            for(String i : itemsToRemove){
                                try {
                                    removeItems(i);
                                    addItems(i);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            newDialog.dispose();
                        }
                    });
                    // Create a new panel for the button with FlowLayout
                    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    buttonPanel.add(nb);  // Add the button to the panel

                    // Create a main panel with BorderLayout
                    JPanel mainPanel = new JPanel(new BorderLayout());
                    mainPanel.add(new JScrollPane(checkBoxPanel), BorderLayout.CENTER);
                    mainPanel.add(buttonPanel, BorderLayout.SOUTH);  // Add the button panel to the bottom

                    newDialog.getContentPane().add(mainPanel);
                    newDialog.setVisible(true);
                });
            }
        });
    }
        public static void removeItems(String itemToRemove) throws IOException {
            // Read the JSON file
            String content = new String(Files.readAllBytes(Paths.get("src/Resources/Locations.json")));

            // Create an ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Read the JSON content into a JsonNode
            ArrayNode jsonNode = (ArrayNode) mapper.readTree(content);

            // Iterate over the array
            for (int j = 0; j < jsonNode.size(); j++) {
                // Get the "items" array from the object
                ArrayNode items = (ArrayNode) jsonNode.get(j).get("items");

                int index = -1;
                // Find the index of the item to remove
                for (int i = 0; i < items.size(); i++) {
                    String item = items.get(i).asText();
                    if (item.equals(itemToRemove)) {
                        index = i;
                        break;
                    }
                }
                // Remove the item if it was found
                if (index != -1) {
                    // This creates a new ArrayNode without the item
                    ArrayNode newArray = mapper.createArrayNode();
                    for (int i = 0; i < items.size(); i++) {
                        if (i != index) {
                            newArray.add(items.get(i));

                        }
                    }

                    // Replace the old array with the new one
                    ((ObjectNode) jsonNode.get(j)).set("items", newArray);
                }
            }

            // Convert the JsonNode back to a string
            String updatedContent = mapper.writeValueAsString(jsonNode);

            // Write the updated JSON string back to the file
            Files.write(Paths.get("src/Resources/Locations.json"), updatedContent.getBytes());
        }
        public static void addItems(String item){
            ObjectMapper mapper = new ObjectMapper();

            try {
                // Specify the file location
                File jsonFile = new File("src/Resources/Notebook.json");

                // Parse your JSON file
                ObjectNode rootNode = (ObjectNode) mapper.readTree(jsonFile);

                // Get the "clues" array
                ArrayNode cluesNode = (ArrayNode) rootNode.get("clues");

                // Add items to the "clues" array
                cluesNode.add(item);

                // Write the updated rootNode back to the file
                mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, rootNode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}







