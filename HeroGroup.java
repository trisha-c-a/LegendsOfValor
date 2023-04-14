import java.util.*;

import static java.lang.Math.max;

public class HeroGroup implements Group{
    //This class represents the group of heroes created by the heroes
    //This class helps initiate hero instances by taking input from the users
    //It also includes different methods to allow for actions on heroes and display hero statistics
    public int numberOfHeros;
    public List<Integer> boardPos = Arrays.asList(0,0);

    public List<Hero> pack = new ArrayList<>();

    public HeroGroup(){
        this.numberOfHeros = 3;
        Scanner scanner = new Scanner(System.in);
        Reader reader = new Reader();
        Map<String, List<List<String>>> heroes = reader.getHeroDetails();
        Set<String> names_added = new HashSet<>();
        Set<String> lanesOccupied = new HashSet<>();
        for(int i = 1; i <= this.numberOfHeros; i++){

            System.out.printf("Please enter the name of hero %d:", i);
            String name = scanner.nextLine();
            List<String> details = nameExists(heroes, name);

            if(details != null){
                if(names_added.contains(details.get(0))){
                    System.out.println("Duplicate heroes are not allowed!");
                    i -= 1;
                    continue;
                }
                names_added.add(details.get(0));
                String heroLane = laneSelection(lanesOccupied); //Getting lane for hero
                lanesOccupied.add(heroLane);
                List <Integer> position = spawnPosition(heroLane); //Getting nexus/initial position
                Hero hero;
                switch (details.get(7)){                    
                    case "Warriors":
                     hero = new Warrior("H" + String.valueOf(i), details.get(0), details.get(7), heroLane, position, Double.parseDouble(details.get(1)), Long.parseLong(details.get(6)), Double.parseDouble(details.get(2)), Double.parseDouble(details.get(4)), Double.parseDouble(details.get(3)), Double.parseDouble(details.get(5)));
                     break;
                    case "Paladins": 
                    hero = new Paladin("H" + String.valueOf(i), details.get(0), details.get(7), heroLane, position, Double.parseDouble(details.get(1)), Long.parseLong(details.get(6)), Double.parseDouble(details.get(2)), Double.parseDouble(details.get(4)), Double.parseDouble(details.get(3)), Double.parseDouble(details.get(5)));
                    break;
                    case "Sorcerers":
                     hero = new Sorceror("H" + String.valueOf(i), details.get(0), details.get(7), heroLane, position, Double.parseDouble(details.get(1)), Long.parseLong(details.get(6)), Double.parseDouble(details.get(2)), Double.parseDouble(details.get(4)), Double.parseDouble(details.get(3)), Double.parseDouble(details.get(5)));
                     break;
                    default: 
                     hero = null;
                     break;
                }

                this.pack.add(hero);
            }
            else{
                System.out.println("Wrong name entered. Please try again");
                i -= 1;
            }

        }

    }

    public String laneSelection(Set<String> lanesOccupied){
        String lanePicked;

        while(true){
            System.out.println("Lanes are: ");
            System.out.println("Top, Middle and Bottom");
            System.out.println("Please enter which lane you would like to place your hero in: ");
            Scanner scanner = new Scanner(System.in);
            lanePicked = scanner.nextLine();
            if(lanePicked.equals("Top") || lanePicked.equals("Middle") || lanePicked.equals("Bottom")){
                if(!lanesOccupied.contains(lanePicked)){
                    break;
                }
                else{
                    System.out.println("Another hero has occupied this lane. Please enter a different one!");
                }
            }
            else{
                System.out.println("Please enter a valid lane name!");
            }

        }
        return lanePicked;
    }

    public List<Integer> spawnPosition(String lane){
//        List<Integer> temp;
        if(lane.equals("Top")){
            return Arrays.asList(7,0);
        } else if (lane.equals("Middle")) {
            return Arrays.asList(7,3);
        }
        else{
            return Arrays.asList(7,6);
        }
    }

    public int checkNumHeroes(String num){
        Scanner scnr = new Scanner(System.in);
        while(true){            
            switch(num){
                case "1": return 1;
                case "2": return 2;
                case "3": return 3;
                default: {
                    System.out.println("Incorrect entry! Please enter again:");
                    break;
                }
            }
            num = scnr.nextLine();
            
        }
    }

