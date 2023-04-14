public interface ModifyAttribute {
    //This class ensures that all celss that involve update attribute during entry and exit implement the following two methods

    public void entry(Hero h);
    public void exit(Hero h);

}
