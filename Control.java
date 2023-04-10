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

    public boolean inputControl(World world, Hero hero, String key){
        int currentX = hero.getCurrPos().get(0);
        int currentY = hero.getCurrPos().get(1);
        switch (key) {
            case "w":
                currentX -= 1;
                return world.traverseBoard(hero, currentX, currentY, key);
            case "a":
                currentY -= 1;
                return world.traverseBoard(hero, currentX, currentY, key);
            case "s":
                currentX += 1;
                return world.traverseBoard(hero, currentX, currentY, key);
            case "d":
                currentY += 1;
                return world.traverseBoard(hero, currentX, currentY, key);
            case "i":
                hero.stats();
                return true;
            case "m":
                return world.traverseBoard(hero,currentX, currentY, key);
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
