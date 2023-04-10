import java.util.List;

public class Paladin extends Hero implements FavoredSkill{

    public Paladin(String nme, String type, String lane, List<Integer> position, double mp, long exp, double sVal, double dexVal, double agVal, double gAmt){
        super(nme, type, lane, position, mp, exp, sVal, dexVal, agVal,gAmt);
    }

    public void updateSkill() {
        super.setStrengthValue(super.getStrengthValue() * 1.05);
        super.setDexterityValue(super.getDexterityValue() * 1.05);
    }
}
