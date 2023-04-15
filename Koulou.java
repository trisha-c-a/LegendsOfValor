public class Koulou extends Cell implements ModifyAttribute{

    // entry() method takes care of the ability increase when hero enters
    // exit() method resets the ability of hero when it leaves
    // The three printing methods are used to display the cell on the map

    public Koulou(String name){
        super(name);
    }
    @Override
    public void entry(Hero h) {
        System.out.println("You have entered a koulou");
        System.out.println("Increasing your strength to aid your battles....");
        h.setStrengthValue(h.getStrengthValue()*1.1);
        System.out.println("Updated strength: " + h.getStrengthValue());
    }

    @Override
    public void exit(Hero h) {
        System.out.println("You have exited the koulou");
        System.out.println("Resetting strength....");
        h.setStrengthValue(h.getStrengthValue()*0.9);
        System.out.println("Updated strength: " + h.getStrengthValue());
    }

    public void printFirst(){System.out.print("K - K - K");}
    public void printSecond(Hero h, Monster m){
        if(h == null){
            super.setHeroPresent("  ");
        }
        else{
            super.setHeroPresent(h.getDisplayName());
        }
        if(m == null){
            super.setMonsterPresent("  ");
        }
        else{
            super.setMonsterPresent(m.getDisplayName());
        }
        System.out.print( "| " + super.getHeroPresent() + " " + super.getMonsterPresent() + " |");
    }
    public void printThird(){System.out.print("K - K - K");}
}
