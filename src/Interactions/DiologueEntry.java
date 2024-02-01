package Interactions;

public class DiologueEntry {
    private String speaker;
    private String line;

    public DiologueEntry(String speaker, String line) {
        this.speaker = speaker;
        this.line = line;
    }

    public String getSpeaker() {
        return this.speaker;
    }

    public String getLine() {
        return this.line;
    }
}
