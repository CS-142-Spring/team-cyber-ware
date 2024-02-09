package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel MenuPanel;
    private JPanel Menu;
    private JPanel OpeningScene;
    private JButton newGameBtn;
    private JButton resumeBtn;
    private JButton exitBtn;
    private JTextArea textArea1;
    private JButton continueButton;
    private JButton newGameButton;

    public Menu() {
        setContentPane(MenuPanel);
        setTitle("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000, 2000);
        setExtendedState(MAXIMIZED_BOTH);
        //setUndecorated(true);
        setVisible(true);

        newGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGame(Menu.this);
            }
        });
    }

    public static void main(String[] args) {
        new Menu();
    }


}
