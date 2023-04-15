public class Exoskeleton extends Monster implements FavoredSkill{

    //Set the base damage for the monster type Exoskeleton
    public void updateSkill() {
        super.setDefenseValue(super.getDefenseValue()*1.05);
    }
}
