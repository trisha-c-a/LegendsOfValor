import java.util.ArrayList;

public class Cave extends Cell implements ModifyAttribute{

    private ArrayList<String> characters;
    public Cave(String name){
        super(name);
        characters = new ArrayList<String>();
        characters.add(" ");
        characters.add(" ");
    }

    @Override
    public void entry(Hero h) {
        System.out.println("You have entered a cave");
        System.out.println("Increasing your agility to aid your battles....");
        h.setAgilityValue(h.getAgilityValue()*1.1);
        System.out.println("Updated agility: " + h.getAgilityValue());
        this.characters.set(0, String.valueOf(h.getName().charAt(0)));
    }

    @Override
    public void exit(Hero h) {
        System.out.println("You have exited the cave");
        System.out.println("Resetting agility....");
        h.setAgilityValue(h.getAgilityValue()*0.9);
        System.out.println("Updated agility: " + h.getAgilityValue());
        this.characters.set(0, " ");
    }

    public void addChar(Monster m){
        this.characters.set(1, String.valueOf(m.getName().charAt(0)));
    }

    public void removeChar(Monster m){
        this.characters.set(1, " ");
    }
    public void printCell(){
        System.out.println("C  C  C  C");
        System.out.println("C  " + this.characters.get(0) + "  " + this.characters.get(1) + "  C");
        System.out.println("C  C  C  C");
    }

    public void printFirst(){System.out.print("C  C  C  C");}
    public void printSecond(){System.out.print("C  " + this.characters.get(0) + "  " + this.characters.get(1) + "  C");}
    public void printThird(){System.out.print("C  C  C  C");}
}
