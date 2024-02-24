package UI;

import Engine.Engine;
import Inventory.Clue;
import Missions.MissionDetails;
import Missions.MissionsBackBone;

import People.Person;
import Utility.JsonUtil;

import Location.*;

import java.io.File;
import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;



import static Engine.Engine.currLocation;
import static Missions.MissionDetails.mission1;
import static Resources.Sounds.PlayMusic;
import static Resources.Sounds.clip;

public class GamePlay extends JPanel {
    private Map<String, Image> locationImages; // A map to hold the images for each location
    private String currentLocation; // The current location identifier

    private JTextArea textArea;
    private JPanel buttonPanel, textPanel, inventoryPanel, musicControlPanel, northPanel;
    private JButton searchButton, forwardButton, backButton, interactButton, inventoryButton, previousButton,
            playmusicButton, stopmusicButton;
    private int moveIndex = 0;
    private ViewSwitcher viewSwitcher;
    private Image backgroundImage;

    public GamePlay(ViewSwitcher viewSwitcher) throws IOException {

        locationImages = new HashMap<>();
        // Load the images for each location
        locationImages.put("Detective's Office", ImageIO.read(new File("src/Resources/DetectiveOffice.jpg")));
        locationImages.put("Coach Marlowe’s Office", ImageIO.read(new File("src/Resources/coachOffice.jpg")));
        locationImages.put("Mega Stadium Hallway", ImageIO.read(new File("src/Resources/hallway.jpg")));
        locationImages.put("Janitor's Closet", ImageIO.read(new File("src/Resources/closet.jpg")));

        currentLocation = "Detective's Office";


        setOpaque(false);
        setLayout(new BorderLayout());
        this.viewSwitcher = viewSwitcher;
        //Create text area
        textArea = new JTextArea("You are in Detective's Office");
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 18));
        textArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null); // Remove border to keep the noir theme

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
        playmusicButton = new JButton("Play");
        stopmusicButton = new JButton("Stop");

        styleButton(previousButton);
        styleButton(searchButton);
        styleButton(forwardButton);
        styleButton(interactButton);
        styleButton(backButton);
        styleButton(stopmusicButton);
        styleButton(playmusicButton);
        styleButton(inventoryButton);

        // Add buttons to a panel
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        buttonPanel.add(previousButton);
        buttonPanel.add(forwardButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.add(interactButton);

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
        buttonPanel.setOpaque(false);
        musicControlPanel.setOpaque(false);
        northPanel.setOpaque(false);
        inventoryPanel.setOpaque(false);
        textPanel.setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black background
        textArea.setOpaque(false);
        playmusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayMusic("src/Resources/Angel Eyes (Soft Jazz Version).wav");
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


        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Resources.Sounds.doorEffect();

                try {
                    if (moveIndex < 3) {
                        if (Engine.getLocation(moveIndex + 1).getAccessibility()) {
                            moveIndex++;
                            changeLocation(Engine.getLocation(moveIndex).getName());
                            Engine.move(moveIndex, textArea);
                        } else {
                            JOptionPane.showMessageDialog(GamePlay.this, "You need a key for this room", "Janitor Closet", JOptionPane.OK_OPTION);

                        }

                    } else {
                        JOptionPane.showMessageDialog(GamePlay.this, "There is no room to go forward", "Warning", JOptionPane.WARNING_MESSAGE);
                    }


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
                Resources.Sounds.doorEffect();
                try {
                    if (moveIndex == 1 && MissionsBackBone.missionOneCompleted()) {
                        MissionDetails.mission2(textArea);
                    } else if (moveIndex == 2 && MissionsBackBone.missionSecondCompleted()) {
                        MissionDetails.mission3(textArea);
                    }
                    if (moveIndex > 0) {
                        moveIndex--;
                        changeLocation(Engine.getLocation(moveIndex).getName());
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
                Resources.Sounds.searchSound();
                List<Location> locations;
                try {
                    locations = JsonUtil.getAllLocations();
                    List<Clue> items = new ArrayList<>();
                    List<Person> people = new ArrayList<>();

                    for (Location location : locations) {
                        if (location.getName().equals(currLocation())) {
                            items = location.getItems();
                            people = location.getPeople();
                            location.setIsExamined(true);
                            break;
                        }
                    }

                    textArea.setText(""); // Clear the text area before adding new text
                    StringBuilder sb = new StringBuilder();

                    if (!items.isEmpty()) {
                        sb.append("\nYou discovered: \n").append("  Items: \n");
                        int count = 1;
                        for(Clue clue : items){
                            sb.append("     ").append(count).append(". ").append(clue.getName()).append("\n");
                            count++;
                        }
                    } else {
                        sb.append("\nThe location is empty. \n");
                    }

                    if (!people.isEmpty()) {
                        sb.append("\n   People: \n");
                        int count = 1;
                        for (Person person : people) {
                            sb.append("     ").append(count).append(". ").append(person.getName()).append("\n");
                            count++;
                        }
                    }

                    textArea.append(sb.toString());
                    revalidate();
                    repaint();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSwitcher.switchView("INTRODUCTION");

            }
        });


        inventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Resources.Sounds.inventorySound();
                try {
                    InventoryFrame.initializeUI();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        interactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Resources.Sounds.interactSound();
                try {
                    ArrayList<String> items = Engine.interact(GamePlay.this);
                    ArrayList<String> peopleNames = Engine.getPeopleNames();
                    if (items != null) {
                        new InteractFrame(items, peopleNames, viewSwitcher);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgImage = locationImages.get(currentLocation);
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void changeLocation(String newLocation) {
        currentLocation = newLocation; // Change the location
        backgroundImage = locationImages.get(currentLocation); // Get the corresponding image
        repaint(); // This will cause paintComponent to be called and the background to be updated
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Courier New", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

}




