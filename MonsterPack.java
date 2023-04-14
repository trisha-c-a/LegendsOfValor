import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.max;

public class MonsterPack implements Group{

    public int numOfMonster;
    public int highestLevel;
    public int monsterDisplayNumber = 1;
    public List<Monster> pack = new ArrayList<Monster>();

    public MonsterPack(int level, int dispNum){
        this.monsterDisplayNumber = dispNum;
        List<List<String>> filteredMonsters = new ArrayList<>();
        Reader reader = new Reader();
        this.numOfMonster = 3;
        this.highestLevel = level;
        List<List<String>> monsters = reader.getMonsterDetails();
            for (List<String> monster : monsters)
                if(Integer.parseInt(monster.get(1)) <= level){
                    filteredMonsters.add(monster);
                }
        List<String> lanes = Arrays.asList("Top", "Middle", "Bottom");
        List<List<Integer>> coords = Arrays.asList(Arrays.asList(0,1),Arrays.asList(0,4), Arrays.asList(0,7));
        int i = 0;
        for(int j = this.numOfMonster-1;j>=0;j--){
            int randomNum = ThreadLocalRandom.current().nextInt(0, filteredMonsters.size());
            Monster monster = new Monster("M" + String.valueOf(this.monsterDisplayNumber), filteredMonsters.get(randomNum).get(0),filteredMonsters.get(randomNum).get(5),
                    Integer.parseInt(filteredMonsters.get(randomNum).get(1)), lanes.get(i),
                    coords.get(i), Double.parseDouble(filteredMonsters.get(randomNum).get(2)),
                    Double.parseDouble(filteredMonsters.get(randomNum).get(3)),
                    Double.parseDouble(filteredMonsters.get(randomNum).get(4)));
            this.pack.add(monster);
            filteredMonsters.remove(randomNum);
            i+=1;
            this.monsterDisplayNumber+=1;
        }

    }

    public Monster retrieveCharacter(String name) {
        name = characterExists(name);
        for(int i=0; i<pack.size();i++){
            if(pack.get(i).getName().equals(name)){
                return pack.get(i);
            }
        }
        return null;
    }

    public List<Monster> getPack(){
        return this.pack;
    }
    @Override
    public void stats() {
        System.out.println("                            Monster Statistics");
        System.out.println();
        System.out.println("Name" + "       " + "HP" + "       " + "Level" + "       " + "Damage" + "       " + "Defense"+ "       " + "Dodge Ability");
        for(int i=0; i<pack.size();i++){
            if(!pack.get(i).getIsFainted()) {
                System.out.println(pack.get(i).getName() + "       " + pack.get(i).getHP() + "       "  + pack.get(i).getLevel() + "       "
                        + pack.get(i).getBaseDamage() + "       " + pack.get(i).getDefenseValue() + "       "
                        + pack.get(i).getDodgeAbility());
            }
        }

    }

    @Override
    public String characterExists(String name) {
        boolean exists = false;
            for (int i = 0; i < pack.size(); i++) {
                if (pack.get(i).getName().equals(name)&& !pack.get(i).getIsFainted()) {
                    exists=true;
                    return name;
                }
            }
            if(!exists){
                System.out.println("The monster you entered does not exist. The following monsters are available for battle.");
                stats();
                System.out.println("Please enter a different monster name:");
                Scanner n1 = new Scanner(System.in);
                name = n1.nextLine();
                return characterExists(name);
            }
            return null;

    }

    public Monster removeMonster(HeroGroup group) {
        Monster m = null;
        for(int i=0; i<this.pack.size();i++){
            this.pack.get(i).checkHP();
            if (this.pack.get(i).getIsFainted()) {
                System.out.println(this.pack.get(i).getDisplayName() + " has fainted!");
                m = this.pack.get(i);
                this.dropAttributes(group,m);
                this.pack.remove(this.pack.get(i));
            }
        }
        return m;
    }

    public void dropAttributes(HeroGroup group, Monster m){
        for(int i=0;i<group.getNumberOfHeros();i++){
            group.getPack().get(i).setGoldAmount(500*m.getLevel());
            group.getPack().get(i).setExperiencePoints(2*m.getLevel());
        }
        System.out.println("Heroes gold and experience levels have increased!");
        group.stats();
    }

    @Override
    public long notFaint() {
        long count = pack.size();
        for(int i=0; i<pack.size();i++) {
            pack.get(i).checkHP();
            if (pack.get(i).getIsFainted()) {
                count -= 1;
            }
        }
        return count;
    }

    @Override
    public int getHighestLevel(){
        return this.highestLevel;
    }

    public void setHighestLevel(int level){
        this.highestLevel = level;
    }
    public int getNumOfMonster(){
        return this.pack.size();
    }

    public int getMonsterDisplayNumber(){return this.monsterDisplayNumber;}

}
