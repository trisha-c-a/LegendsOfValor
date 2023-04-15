import java.util.*;
public class Bush extends Cell implements ModifyAttribute{

    // entry() method takes care of the ability increase when hero enters
    // exit() method resets the ability of hero when it leaves
    // The three printing methods are used to display the cell on the map

    public Bush(String name){
        super(name);
    }
    public void entry(Hero h) {
        System.out.println("You have entered a bush");
        System.out.println("Increasing your dexterity to aid your battles....");
        h.setDexterityValue(h.getDexterityValue()*1.1);
        System.out.println("Updated dexterity: " + h.getDexterityValue());
    }

    public void exit(Hero h) {
        System.out.println("You have exited the bush");
        System.out.println("Resetting dexterity....");
        h.setDexterityValue(h.getDexterityValue()*0.9);
        System.out.println("Updated dexterity: " + h.getDexterityValue());
    }

    public void printFirst(){System.out.print("B - B - B");}
    public void printSecond(Hero h, Monster m){
        if(h == null){
            super.setHeroPresent("  ");
        }
        else{
            super.setHeroPresent(h.getDisplayName());
        }
        if(m == null){
            super.setMonsterPresent("  ");
        }
        else{
            super.setMonsterPresent(m.getDisplayName());
        }
        System.out.print( "| " + super.getHeroPresent() + " " + super.getMonsterPresent() + " |");
    }
    public void printThird(){System.out.print("B - B - B");}
}
