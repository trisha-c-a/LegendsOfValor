public interface GameDetails {

    public void rules();
    public void playGame();

    public boolean checkWinner(HeroGroup heroGroup, MonsterPack monsterPack, World map);
}
