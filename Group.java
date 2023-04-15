public interface Group {

    //This interface makes sure the HeroGroup class and MonsterPack class implement the following methods
    //These methods helps check the current status of the characters inside the groups

    public void stats();

    public String characterExists(String name);
    public long notFaint();
    public int getHighestLevel();
}
