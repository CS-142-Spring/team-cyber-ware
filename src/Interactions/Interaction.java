package Interactions;

import java.util.Scanner;

public class Interaction {
    private String playerInput;
    Scanner jt = new Scanner(System.in);
    public void getInput(){
        playerInput = jt.nextLine();
    }
    public String wrongInput(){
       return ("That sounds Weird...Please choose from the options given above");
    }
}
