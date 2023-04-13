import java.util.ArrayList;

public class Nexus extends Cell{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_Blue = "\u001B[34m";
    public static final String ANSI_Green = "\u001B[32m";
    public static final String ANSI_Red = "\u001B[31m";

    String hostCharacter;
    Market market;
    private ArrayList<String> characters;
    public Nexus(String name, String characterType){
        super(name);
        this.hostCharacter = characterType;
        if(this.hostCharacter.equals("H")){
            market = new Market("M");
        }
        characters = new ArrayList<String>();
        characters.add(" ");
        characters.add(" ");
    }

    public Market getMarket(){
        return this.market;
    }
    public String getHostCharacter(){
        return this.hostCharacter;
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
        System.out.println(ANSI_Blue + "N  N  N  N" + ANSI_RESET);
        System.out.println(ANSI_Blue + "N  " +ANSI_RESET + this.characters.get(0) + "  " + this.characters.get(1) +ANSI_Blue+ "  N" + ANSI_RESET);
        System.out.println(ANSI_Blue + "N  N  N  N" + ANSI_RESET);
    }

    public void printFirst(){System.out.print(ANSI_Blue + "N  N  N  N" + ANSI_RESET);}
    public void printSecond(){System.out.print(ANSI_Blue + "N  " +ANSI_RESET + this.characters.get(0) + "  " + this.characters.get(1) +ANSI_Blue+ "  N" + ANSI_RESET);}
    public void printThird(){System.out.print(ANSI_Blue + "N  N  N  N" + ANSI_RESET);}
}
