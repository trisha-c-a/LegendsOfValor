public class Bush extends Cell implements ModifyAttribute{
    public Bush(String name){
        super(name);
    }
    public void entry(Hero h) {
        System.out.println("You have entered a cave");
        System.out.println("Increasing your dexterity to aid your battles....");
        h.setDexterityValue(h.getDexterityValue()*1.1);
        System.out.println("Updated dexterity: " + h.getDexterityValue());
    }

    public void exit(Hero h) {
        System.out.println("You have exited the cave");
        System.out.println("Resetting dexterity....");
        h.setDexterityValue(h.getDexterityValue()*0.9);
        System.out.println("Updated dexterity: " + h.getDexterityValue());
    }
}
