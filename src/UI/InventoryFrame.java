package UI;

import Inventory.Notebook;
import Inventory.Clue;
import Inventory.Award;
import People.Person;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryFrame extends JFrame {
    private Notebook notebook;

    public InventoryFrame(Notebook notebook) {
        this.notebook = notebook;
        initializeUI();
    }

    private void initializeUI() {
        // set window characteristics
        setTitle("Inventory");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // initialize JObjects
        JTabbedPane tabbedPane = new JTabbedPane();
        JTextArea cluesArea = new JTextArea();
        JTextArea awardsArea = new JTextArea();
        JTextArea peopleArea = new JTextArea();

        cluesArea.setEditable(false);
        awardsArea.setEditable(false);
        peopleArea.setEditable(false);

        // Write the items into teaxt areas
        populateTextArea(cluesArea, notebook.getClues());
        populateTextArea(awardsArea, notebook.getAwards());
        populateTextArea(peopleArea, notebook.getPeople());

        tabbedPane.addTab("Clues", new JScrollPane(cluesArea));
        tabbedPane.addTab("Awards", new JScrollPane(awardsArea));
        tabbedPane.addTab("People", new JScrollPane(peopleArea));

        add(tabbedPane);
    }

    private void populateTextArea(JTextArea textArea, List<?> items) {
        // Creates the structure of a text area
        StringBuilder sb = new StringBuilder();
        for (Object item : items) {
            sb.append(item.toString()).append("\n");
        }
        textArea.setText(sb.toString());
    }
}
