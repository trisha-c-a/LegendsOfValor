public class Inaccessible extends Cell{
    // Creates an instance of cell that is not accesible to all characters
    // The three printing methods are used to display the cell on the map
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_Blue = "\u001B[34m";
    public static final String ANSI_Green = "\u001B[32m";
    public static final String ANSI_Red = "\u001B[31m";
    public Inaccessible(String name) {
        super(name);
    }

    public void printCell(){
        System.out.println(ANSI_Red + "I  I  I  I" + ANSI_RESET);
        System.out.println(ANSI_Red + "I  X  X  I" + ANSI_RESET);
        System.out.println(ANSI_Red + "I  I  I  I" + ANSI_RESET);
    }

    public void printFirst(){System.out.print(ANSI_Red + "I  I  I  I" + ANSI_RESET);}
    public void printSecond(){System.out.print(ANSI_Red + "I  X  X  I" + ANSI_RESET);}
    public void printThird(){System.out.print(ANSI_Red + "I  I  I  I" + ANSI_RESET);}
}
