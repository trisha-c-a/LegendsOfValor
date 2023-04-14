import java.util.*;
public class Bush extends Cell implements ModifyAttribute{

    private String heroPresent;

    private String monsterPresent;
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

    public void printFirst(){System.out.print("B  B  B  B");}
    public void printSecond(Hero h, Monster m){
        if(h == null){
            this.heroPresent = " ";
        }
        else{
            this.heroPresent = h.displayName;
        }
        if(m == null){
            this.monsterPresent = " ";
        }
        else{
            this.monsterPresent = m.displayName;
        }
        System.out.print( "B  " + this.heroPresent + "  " + this.monsterPresent + "  B");
    }
    public void printThird(){System.out.print("B  B  B  B");}
}
