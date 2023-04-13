import java.util.*;
public class Bush extends Cell implements ModifyAttribute{
    private ArrayList<String> characters;
    public Bush(String name){
        super(name);
        characters = new ArrayList<String>();
        characters.add(" ");
        characters.add(" ");
    }
    public void entry(Hero h) {
        System.out.println("You have entered a bush");
        System.out.println("Increasing your dexterity to aid your battles....");
        h.setDexterityValue(h.getDexterityValue()*1.1);
        System.out.println("Updated dexterity: " + h.getDexterityValue());
        this.characters.set(0, String.valueOf(h.getName().charAt(0)));
    }

    public void exit(Hero h) {
        System.out.println("You have exited the bush");
        System.out.println("Resetting dexterity....");
        h.setDexterityValue(h.getDexterityValue()*0.9);
        System.out.println("Updated dexterity: " + h.getDexterityValue());
        this.characters.set(0, " ");
    }

    public void addChar(Monster m){
        this.characters.set(1, String.valueOf(m.getName().charAt(0)));
    }

    public void removeChar(Monster m){
        this.characters.set(1, " ");
    }
    public void printCell(){
        System.out.println("B  B  B  B");
        System.out.println("B  " + this.characters.get(0) + "  " + this.characters.get(1) + "  B");
        System.out.println("B  B  B  B");
    }

    public void printFirst(){System.out.print("B  B  B  B");}
    public void printSecond(){System.out.print("B  " + this.characters.get(0) + "  " + this.characters.get(1) + "  B");}
    public void printThird(){System.out.print("B  B  B  B");}
}
