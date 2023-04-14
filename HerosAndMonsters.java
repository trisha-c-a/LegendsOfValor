import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HerosAndMonsters implements GameDetails{
    // This class is the class of the game Legends and Valor
    // It contains the rules and the main game play method to initiate the game
    // It also implements the check for winning conditions as required by the interface it implements

    public HerosAndMonsters(){
        System.out.println("Welcome to Legends of Valor!");
        this.rules();
        this.playGame();
    }
    @Override
    public void rules() {
        System.out.println("                            RULES");
        System.out.println("The game is played in a square world with heroes and monsters.\n" +
                "You will pick a world size and heroes for the game.\n" +
                "Your heroes will travel in a pack across the world filled with markets, common spaces and inaccessible areas.\n" +
                "Markets are marked as \"M\". Inaccessible areas are marked as \"I\". Points in the world with no marking represent common spaces. Your hero group position is determined by a \"H\".\n" +
                "The following can occur as you move across the world:\n" +
                "1 - If you enter a common space, you might have to take part in a battle. The battle is against a random pack of monsters that you will have to defeat using your heroes to end the battle. If all your heroes faint, you lose the game. If you defeat all the monsters, you win the battle and earn incentives.\n" +
                "2 - If you enter a market, you can buy and sell items using your hero's gold. These items could aid your heroes during a battle. You can only visit a market one hero at a time. Additionally, each hero has its own inventory and cannot share items. Heroes also have their own gold and cannot share amongst themselves.\n" +
                "Once your hero with the highest level levels-up, a new world is generated!\n" +
                "The following controls are available:\n" +
                "1 - \"w\": Move up\n" +
                "2 - \"a\": Move left\n" +
                "3 - \"s\": Move down\n" +
                "4 - \"d\": Move right\n" +
                "5 - \"i\": Access hero party information outside a battle. Access hero and monster pack information during battle\n" +
                "6 - \"m\": Enter a market if on market cell\n" +
                "7 - \"e\": Check hero inventory and consume a potion\n" +
                "8 - \"z\": Display world map\n" +
                "\n" +
                "Enjoy the game!");

    }

    @Override
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        HeroGroup heroGroup = new HeroGroup(); //Creates group of 3 heroes
        MonsterPack monsterPack = new MonsterPack(heroGroup.getHighestLevel(), 1); //Generate 3 monsters randomly
        World world = new World();
        world.createLaneCharacters(heroGroup,monsterPack);
        Control control = new Control();
        int numRounds = 8;
        Boolean res;
        String key;
        game:
        while (true) {
            for (int round = 0; round < numRounds; round++) { //Runs for 8 rounds before re-generating monsters
                for (int i = 0; i < heroGroup.getNumberOfHeros(); i++) { //Allows each hero to pick a task
                    world.displayBoard(heroGroup, monsterPack);
                    control.DisplayControls();
                    System.out.println("Please enter a key " + heroGroup.getPack().get(i).getDisplayName());
                    key = scanner.nextLine();
                    res = control.inputControl(world, heroGroup.getPack().get(i), monsterPack, key, heroGroup);
                    while(key.equals("m") || key.equals("e") || key.equals("i")){
                        world.displayBoard(heroGroup, monsterPack);
                        control.DisplayControls();
                        System.out.println("Please enter a key " + heroGroup.getPack().get(i).getDisplayName());
                        key = scanner.nextLine();
                        res = control.inputControl(world, heroGroup.getPack().get(i), monsterPack, key, heroGroup);
                    }

                    if (!res || checkWinner(heroGroup, monsterPack, world)) { break game;}
                }


                for (int i = 0;i<monsterPack.getNumOfMonster();i++){            //Monster actions
                    if(monsterPack.getPack().get(i).heroInRange(heroGroup)!=null){
                        monsterPack.getPack().get(i).attackHero(monsterPack.getPack().get(i).heroInRange(heroGroup));
                        heroGroup.removeCharacter();
                    }
                    else{
                        monsterPack.getPack().get(i).setCurrPos(Arrays.asList(monsterPack.getPack().get(i).getCurrPos().get(0) +1,
                                                                monsterPack.getPack().get(i).getCurrPos().get(1)));
                        if(checkWinner(heroGroup, monsterPack, world)) break game;
                    }
                }

                heroGroup.updateHerosPostBattle(monsterPack.getHighestLevel());

            }
            MonsterPack temp = new MonsterPack(heroGroup.getHighestLevel(), monsterPack.getMonsterDisplayNumber()); //Generate 3 more monsters randomly
            world.createLaneCharacters(null, temp);
            monsterPack.getPack().addAll(temp.getPack());
            monsterPack.setHighestLevel(monsterPack.getHighestLevel());
        }
    }

    @Override
    public boolean checkWinner(HeroGroup heroGroup, MonsterPack monsterPack, World world) {
        for(Hero h: heroGroup.getPack()){
            if(h.getCurrPos().get(0) == world.getMonsterNexus()){
                System.out.println("A hero has reached the monster nexus! You have won the game!");
                return true;
            }
        }
        for(Monster m: monsterPack.getPack()){
            if(m.getCurrPos().get(0) == world.getHeroNexus()){
                System.out.println("The monsters have reached the nexus! You have lost the game....");
                return true;
            }
        }
        return false;
    }
}
