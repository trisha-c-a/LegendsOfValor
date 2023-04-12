import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HerosAndMonsters implements GameDetails{

    public HerosAndMonsters(){
        System.out.println("Welcome to Legends: Heroes and Monsters!");
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
        World world = new World();
        Control control = new Control();
        int numRounds = 8;
        Boolean continueGame = true;
        Boolean continueRound = true;
        while (continueGame) {
            MonsterPack monsterPack = new MonsterPack(heroGroup.getHighestLevel()); //Generate 3 monsters randomly
            world.createLaneCharacters(heroGroup,monsterPack);
            for (int round = 0; round < numRounds; round++) { //Runs for 8 rounds before re-generating monsters
                world.displayBoard();
                for (int i = 0; i < heroGroup.getNumberOfHeros(); i++) { //Allows each hero to pick a task
                    control.DisplayControls();
                    System.out.println("Please enter a key");
                    String key = scanner.nextLine();
                    Boolean res = control.inputControl(world, heroGroup.getPack().get(i), monsterPack, key);
                    if (res) {
                    } else {
                        continueRound = false;
                        continueGame = false;
                        break;
                    }
                }

                if(!continueRound){
                    break;
                }

                for (int i = 0;i<monsterPack.getNumOfMonster();i++){            //Monster actions
                    Hero h = monsterPack.getPack().get(i).heroInRange(heroGroup);
                    if(h!=null){
                        monsterPack.getPack().get(i).attackHero(h);
                        heroGroup.removeCharacter();
                    }
                    else{
                        monsterPack.getPack().get(i).setCurrPos(Arrays.asList(monsterPack.getPack().get(i).getCurrPos().get(0) +1,
                                                                monsterPack.getPack().get(i).getCurrPos().get(1)));
                    }
                }

                String check = this.checkWinner(world);
                if(check.equals("h")){
                    heroGroup.updateHerosPostBattle(monsterPack.getHighestLevel());
                } else if (check.equals("m")) {
                    continueGame = false;
                    break;
                }
            }
        }
    }

    @Override
    public String checkWinner(World map) {
        for (Map.Entry<String, List<Character>> e1 : map.getLaneAndCharacters().entrySet()){
            //if any hero in a lane is in the same row as the monster nexus, a true is returned
            if(e1.getValue().get(0).getCurrPos().get(0)==e1.getValue().get(1).getNexusPos().get(0)){
                return "h";
            } else if (e1.getValue().get(1).getCurrPos().get(0)==e1.getValue().get(0).getNexusPos().get(0)) {
                return "m";
            }
        }
        return "c";
    }
}
