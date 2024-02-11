package UI;


import javax.swing.*;

public class GamePlay extends JPanel {
    private JPanel MainPanel;
    private JPanel controlsPanel;
    private JButton moveBtn;
    private JButton investigateBtn;
    private JButton searchBtn;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JTextArea text;

    public GamePlay(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.setContentPane(MainPanel);
        frame.setTitle("Opening Scene");
        frame.revalidate();
        frame.repaint();

        text.setEditable(false);
    }


}
