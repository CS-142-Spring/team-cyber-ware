package Inventory;

import java.util.ArrayList;

public class Clue {
    private String name;
    private String description;
    private String location;
    private String relevance; // An assessment of how the clue relates to the case or investigation.
    private String timestamp; // When the clue was found or believed to have been created/left
    private String clueType; // The type of clue (e.g., physical, testimonial, circumstantial).
    private boolean isExamined;
    private ArrayList<Clue> connectedClues; // Array of Clue objects that are connected to this clue
    private int evidenceStrength; // from 0 to 10

    public Clue(String name, String description, String location, String relevance,
                String timestamp, String clueType, int evidenceStrength) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.relevance = relevance;
        this.timestamp = timestamp;
        this.clueType = clueType;
        this.isExamined = false;
        this.evidenceStrength = evidenceStrength;
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }

    public String getRelevance() {
        return this.relevance;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getClueType() {
        return this.clueType;
    }

    public boolean isExamined() {
        return this.isExamined;
    }

    public ArrayList<Clue> getConnectedClues() {
        return this.connectedClues;
    }

    public int getEvidenceStrength() {
        return evidenceStrength;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setClueType(String clueType) {
        this.clueType = clueType;
    }


    public void setEvidenceStrength(int evidenceStrength) {
        this.evidenceStrength = evidenceStrength;
    }

    public void examineClue() {
        // Logic to examine the clue
        this.isExamined = true;
    }

    // Method to connect this clue with another clue
    public void connectClue(Clue anotherClue) {
        // Logic to connect this clue with another clue
        this.connectedClues.add(anotherClue);
    }
}


