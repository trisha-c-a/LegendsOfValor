public class IceSpell extends Spell{

    //Creates an instance of IceSpell item
    //Provides function to allow for usage of the spell
    public IceSpell(String n, double p, long l, double d, double mp) {
        super(l, p, n, "Ice Spell", d, mp);
    }
    public void applyIceSpell(Monster m, double dex){
        super.applySpell(dex,m);
        m.setBaseDamage(m.getBaseDamage()*0.1);
    }
}
