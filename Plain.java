public class Plain extends Cell{
    // The three printing methods are used to display the cell on the map

    public Plain(String name) {
        super(name);
    }

    public void printFirst(){System.out.print("P - P - P");}
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
    public void printThird(){System.out.print("P - P - P");}

}
