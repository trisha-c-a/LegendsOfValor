import java.util.ArrayList;

public class Nexus extends Cell{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_Blue = "\u001B[34m";
    public static final String ANSI_Green = "\u001B[32m";
    public static final String ANSI_Red = "\u001B[31m";

    String hostCharacter;
    Market market;

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



    public void printFirst(){System.out.print(ANSI_Blue + "N  N  N  N" + ANSI_RESET);}
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
        System.out.print(ANSI_Blue + "N  " +ANSI_RESET + this.heroPresent + "  " + this.monsterPresent +ANSI_Blue+ "  N" + ANSI_RESET);
    }
    public void printThird(){System.out.print(ANSI_Blue + "N  N  N  N" + ANSI_RESET);}
}
