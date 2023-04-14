public class Weapon extends Item{
    // The damageValue is used to calculate the amount of damage deal after equiping the weapon
    // The numHands is used to show the number of handles of the weapon
    // Weapon constructor takes the super class Item constructor to set the price and level requirements and adds damageValue and numHands attributes to it

    public double damageValue;
    public int numHands;
    public Weapon(String n, double p, long l, long dV,int numH) {
        super(l, p, n, "Weapon");
        this.damageValue = dV;
        this.numHands = numH;
    }

    public double getDamageValue(){
        return this.damageValue;
    }
    public int getNumHands(){
        return this.numHands;
    }

    public void applyWeapon(Monster m, double strength){
        m.setHP(m.getHP()+m.getDefenseValue() - this.damageValue*strength);
    }
}
