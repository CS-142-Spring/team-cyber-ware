package UI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InteractFrame {
    private JButton notebookButton, talkButton;
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel cluePanel, peoplePanel;
    private ArrayList<String> itemsToRemove = new ArrayList<>();
    public InteractFrame(ArrayList<String> items, ArrayList<String> peopleNames) {
        frame = new JFrame();
        frame.setTitle("Items available");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        cluePanel = new JPanel();
        cluePanel.setLayout(new BorderLayout()); // Use BorderLayout for the clue panel
        peoplePanel = new JPanel();

        JPanel clueCheckBoxPanel = new JPanel(); // Create a panel to hold checkboxes
        clueCheckBoxPanel.setLayout(new BoxLayout(clueCheckBoxPanel, BoxLayout.Y_AXIS)); // Align checkboxes vertically

        JPanel peopleCheckBoxPanel = new JPanel(); // Create a panel to hold checkboxes
        peopleCheckBoxPanel.setLayout(new BoxLayout(peopleCheckBoxPanel, BoxLayout.Y_AXIS)); // Align checkboxes vertically

        // Add checkboxes to the checkBoxPanel, not directly to cluePanel
        for (String i : items) {
            JCheckBox checkBox = new JCheckBox(i, false);
            clueCheckBoxPanel.add(checkBox);
        }

        JScrollPane clueScrollPane = new JScrollPane(clueCheckBoxPanel); // Add checkBoxPanel to a scrollPane
        cluePanel.add(clueScrollPane, BorderLayout.CENTER); // Add scrollPane to the center of cluePanel


        JScrollPane peopleScrollPane = new JScrollPane(peopleCheckBoxPanel); // Add checkBoxPanel to a scrollPane
        peoplePanel.add(peopleScrollPane, BorderLayout.CENTER); // Add scrollPane to the center of cluePanel

        for (String person : peopleNames) {
            JCheckBox checkBox = new JCheckBox(person, false);
            peopleCheckBoxPanel.add(checkBox);
        }

        // Create a new button
        notebookButton = new JButton("Add to Inventory");
        talkButton = new JButton("Talk");
        // Add an ActionListener to the button
        notebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Iterate over the checkboxes
                for (Component component : tabbedPane.getComponents()) {
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
                frame.dispose();
            }
        });

        JPanel clueButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        clueButtonPanel.add(notebookButton); // Add the button to the panel
        cluePanel.add(clueButtonPanel, BorderLayout.SOUTH); // Add the button panel to the bottom
        JPanel peopleButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        peopleButtonPanel.add(talkButton);
        peoplePanel.add(peopleButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Clues", cluePanel);
        tabbedPane.addTab("People", peoplePanel);
        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
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
}
