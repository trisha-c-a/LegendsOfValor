import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {

    //This class handles the reading of all text files and display the information

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_Blue = "\u001B[34m";
    private static final String ANSI_Green = "\u001B[32m";
    private static final String ANSI_Red = "\u001B[31m";

    public void readFile(List<List<String>> all, String path){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");
                if(words.length > 1){
                    all.add(Arrays.asList(words));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<List<String>>> getHeroDetails(){

        Map<String, List<List<String>>> final_heroes = new HashMap<>();
        List<List<String>> heroes1 = new ArrayList<>();
        List<List<String>> heroes2 = new ArrayList<>();
        List<List<String>> heroes3 = new ArrayList<>();

        readFile(heroes1, "Paladins.txt");
        final_heroes.put("Paladins", heroes1);

        readFile(heroes2, "Warriors.txt");
        final_heroes.put("Warriors", heroes2);

        readFile(heroes3, "Sorcerers.txt");
        final_heroes.put("Sorcerers", heroes3);

        System.out.println("Here are all the heroes available to you ->");

        for (String key : final_heroes.keySet()) {
            System.out.println(key + "->");
            for (List<String> hero : final_heroes.get(key)) {
                System.out.println("Name: " + hero.get(0) + ANSI_Blue + " Mana: " + hero.get(1) + ANSI_RESET + ANSI_Red + " Strength: " + hero.get(2) + " Agility: " + hero.get(3) + " Dexterity: " + hero.get(4) + ANSI_RESET + ANSI_YELLOW + " Starting_Money: " + hero.get(5) + ANSI_RESET + ANSI_Green + " Starting_Experience: " + hero.get(6) + ANSI_RESET);
            }
        }


        return final_heroes;

    }

    public List<List<String>> getMonsterDetails(){
        Map<String, List<List<String>>> final_monsters = new HashMap<>();
        List<List<String>> monsters = new ArrayList<>();
        List<List<String>> monsters1 = new ArrayList<>();
        List<List<String>> monsters2 = new ArrayList<>();
        List<List<String>> monsters3 = new ArrayList<>();

        readFile(monsters1, "Dragons.txt");
        final_monsters.put("Dragons", monsters1);

        readFile(monsters2, "Exoskeletons.txt");
        final_monsters.put("Exoskeletons", monsters2);

        readFile(monsters3, "Spirits.txt");
        final_monsters.put("Spirits", monsters3);

        for (String key : final_monsters.keySet()) {
            for (List<String> monster : final_monsters.get(key)) {
                List<String> a = new ArrayList<>();
                for(String m: monster){
                    a.add(m);
                }
                a.add(key);
                monsters.add(a);
            }
        }

        return monsters;

    }

    public List<List<List<String>>> getMarketDetails(){
        List<List<List<String>>> market = new ArrayList<>();

        List<List<String>> armory = new ArrayList<>();
        readFile(armory, "Armory.txt");
        market.add(armory);

        List<List<String>> potion = new ArrayList<>();
        readFile(potion, "Potions.txt");
        market.add(potion);

        List<List<String>> fireSpell = new ArrayList<>();
        readFile(fireSpell, "FireSpells.txt");
        market.add(fireSpell);

        List<List<String>> iceSpell = new ArrayList<>();
        readFile(iceSpell, "IceSpells.txt");
        market.add(iceSpell);

        List<List<String>> lightSpell = new ArrayList<>();
        readFile(lightSpell, "LightningSpells.txt");
        market.add(lightSpell);

        List<List<String>> weapon = new ArrayList<>();
        readFile(weapon, "Weaponry.txt");
        market.add(weapon);

        return market;

    }

}
