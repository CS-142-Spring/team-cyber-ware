package Inventory;
import People.*;
import java.util.ArrayList;

//keeps the record of awards,people and clues collected so far

public class Notebook {
    private ArrayList<Clue> clues;
    private ArrayList<Award> awards;
    private ArrayList<Person> people;

    public Notebook(){
        clues = new ArrayList<Clue>();
        awards = new ArrayList<Award>();
        people = new ArrayList<Person>();
    }
    public void addClue(Clue clue){
        clues.add(clue);
    }
    public void addAward(Award award){
        awards.add(award);
    }
    public void addPerson(Person person){
        people.add(person);
    }
}
