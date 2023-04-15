public class Armor extends Item{

    // Armor constructor takes the super class Item constructor to set the price and level requirements and adds damageReduction attributes to it
    // The damageReduction is used to calculate the amount of damage taken after equipping the armor
    private long damageReduction;
    public Armor(String n,  double p, long l, long dR) {
        super(l, p, n, "Armor");
        this.damageReduction = dR;
    }

    public long getDamageReduction(){
        return this.damageReduction;
    }

}