    public int getNumberOfHeros() {
        return this.numberOfHeros;
    }
    @Override
    public int getHighestLevel(){
        int maximum = 0;
        for(Hero hero: this.pack){
            maximum = max(maximum, hero.getLevel());
        }
        return maximum;
    }
    public List<String> nameExists(Map<String, List<List<String>>> heroes, String name) {
        for (String key : heroes.keySet()) {
            for (List<String> hero : heroes.get(key)) {
                if (hero.get(0).equals(name)) {
                    List<String> a = new ArrayList<>();
                    for(String h: hero){
                        a.add(h);
                    }
                    a.add(key);
                    return a;
                }
            }
        }
        return null;
    }

    @Override
    public void stats() {
        System.out.println("                            Hero Statistics");
        System.out.println();
        System.out.println("Name" + "       " + "DisplayName" + "       " +  "HP" + "       " + "MP" + "       "
                + "Strength" + "       " + "Agility"+ "       " + "Dexterity"
                + "       " + "Gold"+ "       " + "Experience" +  "       " + "Level");
        for (Hero hero : pack) {
            if (!hero.getIsFainted()) {
                System.out.println(hero.getName() + "       " + hero.getDisplayName()+ "       " +hero.getHP() + "       " + hero.getMP() + "       "
                        + hero.getStrengthValue() + "       " + hero.getAgilityValue() + "       "
                        + hero.getDexterityValue() + "       " + hero.getGoldAmount()
                        + "       " + hero.getExperiencePoints() + "       " + hero.getLevel());
            }
        }
    }

    @Override
    public String characterExists(String name) {
        boolean exists = false;
        for (Hero hero : pack) {
            if (hero.getName().equals(name) && !hero.getIsFainted()) {
                exists = true;
                return name;
            }
        }
            if(!exists){
                System.out.println("The hero you entered does not exist/ has fainted. The following heros are part of your pack.");
                stats();
                System.out.println("Please enter a different hero name:");
                Scanner n1 = new Scanner(System.in);
                name = n1.nextLine();
                return characterExists(name);
            }
            return null;
        }

    public void removeCharacter() {
        for (int i=0;i<pack.size();i++) {
            pack.get(i).checkHP();
            if (pack.get(i).getIsFainted()) {
                System.out.println(pack.get(i).getDisplayName() + " has fainted!");
                System.out.println(pack.get(i).getDisplayName() + " has respawned at their nexus...");
                pack.get(i).setCurrPos(pack.get(i).getNexusPos());
                pack.get(i).setIsFainted(false);
                pack.get(i).setHP(pack.get(i).getLevel() * 100);
                pack.get(i).setMP(pack.get(i).getOgMP());
                System.out.println(pack.get(i).getDisplayName() + " HP has been reset");
                System.out.println(pack.get(i).getDisplayName() + " MP has been reset");
            }
        }
    }

    @Override
    public long notFaint() {
        long count = pack.size();
        for (Hero hero : pack) {
            hero.checkHP();
            if (hero.getIsFainted()) {
                count -= 1;
            }
        }
        return count;
    }

    public Hero retrieveCharacter(String name) {
        name = characterExists(name);
        for (Hero hero : pack) {
            if (hero.getName().equals(name)) {
                return hero;
            }
        }
        return null;
    }

    public void updateHerosPostBattle(int monsterLevel){
        for (Hero hero : pack) {
            hero.roundUpdate(monsterLevel);
            if (hero instanceof Warrior) {
                ((Warrior) hero).updateSkill();
            } else if (hero instanceof Paladin) {
                ((Paladin) hero).updateSkill();
            } else if (hero instanceof Sorceror) {
                ((Sorceror) hero).updateSkill();
            }
        }
        stats();
    }

    public List<Integer> getBoardPos(){
        return this.boardPos;
    }

    public List<Hero> getPack(){
        return this.pack;
    }

    public void setBoardPos(int a, int b){
        this.boardPos.set(0,a);
        this.boardPos.set(1,b);
    }
}
