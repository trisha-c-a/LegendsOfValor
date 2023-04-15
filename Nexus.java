import java.util.ArrayList;

public class Nexus extends Cell{

    // heroPresent and monsterPresent shows the characters that are currently in the cell
    // The three printing methods are used to display the cell on the map
    // This class also contains method to ensure the hero will be able to access Market in their own nexus cell
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_Blue = "\u001B[34m";
    private static final String ANSI_Green = "\u001B[32m";
    private static final String ANSI_Red = "\u001B[31m";

    private String hostCharacter;
    private Market market;

    private String heroPresent;

    private String monsterPresent;
    public Nexus(String name, String characterType){
        super(name);
        this.hostCharacter = characterType;
        if(this.hostCharacter.equals("H")){
            market = new Market("M");
        }
    }

    public Market getMarket(){
        return this.market;
    }
    public String getHostCharacter(){
        return this.hostCharacter;
    }



    public void printFirst(){System.out.print(ANSI_Blue + "N - N - N" + ANSI_RESET);}
    public void printSecond(Hero h, Monster m){
        if(h == null){
            this.heroPresent = "  ";
        }
        else{
            this.heroPresent = h.getDisplayName();
        }
        if(m == null){
            this.monsterPresent = "  ";
        }
        else{
            this.monsterPresent = m.getDisplayName();
        }
        System.out.print(ANSI_Blue + "| " +ANSI_RESET + this.heroPresent + " " + this.monsterPresent +ANSI_Blue+ " |" + ANSI_RESET);
    }
    public void printThird(){System.out.print(ANSI_Blue + "N - N - N" + ANSI_RESET);}
}
