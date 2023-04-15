import java.util.ArrayList;

public class Cave extends Cell implements ModifyAttribute{

    // entry() method takes care of the ability increase when hero enters
    // exit() method resets the ability of hero when it leaves
    // The three printing methods are used to display the cell on the map
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
    public void printFirst(){System.out.print("C - C - C");}
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
    public void printThird(){System.out.print("C - C - C");}
}
