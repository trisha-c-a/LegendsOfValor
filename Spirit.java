public class Spirit extends Monster implements FavoredSkill {

    //Creates instance of monster of type Spirit
    //Includes method to set up the base dodge chance of the monster
    public void updateSkill() {
        super.setDodgeAbility(super.getDodgeAbility()*1.05);
    }
}
