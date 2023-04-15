import java.util.List;

public class Sorceror extends Hero implements FavoredSkill{

    //Creates a Sorceror hero instance
    //Ensures the attributes are set correctly when leveled up

    public Sorceror(String displayName, String nme, String type, String lane, List<Integer> position, double mp, long exp, double sVal, double dexVal, double agVal, double gAmt){
        super(displayName, nme, type, lane, position, mp, exp, sVal, dexVal, agVal,gAmt);
    }

    public void updateSkill() {
        super.setDexterityValue(super.getDexterityValue() * 1.05);
        super.setAgilityValue(super.getAgilityValue() * 1.05);
    }
}
