public class Koulou extends Cell implements ModifyAttribute{

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
}
