import java.util.ArrayList;
import java.util.List;

//Can do the following:
//create character with name, level and HP
//update HP when character receives damage/takes a potion
//increase character level
//getters and setters to access/update attributes
abstract class Character {
    private String name;
    private int level;
    private String displayName;
    private double HP;
    private String type;
    private boolean isFainted = false;

    private String lane;

    private List<Integer> currPos = new ArrayList<>(2);
    private List<Integer> nexusPos = new ArrayList<>(2);

    public Character(){
        name = "Null";
        level = 1;
        HP = 1000;
        type = "Null";
    }
    public Character(String displayName, String n, int l, double h, String t, String lane, List<Integer> begin){
        this.name = n;
        this.level = l;
        this.HP = this.level*100;
        this.type = t;
        this.lane = lane;
        this.currPos = begin;
        this.nexusPos = begin;
        this.displayName = displayName;
    }

    public void checkHP(){
        if(this.HP<=0){
            this.isFainted = true;
        }
    }

    //GETTERS AND SETTERS

    public String getName(){
        return this.name;
    }
    public int getLevel(){
        return this.level;
    }

    public String getDisplayName(){return this.displayName;}
    public double getHP(){
        return this.HP;
    }
    public boolean getIsFainted(){
        return this.isFainted;
    }
    public String getType(){
        return this.type;
    }
    public String getLane(){
        return this.lane;
    }

    public List<Integer> getCurrPos(){
        return this.currPos;
    }
    public List<Integer> getNexusPos(){
        return this.nexusPos;
    }

    public void setLevel(int lev){
        this.level = lev;
    }
    public void setHP(double hp){
        this.HP = hp;
    }
    public void setIsFainted(boolean res){
        this.isFainted = res;
    }
    public void setLane(String newLane){
        this.lane = newLane;
    }
    public void setCurrPos(List<Integer> position){
        this.currPos = position;
    }

}
