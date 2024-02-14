package UI;

import Engine.Engine;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GamePlay extends JPanel {
    private JPanel MainPanel;
    private JPanel controlsPanel;
    private JButton forwardBtn;
    private JButton investigateBtn;
    private JButton searchBtn;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JTextArea text;
    private JButton backBtn;
    private int moveIndex = 0;
    public GamePlay(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.setContentPane(MainPanel);
        frame.setTitle("Game");
        frame.revalidate();
        frame.repaint();
        text.setEditable(false);

        forwardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (moveIndex < 8) {
                        moveIndex++;
                        Engine.move(moveIndex, frame);
                    } else {
                        JOptionPane.showMessageDialog(frame, "There is no room to go forward", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (moveIndex > 0) {
                        moveIndex--;
                        Engine.move(moveIndex, frame);
                    } else {
                        JOptionPane.showMessageDialog(frame, "There is no room to go back", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


}
