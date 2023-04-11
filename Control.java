public class Control {
    public void displayControls(){
        System.out.println("Here are all the options available: ");
        System.out.println("w - move up");
        System.out.println("a - move left");
        System.out.println("s - move down");
        System.out.println("d - move right");
        System.out.println("i - show information");
        System.out.println("m - enter market");
        System.out.println("e - show inventory");
        System.out.println("z - display world map");
        System.out.println("r - to go back to the nexus");
        System.out.println("t - teleport to a lane");
        System.out.println("q - quit game");
    }

    public boolean inputControl(World world, Hero hero, MonsterPack monsterPack, String key){
        int currentX = hero.getCurrPos().get(0);
        int currentY = hero.getCurrPos().get(1);
        switch (key) {
            case "w":
                if(hero.heroValidMove(monsterPack)){
                    currentX -= 1;
//                    Monster monster = hero.monsterInRange(monsterPack);
//                    if(monster != null){
//                        // take user input and call hero.attack(monster)
//                        // if hero is fainted revive and return true
//                    }
                    return world.traverseBoard(hero, currentX, currentY, key);
                }else{
                    return true;
                }
            case "a":
                if(hero.heroValidMove(monsterPack)){
                    currentY -= 1;
                    //                    Monster monster = hero.monsterInRange(monsterPack);
//                    if(monster != null){
//                        // take user input and call hero.attack(monster)
//                        // if hero is fainted revive and return true
//                    }
                    return world.traverseBoard(hero, currentX, currentY, key);
                }else{
                    return true;
                }
            case "s":
                if(hero.heroValidMove(monsterPack)){
                    currentX += 1;
                    //                    Monster monster = hero.monsterInRange(monsterPack);
//                    if(monster != null){
//                        // take user input and call hero.attack(monster)
//                        // if hero is fainted revive and return true
//                    }
                    return world.traverseBoard(hero, currentX, currentY, key);
                }else{
                    return true;
                }
            case "d":
                if(hero.heroValidMove(monsterPack)){
                    currentY += 1;
                    //                    Monster monster = hero.monsterInRange(monsterPack);
//                    if(monster != null){
//                        // take user input and call hero.attack(monster)
//                        // if hero is fainted revive and return true
//                    }
                    return world.traverseBoard(hero, currentX, currentY, key);
                }else{
                    return true;
                }
            case "i":
                hero.stats();
                return true;
            case "m":
                return world.traverseBoard(hero, currentX, currentY, key);
            case "e":
                return hero.checkInventory();
            case "z":
                world.displayBoard();
                return true;
            case "q":
                return false;
            case "r":
                return hero.recall();
            case "t":
                return hero.teleport(world);
            default:
                System.out.println("Incorrect move entered.");
                return true;
        }
    }
}
