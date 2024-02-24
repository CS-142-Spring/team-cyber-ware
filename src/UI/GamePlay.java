package UI;

import Engine.Engine;
import Inventory.Clue;
import Missions.MissionDetails;
import Missions.MissionsBackBone;
<<<<<<< HEAD
=======
import People.Hero;
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
import People.Person;
import Utility.JsonUtil;

import Location.*;
<<<<<<< HEAD

=======
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
import java.io.IOException;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

<<<<<<< HEAD
import javax.swing.JOptionPane;
=======
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3


import static Engine.Engine.currLocation;
import static Missions.MissionDetails.mission1;
<<<<<<< HEAD
import static Resources.Sounds.PlayMusic;
import static Resources.Sounds.clip;

public class GamePlay extends JPanel {
    private JTextArea textArea;
    private JPanel buttonPanel, textPanel, inventoryPanel, musicControlPanel, northPanel;
    private JButton searchButton, forwardButton, backButton, interactButton, inventoryButton, previousButton,
            playmusicButton, stopmusicButton;
    private int moveIndex = 0;
    private ViewSwitcher viewSwitcher;
=======

public class GamePlay extends JPanel {
    private JTextArea textArea;
    private JPanel buttonPanel, textPanel, inventoryPanel, imagePanel;
    private JButton searchButton, forwardButton, backButton, interactButton, inventoryButton, previousButton;
    private int moveIndex = 0;
    private ViewSwitcher viewSwitcher;

>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
    public GamePlay(ViewSwitcher viewSwitcher) {
        setLayout(new BorderLayout());
        this.viewSwitcher = viewSwitcher;
        //Create text area
        textArea = new JTextArea("You are in Detective's Office");
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textPanel = new JPanel(new BorderLayout());
        textPanel.add(scrollPane, BorderLayout.CENTER);
        add(textPanel, BorderLayout.CENTER);

        // Add the mission one detail
        mission1(textArea);
        // Create buttons
        searchButton = new JButton("Search");
        forwardButton = new JButton("Forward");
        backButton = new JButton("Back");
        interactButton = new JButton("Interact");
        inventoryButton = new JButton("Inventory");
        previousButton = new JButton("Previous");
<<<<<<< HEAD
        playmusicButton = new JButton("Play");
        stopmusicButton = new JButton("Stop");
=======
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3

        // Add buttons to a panel
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        buttonPanel.add(previousButton);
        buttonPanel.add(forwardButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.add(interactButton);

<<<<<<< HEAD
        musicControlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        musicControlPanel.add(playmusicButton);
        musicControlPanel.add(stopmusicButton);

        inventoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        inventoryPanel.add(inventoryButton);

        northPanel = new JPanel(new BorderLayout());
        northPanel.add(musicControlPanel, BorderLayout.WEST);
        northPanel.add(inventoryPanel, BorderLayout.EAST);

        // Add button panel to the main panel
        add(buttonPanel, BorderLayout.SOUTH);
        add(northPanel, BorderLayout.NORTH);

        playmusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayMusic("D:\\Work\\Project - Sounds\\Angel Eyes (Soft Jazz Version).wav");
                System.out.println("I'm being pressed.");
            }
        });

        stopmusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                }
            }
        });
=======
        inventoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        inventoryPanel.add(inventoryButton);
        // Add button panel to the main panel
        add(buttonPanel, BorderLayout.SOUTH);
        add(inventoryPanel, BorderLayout.NORTH);

        // Add button panel to the main panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(inventoryPanel, BorderLayout.NORTH);
        // Create an image panel
        imagePanel = new JPanel(new BorderLayout());
        try {
            ImageIcon imageIcon = new ImageIcon("src/Resources/Detective's office.png");
            JLabel imageLabel = new JLabel(imageIcon);
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Use JSplitPane to divide the frame into three parts
        JSplitPane splitPaneTop = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textPanel, imagePanel);
        splitPaneTop.setResizeWeight(0.5); // This means 50% of space is given to the top component (textPanel)
        JSplitPane splitPaneMain = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPaneTop, bottomPanel);
        splitPaneMain.setResizeWeight(0.7); // This means 70% of space is given to the top component (splitPaneTop)
        add(splitPaneMain, BorderLayout.CENTER);

>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3

        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                Resources.Sounds.doorEffect();
