package People;
import Weapons.*;
import Inventory.*;

public class Hero extends Person {
    Weapon currWeapon;
    Notebook notebook;
    public Hero(String name,
                String role,
                String description,
                boolean isSuspect,
                String relationshipWithVictim,
                boolean isUseful,
                String location){
        super(name, role,description,isSuspect,relationshipWithVictim,isUseful,location);
        Knife knife= new Knife();
        this.currWeapon = knife;
        notebook = new Notebook();
        //constructor would print the Bio/Background of our hero, we can un comment the below
        //- line later when we figure out the GUI stuff
    }

    public void setCurrWeapon(Weapon currWeapon) {
        this.currWeapon = currWeapon;
    }

    public Weapon getCurrWeapon() {
        return this.currWeapon;
    }

    public void addClue(Clue clue) {
        notebook.addClue(clue);
    }

    public void addAward(Award award) {
        notebook.addAward(award);
    }

    public void addPerson(Person person) {
        notebook.addPerson(person);
    }
}
