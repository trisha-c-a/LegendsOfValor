import java.util.ArrayList;
import java.util.Scanner;

public class Common extends Cell{


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
        System.out.print( "P  " + this.heroPresent + "  " + this.monsterPresent + "  P");
    }
    public void printThird(){System.out.print("P  P  P  P");}

}
