public interface Battle {
    // ensures the classes that implements this has the ability to start fight and check winning condition

    public boolean Fight(HeroGroup heroes);

    public boolean hasWon(HeroGroup heroes, MonsterPack monsters);

}
