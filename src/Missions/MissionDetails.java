package Missions;

public class MissionDetails {
    private String title;
    private String Objective;
    private String directions;
    private String location;

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

    // Getter and setter for directions
    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    // Getter and setter for location
    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static void mission1(){ // mission 1 calling its details.
        MissionDetails mission = getMissionDetails1();
        System.out.println("\nLocation: " + mission.getLocation());
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Directions: " + mission.getDirections());
    }

    public static MissionDetails getMissionDetails1(){ // mission 1 details that are set for it.
        MissionDetails mission = new MissionDetails();
        mission.setLocation("Jack Malone's Office");
        mission.setTitle("Mission: " + "Good things come to those who work!"); // Quote by Greg Dortch
        mission.setObjective("\nFollow up on the leads provided by the 'initial caller'.");
        mission.setDirections("Straight");
        return mission;
    }

    public static void mission2() { // mission 1 calling its details.
        MissionDetails mission = getMissionDetails2();
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Directions: " + mission.getDirections());
    }

    private static MissionDetails getMissionDetails2() { // mission 2 details that are set for it.
        MissionDetails mission = new MissionDetails();
        mission.setTitle("Every day is an opportunity disguised as a challenge"); // Quote by Tiki Barber
        mission.setObjective(""); // Continue off of the story plot point given here.
        mission.setDirections("");
        return mission;
    }

    public static void mission3() { // mission 3 calling its details.
        MissionDetails mission = getMissionDetails3();
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Directions: " + mission.getDirections());
    }

    private static MissionDetails getMissionDetails3() { // mission 3 details that are set for it.
        MissionDetails mission = new MissionDetails();
        mission.setTitle("You cannot make progress with excuses"); // Quote by Cam Newton
        mission.setObjective(""); // Continue off of the story plot point given here.
        mission.setDirections("");
        return mission;
    }

    public static void main(String[] args) {
        MissionDetails mission = new MissionDetails();
        mission.setTitle("The Missing Artifact");
        mission.setObjective("Investigate the disappearance of a valuable artifact from the museum.");
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Directions: " + mission.getDirections());
    }
}