=======
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
                try {
                    if (moveIndex < 3) {
                        if (Engine.getLocation(moveIndex + 1).getAccessibility()) {
                            moveIndex++;
                            Engine.move(moveIndex, textArea);
                        } else {
<<<<<<< HEAD
                            JOptionPane.showMessageDialog(GamePlay.this, "You need a key for this room", "Janitor Closet", JOptionPane.OK_OPTION);
=======
                            JOptionPane.showMessageDialog(GamePlay.this, "You need a key for this room", "No Access", JOptionPane.OK_OPTION);
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
                        }

                    } else {
                        JOptionPane.showMessageDialog(GamePlay.this, "There is no room to go forward", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
<<<<<<< HEAD
=======
                    if(moveIndex==0){
                        updateImage("src/Resources/Detective's office.png");
                    }
                    if (moveIndex == 1) {
                        updateImage("src/Resources/coach.png");
                    } else if (moveIndex == 2 ) {
                        updateImage("src/Resources/hallway.png");
                    }
                    if(moveIndex == 3){
                        updateImage("src/Resources/closet.png");
                    }
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
                    if (moveIndex == 1 && MissionsBackBone.missionOneCompleted()) {
                        MissionDetails.mission2(textArea);
                    } else if (moveIndex == 2 && MissionsBackBone.missionSecondCompleted()) {
                        MissionDetails.mission3(textArea);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                Resources.Sounds.doorEffect();
                try {
=======
                try {
                    if(moveIndex==1){
                        updateImage("src/Resources/Detective's office.png");
                    }
                    if (moveIndex == 2) {
                        updateImage("src/Resources/coach.png");
                    } else if (moveIndex == 3 ) {
                        updateImage("src/Resources/hallway.png");
                    }
                    if (moveIndex == 1 && MissionsBackBone.missionOneCompleted()) {
                        MissionDetails.mission2(textArea);
                    } else if (moveIndex == 2 && MissionsBackBone.missionSecondCompleted()) {
                        MissionDetails.mission3(textArea);
                    }
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
                    if (moveIndex > 0) {
                        moveIndex--;
                        Engine.move(moveIndex, textArea);
                    } else {
                        JOptionPane.showMessageDialog(GamePlay.this, "There is no room to go back", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    if (moveIndex == 2 && MissionsBackBone.missionSecondCompleted()) {
                        MissionDetails.mission3(textArea);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                Resources.Sounds.searchSound();
=======
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
                List<Location> locations;
                try {
                    locations = JsonUtil.getAllLocations();
                    List<Clue> items = new ArrayList<>();
                    List<Person> people = new ArrayList<>();

                    for (Location location : locations) {
                        if (location.getName().equals(currLocation())) {
                            items = location.getItems();
                            people = location.getPeople();
//                            hero = JsonUtil.getMainHero().get(0);
                            location.setIsExamined(true);
                            break;
                        }
                    }

                    int count = 1;
                    if (items.isEmpty()) {
                        textArea.append("\nThe location is empty. \n");
                        return;
                    }
                    if (!items.isEmpty()) {
                        textArea.append("\nYou discovered: \n");
                        textArea.append("  Items: \n");
<<<<<<< HEAD
                        for(Clue clue : items){
=======
                        for (Clue clue : items) {
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
                            textArea.append("     " + count + ". " + clue.getName() + "\n");
                            count++;
                        }
                    }

                    count = 1;
                    if (people.isEmpty()) {
                        return;
                    }

                    textArea.append("\n   People: \n");
                    for (Person person : people) {
                        textArea.append("     " + count + ". " + person.getName() + "\n");
                        count++;
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                    viewSwitcher.switchView("INTRODUCTION");
=======
                viewSwitcher.switchView("INTRODUCTION");
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3

            }
        });


        inventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                Resources.Sounds.inventorySound();
=======
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
                try {
                    InventoryFrame.initializeUI();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        interactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                Resources.Sounds.interactSound();
=======
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
                try {
                    ArrayList<String> items = Engine.interact(GamePlay.this);
                    ArrayList<String> peopleNames = Engine.getPeopleNames();
                    if (items != null) {
                        new InteractFrame(items, peopleNames);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });


<<<<<<< HEAD



=======
    }

    private void updateImage(String path) {
        try {
            ImageIcon imageIcon = new ImageIcon(path);
            JLabel imageLabel = new JLabel(imageIcon);
            imagePanel.removeAll();  // Remove the old image
            imagePanel.add(imageLabel, BorderLayout.CENTER);
            imagePanel.revalidate();
            imagePanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
>>>>>>> ca636992474b57b149fd2c43ee6c6830cc583ce3
    }
}




