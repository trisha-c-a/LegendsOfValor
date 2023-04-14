public class Cell {
    //This is the parent class of all cells
    //It includes name attribute which is used as a type for each cell
    //It also has 3 print methods to be override by the child classes

    public String name;

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

}
