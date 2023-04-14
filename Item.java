abstract class Item {
    //This class serve as the parent class for all inventory item classes like weapon, armor, potion and spell
    //It provides the super class constructor methods to be used in the child classes and also setter and getter methods

    public long level;
    public double price;
    public String name;
    public String type;

    public Item(long l, double p, String n, String t){
        this.level = l;
        this.price = p;
        this.name = n;
        this.type = t;
    }

    public Item(){
        this.level = 1;
        this.price = 100;
        this.name = "Default";
        this.type = "Default";
    }

    public long getLevel(){
        return this.level;
    }
    public double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }

    public void setLevel(long l){
        this.level = l;
    }
    public void setPrice(double p){
        this.price = p;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setType(String t){
        this.type = t;
    }
}
