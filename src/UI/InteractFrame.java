package UI;

import Interactions.Dialogues;
import People.Hero;
import People.Person;
import Utility.JsonUtil;
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

import static Engine.Engine.addItems;
import static Engine.Engine.removeItems;

public class InteractFrame {
    private JButton notebookButton, talkButton;
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel cluePanel, peoplePanel;
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
        ArrayList<String> itemsToRemove = new ArrayList<>();

        // Add an ActionListener to the button
        notebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(clueCheckBoxPanel.getComponents());
                // Iterate over the checkboxes
                for (Component component : clueCheckBoxPanel.getComponents()) {
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
        talkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //closes this frame and opens the new one for having a dialog
                frame.dispose();
                try {
                    Hero mainHero = JsonUtil.getMainHero().getFirst();
                    Person janitor = JsonUtil.getAllPeople().getFirst();
                    Dialogues dialogues = new Dialogues(mainHero, janitor, mainHero.getCurrentLocation());
                    DialogueInterface dialogue = new DialogueInterface(frame, dialogues);
                    dialogue.setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

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


}
