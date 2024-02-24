package UI;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EndMessage {
    public static void displayEndMessage1(ViewSwitcher viewSwitcher) {
        try {
            Path filePath = Paths.get("src/Resources/EndMessage"); // Path to end message file
            String endMessage = new String(Files.readAllBytes(filePath));
            JOptionPane.showMessageDialog(null, endMessage, "End Message", JOptionPane.INFORMATION_MESSAGE);
            viewSwitcher.switchView("THEEND"); // Switch to TheEnd panel after showing the message
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
