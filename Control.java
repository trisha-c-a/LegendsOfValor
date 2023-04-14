import java.util.Arrays;

public class Control {
    //This class is mainly focusing on enabling turning user input to actual game logic
    //This class also displays possible input that could be taken from the users
    public void DisplayControls(){
        System.out.println("Here are all the options available: ");
        System.out.println("w - move up");
        System.out.println("a - move left");
        System.out.println("s - move down");
        System.out.println("d - move right");
        System.out.println("u - change equipment");
        System.out.println("p - use a potion");
        System.out.println("x - attack");
        System.out.println("c - cast a spell");
        System.out.println("t - teleport");
        System.out.println("r - recall");
        System.out.println("i - show hero statistics");
        System.out.println("e - show inventory");
        System.out.println("m - enter market");
        System.out.println("z - display world map");
        System.out.println("q - quit game");
    }

    public boolean inputControl(World world, Hero hero, MonsterPack monsterPack, String key, HeroGroup heroGroup){
        int currentX = hero.getCurrPos().get(0);
        int currentY = hero.getCurrPos().get(1);
        switch (key) {
            case "w":
                if(hero.heroValidMove(monsterPack)){
                    currentX -= 1;
                    return world.traverseBoard(hero, currentX, currentY, key);
                }else{
                    return true;
                }
            case "a":
                if(hero.heroValidMove(monsterPack)){
                    currentY -= 1;
                    return world.traverseBoard(hero, currentX, currentY, key);
                }else{
                    return true;
                }
            case "s":
                if(hero.heroValidMove(monsterPack)){
                    currentX += 1;
                    return world.traverseBoard(hero, currentX, currentY, key);
                }else{
                    return true;
                }
            case "d":
                if(hero.heroValidMove(monsterPack)){
                    currentY += 1;
                    return world.traverseBoard(hero, currentX, currentY, key);
                }else{
                    return true;
                }
            case "u":
                return hero.changeEquipment();
            case "p":
                return hero.consumePotion();
            case "x":
                hero.attack(hero.monsterInRange(monsterPack),hero.getEquipment());
                world.removeMonster(monsterPack.removeMonster(heroGroup));
                return true;
            case "c":
                hero.castSpell(monsterPack);
                world.removeMonster(monsterPack.removeMonster(heroGroup));
                return true;
            case "t":
                return hero.teleport(world);
            case "r":
                return hero.recall();
            case "i":
                hero.stats();
                return true;
            case "e":
                return hero.checkInventory();
            case "m":
                return world.traverseBoard(hero,currentX, currentY, key);
            case "z":
                world.displayBoard(heroGroup, monsterPack);
                return true;
            case "q":
                return false;
            default:
                System.out.println("Incorrect move entered.");
                return true;
        }
    }
}
