package People;
import Inventory.Clue;
import Location.*;
import java.util.ArrayList;
import java.util.List;

import Interactions.Dialogues;

public class Person {
    private String name;  // Holds the name of the person
    private String role;  // Role or occupation of the person
    private String description;  // A brief description of the person
    private String suspectReason;
    private List<Dialogues> conversations;  // List to store conversations with the person
    private int relationshipWithPlayer;  // Numerical value representing the relationship with the player
    private String relationshipWithVictim; // Wife, children, colleagues;
    private String usefulness;
    private Location currentLocation;
    private List<String> traits;
    private List<Clue> clues;
    private double age;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Person(String name,
                  String role,
                  String description,
                  String suspectReason,
                  List<Dialogues> conversations,
                  String relationshipWithVictim,
                  String usefulness,
                  Location location,
                  List<String> traits,
                  List<Clue> clues,
                  double age) {
        this.name = name;
        this.role = role;
        this.age = age;
        this.description = description;
        this.suspectReason = suspectReason;
        this.conversations = conversations;
        this.relationshipWithPlayer = 0;
        this.relationshipWithVictim = relationshipWithVictim;
        this.usefulness = usefulness;
        this.currentLocation = location;
        this.traits = traits;
        this.clues = clues;
    }

    // if there is no suspect reason and usefullness
    public Person(String name,
                  String role,
                  String description,
                  String relationshipWithVictim,
                  Location location,
                  double age) {
        this.name = name;
        this.role = role;
        this.age = age;
        this.description = description;
        this.conversations = new ArrayList<>();
        this.relationshipWithPlayer = 0;
        this.relationshipWithVictim = relationshipWithVictim;
        this.currentLocation = location;
    }

    public double getAge() {
        return this.age;
    }

    public List<Clue> getClues() {
        return this.clues;
    }

    // Change the traits of a person
    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    public List<String> getTraits() {
        return traits;
    }

    public String getUsefulness() {
        return this.usefulness;
    }

    public boolean isUseful() {
        return this.getUsefulness().isEmpty();
    }

    public String getSuspectReason() {
        return this.suspectReason;
    }

    public boolean isSuspect() {
        return this.getSuspectReason() != null;
    }


    public List<Dialogues> getConversations() {
        return this.conversations;
    }

    public void addConversation(Dialogues conversation) {
        /*
            Add a converstion in order to keep record of interactions
            Player might want to come back to the story
            This is where we could show details of a character
         */
        this.conversations.add(conversation);
    }

    public void updateRelationship(int value) {
        // As the number gets bigger the better the relationship with player is
        this.relationshipWithPlayer += value;
    }

    public int getRelationshipWithPlayer() {
        return relationshipWithPlayer;
    }

    public boolean isTrustworthy() {
        return this.relationshipWithPlayer > 0;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() { return this.description; }

    public String getCurrentLocation() { return this.currentLocation.getName(); }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
        this.currentLocation.setAccessibility(true);
    }

    public String getRole() {
        return this.role;
    }

    public String getRelationshipWithVictim() {
        return relationshipWithVictim;
    }

}

