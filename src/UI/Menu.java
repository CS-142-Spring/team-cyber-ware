package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel MenuPanel;
    private JButton newGameBtn;
    private JButton resumeBtn;
    private JButton exitBtn;

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
                new Introduction(Menu.this);
            }
        });
    }

    public static void main(String[] args) {
        new Menu();
    }


}