import java.util.List;

public class Warrior extends Hero implements FavoredSkill{

    public Warrior(String displayName, String nme, String type, String lane, List<Integer> position, double mp, long exp, double sVal, double dexVal, double agVal, double gAmt){
        super(displayName, nme, type, lane, position, mp, exp, sVal, dexVal, agVal,gAmt);
    }

    public void updateSkill() {
        super.setStrengthValue(super.getStrengthValue() * 1.05);
        super.setAgilityValue(super.getAgilityValue() * 1.05);
    }

}
