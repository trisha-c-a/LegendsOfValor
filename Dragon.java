public class Dragon extends Monster implements FavoredSkill{
    
    //Sets the base damage for the monster type dragon

    public void updateSkill() {
        super.setBaseDamage(super.getBaseDamage()*1.05);
    }
}
