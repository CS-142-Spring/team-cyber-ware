package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static Game.Game.resetGameState;

public class GameFrame extends JFrame implements ViewSwitcher {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private Menu menuPanel;
    private Introduction introductionPanel;
    private GamePlay gamePlayPanel;

    public GameFrame() {
        // Declare panels
        menuPanel = new Menu(this);
        introductionPanel = new Introduction(this);
        gamePlayPanel = new GamePlay();

        // Add panels to mainPanel with identifiers
        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(introductionPanel, "INTRODUCTION");
        mainPanel.add(gamePlayPanel, "GAMEPLAY");

        // Add mainPanel to JFrame
        add(mainPanel);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(1000, 2000);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    resetGameState(); // Assuming GameReset is the class containing your reset logic
                    System.out.println("Game reset successfully.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Failed to reset the game.");
                } finally {
                    // Close the frame and exit the application after resetting
                    GameFrame.this.dispose(); // Dispose the current frame
                    System.exit(0); // Terminate the application
                }
            }
        });
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

