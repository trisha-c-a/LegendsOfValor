public class Cave extends Cell implements ModifyAttribute{

    public Cave(String name){
        super(name);
    }

    @Override
    public void entry(Hero h) {
        System.out.println("You have entered a cave");
        System.out.println("Increasing your agility to aid your battles....");
        h.setAgilityValue(h.getAgilityValue()*1.1);
        System.out.println("Updated agility: " + h.getAgilityValue());
    }

    @Override
    public void exit(Hero h) {
        System.out.println("You have exited the cave");
        System.out.println("Resetting agility....");
        h.setAgilityValue(h.getAgilityValue()*0.9);
        System.out.println("Updated agility: " + h.getAgilityValue());
    }
}
