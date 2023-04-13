import java.util.Arrays;

public class Control {
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

    public boolean inputControl(World world, Hero hero, MonsterPack monsterPack, String key){
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
                if(hero.attack(hero.monsterInRange(monsterPack),hero.getEquipment())){
                    Monster m = monsterPack.removeMonster();
                    world.removeMonster(m);
                }

                return true;
            case "c":
                return hero.castSpell(monsterPack);
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
                world.displayBoard();
                return true;
            case "q":
                return false;
            default:
                System.out.println("Incorrect move entered.");
                return true;
        }
    }
}
