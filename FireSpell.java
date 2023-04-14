public class FireSpell extends Spell{
    //Creates an instance of FireSpell item
    //Provides function to allow for usage of the spell
    public FireSpell(String n, double p, long l, double d, double mp) {
        super(l, p, n, "Fire Spell", d, mp);
    }
    public void applyFireSpell(Monster m, double dex){
        super.applySpell(dex,m);
        m.setDefenseValue(m.getDefenseValue()*0.1);
    }
}
