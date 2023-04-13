import java.util.ArrayList;

public class Koulou extends Cell implements ModifyAttribute{
    private ArrayList<String> characters;

    public Koulou(String name){
        super(name);
        characters = new ArrayList<String>();
        characters.add(" ");
        characters.add(" ");
    }
    @Override
    public void entry(Hero h) {
        System.out.println("You have entered a koulou");
        System.out.println("Increasing your strength to aid your battles....");
        h.setStrengthValue(h.getStrengthValue()*1.1);
        System.out.println("Updated strength: " + h.getStrengthValue());
        this.characters.set(0, String.valueOf(h.getName().charAt(0)));
    }

    @Override
    public void exit(Hero h) {
        System.out.println("You have exited the koulou");
        System.out.println("Resetting strength....");
        h.setStrengthValue(h.getStrengthValue()*0.9);
        System.out.println("Updated strength: " + h.getStrengthValue());
        this.characters.set(0, " ");
    }

    public void addChar(Monster m){
        this.characters.set(1, String.valueOf(m.getName().charAt(0)));
    }

    public void removeChar(Monster m){
        this.characters.set(1, " ");
    }
    public void printCell(){
        System.out.println("K  K  K  K");
        System.out.println("K  " + this.characters.get(0) + "  " + this.characters.get(1) + "  K");
        System.out.println("K  K  K  K");
    }

    public void printFirst(){System.out.print("K  K  K  K");}
    public void printSecond(){System.out.print("K  " + this.characters.get(0) + "  " + this.characters.get(1) + "  K");}
    public void printThird(){System.out.print("K  K  K  K");}
}
