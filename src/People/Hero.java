package People;
import Weapons.*;
public class Hero extends Person {
    public Hero(String name,
                String role,
                String description,
                boolean isSuspect,
                String relationshipWithVictim,
                boolean isUseful,
                String location){
        super(name, role,description,isSuspect,relationshipWithVictim,isUseful,location);
        Knife knife= new Knife();
        currWeapon = knife;
        //constructor would print the Bio/Background of our hero, we can un comment the below
        //- line later when we figure out the GUI stuff

        //System.out.println(description);
    }

}
