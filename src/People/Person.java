package People;

import java.util.ArrayList;

public class Person {
    private String name;  // Holds the name of the person
    private String role;  // Role or occupation of the person
    private String description;  // A brief description of the person
    private boolean isSuspect;  // Flag to indicate if the person is a suspect
    private ArrayList<String> conversations;  // List to store conversations with the person
    private int relationshipWithPlayer;  // Numerical value representing the relationship with the player
    private String relationsipWithVictim; // Wife, children, colleagues;
    public Person(String name, String role, String description, boolean isSuspect, String relationsipWithVictim) {
        this.name = name;
        this.role = role;
        this.description = description;
        this.isSuspect = isSuspect;
        this.conversations = new ArrayList<>();
        this.relationshipWithPlayer = 0;
        this.relationsipWithVictim = relationsipWithVictim;
    }

    public void addConversation(String conversation) {

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

    public boolean isTrustworthy() {
        return this.relationshipWithPlayer > 0;
    }

    @Override
    public String toString() {
        return name + ", " + role + ": " + description;
    }

    public void setName(String newName) {
        /*
            Change the name
         */
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSuspect() {
        return this.isSuspect;
    }
}

