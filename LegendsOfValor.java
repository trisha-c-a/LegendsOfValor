import java.util.Arrays;
import java.util.Scanner;

public class LegendsOfValor implements GameDetails{

    // This class is the class of the game Legends and Valor
    // It contains the rules and the main game play method to initiate the game
    // It also implements the check for winning conditions as required by the interface it implements

    public LegendsOfValor(){
        System.out.println("Welcome to Legends of Valor!");
        this.rules();
        this.playGame();
    }
    @Override
    public void rules() {
        System.out.println("                            RULES");
        System.out.println("The game is played in a 8x8 board with heroes and monsters.\n" +
                "You get to pick 3 heroes to fight your battels.\n" +
                "You also get to pick which lanes to put them in for their battels.\n" +
                "Your heroes spawn at their nexus where they can buy items.This is the only place in the world where they can purchase items so equip them wisely!\n" +
                "Your heroes will partake in their own journeys across bushes, caves, koulous and plain cells.\n" +
                "Stepping in and out of bushes, caves and koulous will increase/decrease your heroes attributes.\n" +
                "Bushes are marked as \"B\". Caves are marked as \"C\". Koulous are marked as \"K\". Plain spaces are marked as \"P\". Inaccessible areas are marked as \"I\". Your hero's position is determined by a \"H\" followed by a numbering.\n" +
                "Your goal is to prevent the monsters from reaching the heroes nexus. \n" +
                "Additionally, atleast 1 of your heroes need to reach the monsters nexus to win the game!\n" +
                "You can attack/cast a spell on a monster if they are within range.\n" +
                "You can also teleport to a different lane usng the teleport button.\n" +
                " Moreover, you can return back to your hero's nexus using the recall button.\n" +
                "The following controls are available:\n" +
                "1 - \"w\": Move up\n" +
                "2 - \"a\": Move left\n" +
                "3 - \"s\": Move down\n" +
                "4 - \"d\": Move right\n" +
                "5 - \"u\": Change equipment\n" +
                "6 - \"p\": Use a potion\n" +
                "7 - \"x\": Attack a monster if in range\n" +
                "8 - \"c\": Cast a spell\n" +
                "9 - \"t\": Teleport\n" +
                "10 - \"r\": Recall to your heroes nexus\n" +
                "11 - \"i\": Show your hero's statistics\n" +
                "12 - \"e\": Display your hero's inventory\n" +
                "13 - \"m\": Enter a market\n" +
                "14 - \"z\": Display the map\n" +
                "15 - \"q\": Quit the game\n" +
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

                heroGroup.updateHerosAttributes(monsterPack.getHighestLevel());

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
