import java.util.ArrayList;
import java.util.Scanner;

public class Common extends Cell{
    // heroPresent and monsterPresent shows the characters that are currently in the cell
    // The three printing methods are used to display the cell on the map


    private String heroPresent;

    private String monsterPresent;
    public Common(String name) {
        super(name);
    }

    public void printFirst(){System.out.print("P  P  P  P");}
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
            System.out.print( "P  " + this.heroPresent + "" + this.monsterPresent + "  P");
        }else if(h == null && m == null){
            System.out.print( "P  " + this.heroPresent + "  " + this.monsterPresent + "  P");
        }else{
            System.out.print( "P  " + this.heroPresent + " " + this.monsterPresent + "  P");
        }
    }
    public void printThird(){System.out.print("P  P  P  P");}

}
