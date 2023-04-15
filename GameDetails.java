public interface GameDetails {

    //This interface ensures the flow of the game on classes that implement it.
    //All games that implements this interface must contain the following three methods to ensure a good flow on gaming experience

    public void rules();
    public void playGame();

    public boolean checkWinner(HeroGroup heroGroup, MonsterPack monsterPack, World map);
}
