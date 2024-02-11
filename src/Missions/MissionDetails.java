package Missions;

import java.util.Scanner;

class MissionDetails {
    private String title;
    private String Objective;
    private String[] clues;
    private String[] evidence;
    private String directions;
    private String location;
    static Scanner scanner = new Scanner(System.in);
    static Story story = new Story();

    // Getter and setter for title

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter for Objective
    public String getObjective() {
        return Objective;
    }

    public void setObjective(String Objective) {
        this.Objective = Objective;
    }

    // Getter and setter for clues
    public String[] getClues() {
        return clues;
    }

    public void setClues(String[] clues) {
        this.clues = clues;
    }

    // Getter and setter for evidence
    public String[] getEvidence() {
        return evidence;
    }

    public void setEvidence(String[] evidence) {
        this.evidence = evidence;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }



    public static void continueMethod() {
        System.out.print("Type enter to continue:");
        String answer = scanner.nextLine(); // Instead this should be a button.
        if (answer.equalsIgnoreCase("'Enter'")) {
            story.segmentStory();
        } else {
            System.out.println("That is not a valid input");
            continueMethod();
        }
    }


    public static void mission3() {

        MissionDetails mission = new MissionDetails();
        mission.setTitle("Every day is an opportunity disguised as a challenge"); // Quote by Tiki Barber
        mission.setObjective(""); // Continue off of the story plot point given here.
        mission.setDirections("");
        mission.setClues(new String[]{"Mysterious footprint", "Broken display case"}); // clues in this phase to be discovered.
        mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"}); // Evidence to be discovered.
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Clues: " + String.join(", ", mission.getClues()));
        System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
        System.out.println("Directions: " + mission.getDirections());
    }

    public static void mission4() {

        MissionDetails mission = new MissionDetails();
        mission.setTitle("You cannot make progress with excuses"); // Quote by Cam Newton
        mission.setObjective(""); // Continue off of the story plot point given here.
        mission.setDirections("");
        mission.setClues(new String[]{"Mysterious footprint", "Broken display case"}); // clues in this phase to be discovered.
        mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"}); // Evidence to be discovered.
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Clues: " + String.join(", ", mission.getClues()));
        System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
        System.out.println("Directions: " + mission.getDirections());
    }

    public static void mission5() {

        MissionDetails mission = new MissionDetails();
        mission.setTitle("No one ever drowned in sweat"); // Quote by Lou Holtz
        mission.setObjective(""); // Continue off of the story plot point given here.
        mission.setDirections("");
        mission.setClues(new String[]{"Mysterious footprint", "Broken display case"}); // clues in this phase to be discovered.
        mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"}); // Evidence to be discovered.
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Clues: " + String.join(", ", mission.getClues()));
        System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
        System.out.println("Directions: " + mission.getDirections());
    }

    public static void mission6() {

        MissionDetails mission = new MissionDetails();
        mission.setTitle("When you don’t give up, you cannot fail"); // Quote by Adrian Peterson
        mission.setObjective("Follow up on the leads provided by"); // the leads given by whoever initially called.
        mission.setDirections("");
        mission.setClues(new String[]{"Mysterious footprint", "Broken display case"}); // whatever clues that can be found at the starting locations
        mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"});
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Clues: " + String.join(", ", mission.getClues()));
        System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
        System.out.println("Directions: " + mission.getDirections());
    }

    public static void main(String[] args) {
        MissionDetails mission = new MissionDetails();
        mission.setTitle("The Missing Artifact");
        mission.setObjective("Investigate the disappearance of a valuable artifact from the museum.");
        mission.setClues(new String[]{"Mysterious footprint", "Broken display case"});
        mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"});
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Clues: " + String.join(", ", mission.getClues()));
        System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
        System.out.println("Directions: " + mission.getDirections());
    }
}
