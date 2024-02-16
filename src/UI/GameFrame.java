package UI;
import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame implements ViewSwitcher {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private Menu menuPanel;
    private Introduction introductionPanel;
    private GamePlay gamePlayPanel;

    public GameFrame() {
        // Initialize your panels here
        menuPanel = new Menu(this);
        introductionPanel = new Introduction(this);
        gamePlayPanel = new GamePlay();

        // Add panels to mainPanel with identifiers
        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(introductionPanel, "INTRODUCTION");
        mainPanel.add(gamePlayPanel, "GAMEPLAY");

        // Example button in Menu to switch to Introduction

        // Add mainPanel to JFrame
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }

    public void switchView(String viewName) {
        cardLayout.show(mainPanel, viewName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new GameFrame();
            }
        });
    }


}

