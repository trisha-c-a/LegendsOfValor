public class Cell {

    //This is the parent class of all cells
    //It includes name attribute which is used as a type for each cell
    //It also has 3 print methods to be overridden by the child classes

    private String name;
    private String heroPresent;

    private String monsterPresent;

    public Cell(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void printCell(){
        System.out.println("X X X");
    }
    public void printFirst(){}
    public void printSecond(){}
    public void printThird(){}

    //                          GETTERS AND SETTERS

    public String getHeroPresent(){
        return this.heroPresent;
    }
    public String getMonsterPresent(){
        return this.monsterPresent;
    }

    public void setHeroPresent(String name){
        this.heroPresent = name;
    }

    public void setMonsterPresent(String name){
        this.monsterPresent = name;
    }

}
