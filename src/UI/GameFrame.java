package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import Engine.*;
import Resources.Sounds;

public class GameFrame extends JFrame implements ViewSwitcher {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private Menu menuPanel;
    private Introduction introductionPanel;
    private GamePlay gamePlayPanel;
    private TheEnd theEndPanel;

    public GameFrame() throws IOException {
        // Declare panels
        menuPanel = new Menu(this);
        introductionPanel = new Introduction(this);
        gamePlayPanel = new GamePlay(this);
        theEndPanel = new TheEnd();
        // Add panels to mainPanel with identifiers
        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(introductionPanel, "INTRODUCTION");
        mainPanel.add(gamePlayPanel, "GAMEPLAY");
        mainPanel.add(theEndPanel, "THEEND");

        Image icon = Toolkit.getDefaultToolkit().getImage("src/Resources/icon.jpg");
        setIconImage(icon);
        // Add mainPanel to JFrame
        add(mainPanel);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(1000, 2000);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Sounds.backgroundMusic();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Engine.resetGameState();
                } catch (Exception ex) {
                    ex.printStackTrace();
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
}

