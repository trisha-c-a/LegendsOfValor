abstract class Spell extends Item{
    //This is the parent class of all spell types
    //This class contains the constructor to setup the basic attributes of cells like level, price, name, type etc.
    //Also provides getter methods and action methods to allow hero to cast spell on monster

    public double damage;
    public double MP;
    public Spell(long l, double p, String n, String t, double d, double mp) {
        super(l, p, n, t);
        this.damage = d;
        this.MP = mp;
    }

    public void applySpell(double dex, Monster m){
        m.setHP(m.getHP()+m.getDefenseValue() - this.damage*dex);
    }

    public double getDamage(){
        return this.damage;
    }
    public double getMP(){
        return this.MP;
    }
}
