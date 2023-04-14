import java.util.List;

public class Monster extends Character{
    public double baseDamage;
    public double defenseValue;
    public double dodgeAbility;

    //Constructor for default monster
    public Monster(){
        super();
        this.baseDamage = 500;
        this.defenseValue = 600;
        this.dodgeAbility = 550;
    }

    //Constructor for default character but user defined monster attributes
    public Monster(double bD, double dV, double dA){
        super();
        this.baseDamage = bD;
        this.defenseValue = dV;
        this.dodgeAbility = dA;
    }

    //Constructor for user defined monster attributes
    public Monster(String displayName, String nme, String typ, int lvl, String lane, List<Integer> position, double bD, double dV, double dA){
        super(displayName, nme,lvl,100,typ,lane, position);
        this.baseDamage = bD;
        this.defenseValue = dV;
        this.dodgeAbility = dA;
    }

    public void attackHero(Hero h){
        Random random = new Random();
        double chance = 0.002;
        if(random.heroDodge(h.getAgilityValue(),chance)){
            System.out.println(h.getDisplayName() + " has dodged " + this.getDisplayName() + " attack!");
        }
        else {
            h.setHP(h.getHP() - this.getBaseDamage());
            System.out.println(this.getDisplayName() + " has attacked " + h.getDisplayName() + " for " + this.baseDamage + " damage!");
        }
    }

    public boolean monsterValidMove(HeroGroup HeroGroup){
        for(int i = 0 ; i < HeroGroup.getNumberOfHeros(); i++){
            if(this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1))){
                return false;
            }else if(this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)-1)){
                return false;
            }else if(this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)+1)){
                return false;
            }
        }
        return true;
    }

    public Hero heroInRange(HeroGroup HeroGroup){
        for(int i = 0 ; i < HeroGroup.getNumberOfHeros(); i++){
            if(this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0)) &&
                    (this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1))
                            || this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)+1)
                            ||this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)-1))){
                return HeroGroup.getPack().get(i);
            }
            else if (this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)) &&
                    (this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0))
                            || this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0)+1)
                            ||this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0)-1))){
                return HeroGroup.getPack().get(i);
            }
            else if(this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0)-1) && this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)+1)){
                return HeroGroup.getPack().get(i);
            }else if(this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0) + 1) && this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)+1)){
                return HeroGroup.getPack().get(i);
            }else if(this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0)-1) && this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)-1)){
                return HeroGroup.getPack().get(i);
            }else if(this.getCurrPos().get(0).equals(HeroGroup.getPack().get(i).getCurrPos().get(0) + 1) && this.getCurrPos().get(1).equals(HeroGroup.getPack().get(i).getCurrPos().get(1)-1)){
                return HeroGroup.getPack().get(i);
            }
        }
        return null;
    }

                                            //GETTERS AND SETTERS
    public double getBaseDamage(){
        return this.baseDamage;
    }

    public double getDefenseValue(){
        return this.defenseValue;
    }

    public double getDodgeAbility(){
        return this.dodgeAbility;
    }

    public void setBaseDamage(double bD){
        this.baseDamage = bD;
    }
    public void setDefenseValue(double dV){
        this.defenseValue = dV;
    }
    public void setDodgeAbility(double dA){
        this.dodgeAbility = dA;
    }
}
