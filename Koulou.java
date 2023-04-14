import java.util.ArrayList;

public class Koulou extends Cell implements ModifyAttribute{

    private String heroPresent;

    private String monsterPresent;

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

    public void printFirst(){System.out.print("K  K  K  K");}
    public void printSecond(Hero h, Monster m){
        if(h == null){
            this.heroPresent = " ";
        }
        else{
            this.heroPresent = h.displayName;
        }
        if(m == null){
            this.monsterPresent = " ";
        }
        else{
            this.monsterPresent = m.displayName;
        }
        System.out.print( "K  " + this.heroPresent + "  " + this.monsterPresent + "  K");
    }
    public void printThird(){System.out.print("K  K  K  K");}
}
