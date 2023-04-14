import java.util.ArrayList;

public class Cave extends Cell implements ModifyAttribute{
    // heroPresent and monsterPresent shows the characters that are currently in the cell
    // entry() method takes care of the ability increase when hero enters
    // exit() method resets the ability of hero when it leaves
    // The three printing methods are used to display the cell on the map

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
        if(h!=null && m != null) {
            System.out.print( "C  " + this.heroPresent + "" + this.monsterPresent + "  C");
        }else if(h == null && m == null){
            System.out.print( "C  " + this.heroPresent + "  " + this.monsterPresent + "  C");
        }else{
            System.out.print( "C  " + this.heroPresent + " " + this.monsterPresent + "  C");
        }
    }
    public void printThird(){System.out.print("C  C  C  C");}
}
