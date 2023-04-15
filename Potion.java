public class Potion extends Item{

    //Creates a paladin hero instance
    //Ensures the attributes are set correctly when leveled up
    private int attributeIncrease;
    private String attributeAffected;
    public Potion(String n, double p, long l, int aI, String aA) {
        super(l, p, n, "Potion");
        this.attributeIncrease = aI;
        this.attributeAffected = aA;
    }

    public int getAttributeIncrease(){
        return this.attributeIncrease;
    }
    public String getAttributeAffected(){
        return this.attributeAffected;
    }
}
