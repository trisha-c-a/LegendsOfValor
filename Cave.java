import java.util.ArrayList;

public class Cave extends Cell implements ModifyAttribute{

    private String heroPresent;

    private String monsterPresent;
    public Cave(String name){
        super(name);
    }

    @Override
    public void entry(Hero h) {
        System.out.println("You have entered a cave");
        System.out.println("Increasing your agility to aid your battles....");
        h.setAgilityValue(h.getAgilityValue()*1.1);
        System.out.println("Updated agility: " + h.getAgilityValue());
    }

    @Override
    public void exit(Hero h) {
        System.out.println("You have exited the cave");
        System.out.println("Resetting agility....");
        h.setAgilityValue(h.getAgilityValue()*0.9);
        System.out.println("Updated agility: " + h.getAgilityValue());
    }
    public void printFirst(){System.out.print("C  C  C  C");}
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
        System.out.print( "C  " + this.heroPresent + "  " + this.monsterPresent + "  C");
    }
    public void printThird(){System.out.print("C  C  C  C");}
}
