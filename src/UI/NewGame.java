package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NewGame extends JPanel {

    private JPanel Story;
    private JTextArea openingScene;
    private JButton continueButton;

    public NewGame(JFrame frame) {
        //Extract opening scene from the resources folder
        String filePath = "C:\\Users\\Hp\\IdeaProjects\\team-cyber-ware\\src\\Resources\\OpeningScene";
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n"); // Append newline to preserve file structure
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
            return;
        }



        // Add the content into text area
        String content = contentBuilder.toString();
        openingScene.append(content);
        openingScene.setEditable(false);


        frame.getContentPane().removeAll();
        frame.setContentPane(Story);
        frame.setTitle("Opening Scene");
        frame.revalidate();
        frame.repaint();
        setVisible(true);


        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

}
