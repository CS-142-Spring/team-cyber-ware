package UI;

import Utility.FileIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Introduction extends JPanel {

    private JPanel IntroPanel;
    private JTextArea openingText;
    private JButton openContinueBtn;
    private JPanel Opening;
    private JTextArea keyWordsText;
    private JButton keyContinueButton;
    private JPanel keyWordsPanel;

    public Introduction(JFrame frame) {
        CardLayout cardLayout = (CardLayout) IntroPanel.getLayout();

        setOpeningScene(frame);
        cardLayout.show(IntroPanel, "Card1");
        openContinueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setKeyWordsHelp(cardLayout);
            }
        });

        keyContinueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GamePlay(frame);
            }
        });
    }

    private void setOpeningScene(JFrame frame) {
        //Extract opening scene from the resources folder
        String filePath = "C:\\Users\\Hp\\IdeaProjects\\team-cyber-ware\\src\\Resources\\OpeningScene";
        String content = FileIO.extractContent(filePath);

        openingText.setText(content);
        openingText.setEditable(false);

        frame.getContentPane().removeAll();
        frame.setContentPane(IntroPanel);
        frame.setTitle("Opening Scene");
        frame.revalidate();
        frame.repaint();

    }

    private void setKeyWordsHelp(CardLayout cardLayout) {
        String filePath = "C:\\Users\\Hp\\IdeaProjects\\team-cyber-ware\\src\\Resources\\KeyWordsHelp";
        String content = FileIO.extractContent(filePath);

        keyWordsText.setText(content);
        keyWordsText.setEditable(false);
        cardLayout.show(IntroPanel, "Card2");
    }
}
