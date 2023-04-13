import java.util.ArrayList;
import java.util.Scanner;

public class Common extends Cell{

    private ArrayList<String> characters;
    public Common(String name) {
        super(name);
        characters = new ArrayList<String>();
        characters.add(" ");
        characters.add(" ");
    }

    public void entry(Hero h) {
        this.characters.set(0, String.valueOf(h.getName().charAt(0)));
    }

    public void exit(Hero h) {
        this.characters.set(0, " ");
    }

    public void addChar(Monster m){
        this.characters.set(1, String.valueOf(m.getName().charAt(0)));
    }

    public void removeChar(Monster m){
        this.characters.set(1, " ");
    }
    public void printCell(){
        System.out.println("P  P  P  P");
        System.out.println("P  " + this.characters.get(0) + "  " + this.characters.get(1) + "  P");
        System.out.println("P  P  P  P");
    }

    public void printFirst(){System.out.print("P  P  P  P");}
    public void printSecond(){System.out.print("P  " + this.characters.get(0) + "  " + this.characters.get(1) + "  P");}
    public void printThird(){System.out.print("P  P  P  P");}

}
