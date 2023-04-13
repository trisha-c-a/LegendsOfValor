import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hero extends Character{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_Blue = "\u001B[34m";
    public static final String ANSI_Green = "\u001B[32m";
    public static final String ANSI_Red = "\u001B[31m";
    public double MP;
    public long experiencePoints;
    public double strengthValue;
    public double dexterityValue;
    public double agilityValue;
    public double goldAmount;
    public Item equipment;
    public Inventory bag = new Inventory();

    //Constructor for a default hero
    public Hero(){
        super();
        this.MP = 1000;
        this.experiencePoints = 0;
        this.strengthValue = 400;
        this.dexterityValue = 500;
        this.agilityValue = 450;
        this.goldAmount = 2500;
    }

    //Constructor for a default character but user defined hero attributes
    public Hero(double mp, long exp, double sVal, double dexVal, double agVal,double gAmt){
        super();
        this.MP = mp;
        this.experiencePoints = exp;
        this.strengthValue = sVal;
        this.dexterityValue = dexVal;
        this.agilityValue = agVal;
        this.goldAmount = gAmt;
    }

    //Constructor for user defined hero attributes
    public Hero(String nme, String t, String lane, List<Integer> position, double mp, long exp, double sVal, double dexVal, double agVal, double gAmt){
        super(nme,1,100,t,lane,position);
        this.MP = mp;
        this.experiencePoints = exp;
        this.strengthValue = sVal;
        this.dexterityValue = dexVal;
        this.agilityValue = agVal;
        this.goldAmount = gAmt;
    }

    public void checkExperience(){
        if(this.experiencePoints>=super.getLevel()*10) {
            this.levelUp();
        }
    }

    public void levelUp(){
        super.setLevel(super.getLevel()+1); //Increase level by 1
        //Increase below based on example formulae given in assignment pdf
        super.setHP(super.getLevel()*100);
        this.MP = this.MP*1.1;
        this.agilityValue = this.agilityValue*1.05;
        this.dexterityValue = this.dexterityValue*1.05;
        this.strengthValue = this.strengthValue*1.05;
    }

    public void roundUpdate(int monsterLevel){
        super.setHP(super.getHP()*1.1);
        this.MP = this.MP*1.1;
        if(!super.getIsFainted()){
            this.setGoldAmount(this.getGoldAmount() + ((double)monsterLevel*100));
            this.setExperiencePoints(this.getExperiencePoints()+ (long)monsterLevel*2);
            this.checkExperience();
        }
        else{
            super.setCurrPos(super.getNexusPos());
            super.setIsFainted(false);
        }
    }

    public Item chooseItem() {
        if(this.bag.getInventory().size()==0){
            System.out.println("You have nothing to fight monsters. Equipping you with a sword for this battle round");
            Weapon w = new Weapon("Sword",500,1,800,1);
            return w;
        }
        this.getBag().viewInventory();

        System.out.println("Enter the type of item you would like to use:");
        Scanner type = new Scanner(System.in);
        String itemType= type.nextLine();

        System.out.println("Enter the type of item you would like to use:");
        Scanner name = new Scanner(System.in);
        String itemName= name.nextLine();

        if(this.getBag().retrieveItem(itemType,itemName).getName().equals("IceSpell") ||
                this.getBag().retrieveItem(itemType,itemName).getName().equals("FireSpell")||
                this.getBag().retrieveItem(itemType,itemName).getName().equals("LightSpell")){
            if(((Spell)this.getBag().retrieveItem(itemType,itemName)).getMP()>this.MP){
                System.out.println("You do not have enough MP to use this spell. Please use a different item");
                return chooseItem();
            }
        }
        return this.getBag().retrieveItem(itemType,itemName);
    }

    public void useItem(Item product, Monster m) {
        Random random = new Random();
        double chance = 0.01;
        if (product.getType().equals("Weapon")) {
            if(random.monsterDodge(m.dodgeAbility,chance)){
                System.out.println(m.getName() + "has dodged " + this.getName() + " attack!");
            }
            else{
                ((Weapon) product).applyWeapon(m, this.strengthValue);
                System.out.println(this.getName() + " has attacked " + m.getName() + " for " + ((Weapon) product).getDamageValue() + " damage!");
            }

        } else if (product.getType().equals("Ice Spell")) {
            if(random.monsterDodge(m.dodgeAbility,chance)){
                System.out.println(m.getName() + "has dodged " + this.getName() + " attack!");
            }
            else{
                ((IceSpell) product).applyIceSpell(m,this.dexterityValue);
                System.out.println(this.getName() + " has attacked " + m.getName() + " for " + ((IceSpell) product).getDamage() + " damage!");
            }
            this.getBag().removeItem(product.getType(), product.getName());
        } else if (product.getType().equals("Light Spell")) {
            if(random.monsterDodge(m.dodgeAbility,chance)){
                System.out.println(m.getName() + "has dodged " + this.getName() + " attack!");
            }
            else{
                ((LightSpell) product).applyLightSpell(m,this.dexterityValue);
                System.out.println(this.getName() + " has attacked " + m.getName() + " for " + ((LightSpell) product).getDamage() + " damage!");
            }
            this.getBag().removeItem(product.getType(), product.getName());
        } else if (product.getType().equals("Fire Spell")) {
            if(random.monsterDodge(m.dodgeAbility,chance)){
                System.out.println(m.getName() + "has dodged " + this.getName() + " attack!");
            }
            else{
                ((FireSpell) product).applyFireSpell(m,this.dexterityValue);
                System.out.println(this.getName() + " has attacked " + m.getName() + " for " + ((FireSpell) product).getDamage() + " damage!");
            }
            this.getBag().removeItem(product.getType(), product.getName());
        } else if (product.getType().equals("Armor")) {
            this.setHP(this.getHP()+((Armor)product).getDamageReduction());
            System.out.println(this.getName() + " has protection from " + m.getName() + " with a damage reduction of " + ((Armor)product).getDamageReduction());
        }
    }

    public Boolean changeEquipment(){
        if(this.bag.isEmpty()){
            System.out.println("You have nothing to pick from your inventory!");
            return true;
        }
        if(!this.bag.isTypePresent("Weapon") || !this.bag.isTypePresent("Armor")){
            System.out.println("You do not have a weapon or armor to pick!");
            return true;
        }

        Scanner type = new Scanner(System.in);
        String itemType = "";
        System.out.println("Please enter if you'd like to pick a Weapon or Armor: ");
        while(true){
            if(type.hasNextLine()){
                itemType = type.nextLine();
            }
            if(!itemType.equals("Weapon") || !itemType.equals("Armor")){
                System.out.println("Incorrect type! Please enter 'Weapon' or 'Armor':");
            }
            else{
                break;
            }
        }

        String itemName ="";
        this.bag.viewInventory();
        System.out.println("Please enter the name of the item: ");
        this.equipment = this.bag.retrieveItem(itemType,itemName);

        return true;

    };
    public Boolean consumePotion(){
        if(this.bag.isEmpty()){
            System.out.println("You have nothing to pick from your inventory!");
            return true;
        }
        if(!this.bag.isTypePresent("Potion")){
            System.out.println("You do not have a potion to pick!");
            return true;
        }

        Scanner type = new Scanner(System.in);

        String itemName ="";
        this.bag.viewInventory();
        System.out.println("Please enter the name of the item: ");
        Item product = this.bag.retrieveItem("Potion",itemName);

        boolean appliedAttribute = false;
        while(!appliedAttribute){
            System.out.println("Enter attribute that you would like to increase:");
            System.out.println(((Potion)product).displayAttributeAffected());
            String p = type.nextLine();
            switch (p) {
                case "Health":
                    this.setHP(this.getHP() + ((Potion) product).getAttributeIncrease());
                    this.getBag().removeItem(product.getType(), product.getName());
                    System.out.println(this.getName() + " has increased their HP with " + ((Potion) product).getName() + " potion! ");
                    appliedAttribute = true;
                    break;
                case "Strength":
                    this.setStrengthValue(this.getStrengthValue() + ((Potion) product).getAttributeIncrease());
                    this.getBag().removeItem(product.getType(), product.getName());
                    System.out.println(this.getName() + " has increased their strength with " + ((Potion) product).getName() + " potion! ");
                    appliedAttribute = true;
                    break;
                case "Mana":
                    this.setMP(this.getMP() + ((Potion) product).getAttributeIncrease());
                    this.getBag().removeItem(product.getType(), product.getName());
                    System.out.println(this.getName() + " has increased their MP with " + ((Potion) product).getName() + " potion! ");
                    appliedAttribute = true;
                    break;
                case "Agility":
                    this.setAgilityValue(this.getAgilityValue() + ((Potion) product).getAttributeIncrease());
                    this.getBag().removeItem(product.getType(), product.getName());
                    System.out.println(this.getName() + " has increased their agility with " + ((Potion) product).getName() + " potion! ");
                    appliedAttribute = true;
                    break;
                case "Dexterity":
                    this.setDexterityValue(this.getDexterityValue() + ((Potion) product).getAttributeIncrease());
                    this.getBag().removeItem(product.getType(), product.getName());
                    System.out.println(this.getName() + " has increased their dexterity with " + ((Potion) product).getName() + " potion! ");
                    appliedAttribute = true;
                    break;
                default:
                    System.out.println("This attribute does not exist. Please enter a different attribute");
                    appliedAttribute = true;
                    break;
            }

        }
        return true;
    }
    public Boolean castSpell(MonsterPack pack){
        if(this.bag.isEmpty()){
            System.out.println("You have nothing to pick from your inventory!");
            return true;
        }
        if(!this.bag.isTypePresent("Ice Spell") || !this.bag.isTypePresent("Fire Spell") || !this.bag.isTypePresent("Light Spell")){
            System.out.println("You do not have spells to pick!");
            return true;
        }

        Scanner type = new Scanner(System.in);
        String itemType = "";
        System.out.println("Please enter the type of spell you would like to pick (Ice Spell/ Fire Spell/ Light Spell): ");
        while(true){
            if(type.hasNextLine()){
                itemType = type.nextLine();
            }
            if(!itemType.equals("Ice Spell") || !itemType.equals("Fire Spell")|| !itemType.equals("Light Spell")){
                System.out.println("Incorrect type! Please enter 'Ice Spell', 'Fire Spell' or 'Light Spell':");
            }
            else{
                break;
            }
        }

        String itemName ="";
        this.bag.viewInventory();
        System.out.println("Please enter the name of the item: ");
        Item magic = this.bag.retrieveItem(itemType,itemName);

        Monster m = this.monsterInRange(pack);
        if(m==null){
            System.out.println("No monster in range to cast spell!");
            return true;
        }
        attack(m,magic);
        return true;
    };

    public Monster chooseMonster(MonsterPack monsters) {
        monsters.stats();
        System.out.println("Choose a monster to fight against your hero from the above list.");
        Scanner monster = new Scanner(System.in);
        String choice = monster.nextLine();
        return monsters.retrieveCharacter(choice);
    }

    public boolean teleport(World map){
        System.out.println("These are the lanes you can teleport to: ");
        for(Map.Entry<String, List<Character>> set:map.getLaneAndCharacters().entrySet()) {
            if(!this.lane.equals(set.getKey())){
                System.out.println(set.getKey());
            }
        }

        String lane = "";
        while(true) {
            System.out.println("Enter the name of the lane you would like to teleport to: ");
            Scanner choice = new Scanner(System.in);
            lane = choice.nextLine();
            if(map.getLaneAndCharacters().containsKey(lane)){
                if(!this.lane.equals(lane)){
                    break;
                }
                else{
                    System.out.println("You cannot teleport to your own lane! Please try again.");
                }
            }
            else{
                System.out.println("This lane does not exist! Please try again.");
            }
        }

        int row;
        while(true){
            System.out.println("Enter the row you would like to teleport to (Number between 1-8): ");
            try{
                Scanner choice = new Scanner(System.in);
                String option = choice.nextLine();
                row = Integer.parseInt(option);
                if(row<9 && row>1) {
                    row = row-1;
                    if (row > map.getLaneAndCharacters().get(lane).get(0).getCurrPos().get(0)) {
                        if (row >= map.getLaneAndCharacters().get(lane).get(1).getCurrPos().get(0)) {
                            break;
                        } else {
                            System.out.println("You cannot teleport to a row behind the monster!");
                        }
                    } else {
                        System.out.println("You cannot teleport to a row ahead of the lane's assigned hero!");
                    }
                }
                else{
                    System.out.println("You are attempting to teleport out of the bounds of the map!");
                }
            }catch (NumberFormatException ex) {
                System.out.println("Please enter only integers!");
            }
        }

        int column;
        if(lane.equals("Top")){
            if(map.getLaneAndCharacters().get(lane).get(0).getCurrPos().get(1)==0){
                column = 1;
            }
            else{
                column = 0;
            }
        }
        else if(lane.equals("Middle")){
            if(map.getLaneAndCharacters().get(lane).get(0).getCurrPos().get(1)==3){
                column = 4;
            }
            else{
                column = 3;
            }
        }
        else{
            if(map.getLaneAndCharacters().get(lane).get(0).getCurrPos().get(1)==6){
                column = 7;
            }
            else{
                column = 6;
            }
        }

        this.lane = lane;
        super.setCurrPos(Arrays.asList(row,column));

        return true;

    }

    public boolean recall(){
        super.setCurrPos(super.getNexusPos());
        return true;
    }

    public Boolean attack(Monster monster,Item tool) {
        if(monster==null){
            System.out.println("No monsters in range to attack!");
            return false;
        }
        this.useItem(tool,monster);
        return true;
    }

    public Monster monsterInRange(MonsterPack monsterPack){
        for(int i = 0 ; i < monsterPack.getNumOfMonster(); i++){
            if(this.getCurrPos().get(0).equals(monsterPack.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(monsterPack.getPack().get(i).getCurrPos().get(1))){
                return monsterPack.getPack().get(i);
            }else if(this.getCurrPos().get(0).equals(monsterPack.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(monsterPack.getPack().get(i).getCurrPos().get(1)-1)){
                return monsterPack.getPack().get(i);
            }else if(this.getCurrPos().get(0).equals(monsterPack.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(monsterPack.getPack().get(i).getCurrPos().get(1)+1)){
                return monsterPack.getPack().get(i);
            }else if(this.getCurrPos().get(0).equals(monsterPack.getPack().get(i).getCurrPos().get(0) + 1) && this.getCurrPos().get(1).equals(monsterPack.getPack().get(i).getCurrPos().get(1)+1)){
                return monsterPack.getPack().get(i);
            }else if(this.getCurrPos().get(0).equals(monsterPack.getPack().get(i).getCurrPos().get(0) + 1) && this.getCurrPos().get(1).equals(monsterPack.getPack().get(i).getCurrPos().get(1)-1)){
                return monsterPack.getPack().get(i);
            }
        }
        return null;
    }

    public boolean heroValidMove(MonsterPack monsterPack){
        for(int i = 0 ; i < monsterPack.getNumOfMonster(); i++){
            if(this.getCurrPos().get(0).equals(monsterPack.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(monsterPack.getPack().get(i).getCurrPos().get(1))){
                return false;
            }else if(this.getCurrPos().get(0).equals(monsterPack.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(monsterPack.getPack().get(i).getCurrPos().get(1)-1)){
                return false;
            }else if(this.getCurrPos().get(0).equals(monsterPack.getPack().get(i).getCurrPos().get(0)) && this.getCurrPos().get(1).equals(monsterPack.getPack().get(i).getCurrPos().get(1)+1)){
                return false;
            }
        }
        return true;
    }



    public boolean checkInventory(){
        this.getBag().viewInventory();
        return true;
    }

    public void stats() {
        System.out.println("                            Hero Statistics");
        System.out.println();
        System.out.println("Name" + "       " + "HP" + "       " + "MP" + "       "
                + "Strength" + "       " + "Agility"+ "       " + "Dexterity"
                + "       " + "Gold"+ "       " + "Experience" +  "       " + "Level");
            if (!this.getIsFainted()) {
                System.out.println(this.getName() + "       " + ANSI_Red + this.getHP() + ANSI_RESET + "       " + ANSI_Blue + this.getMP() + ANSI_RESET + "       "
                        + this.getStrengthValue() + "       " + this.getAgilityValue() + "       "
                        + this.getDexterityValue() + "       " + ANSI_YELLOW + this.getGoldAmount() + ANSI_RESET
                        + "       " + ANSI_Green + this.getExperiencePoints() + ANSI_RESET + "       " + this.getLevel());
            }
    }



                                    //GETTERS AND SETTERS
    public double getMP(){
        return this.MP;
    }

    public long getExperiencePoints(){
        return this.experiencePoints;
    }

    public double getStrengthValue(){
        return this.strengthValue;
    }

    public double getDexterityValue(){
        return this.agilityValue;
    }

    public double getAgilityValue(){
        return this.agilityValue;
    }

    public double getGoldAmount(){
        return this.goldAmount;
    }

    public Inventory getBag(){
        return this.bag;
    }

    public Item getEquipment(){
        return this.equipment;
    }
    public void setMP(double mp){
        this.MP = mp;
    }

    public void setStrengthValue(double sVal){
        this.strengthValue = sVal;
    }

    public void setDexterityValue(double dVal){
        this.dexterityValue = dVal;
    }

    public void setAgilityValue(double aVal){
        this.agilityValue = aVal;
    }

    public void setGoldAmount(double g){
        this.goldAmount = g;
    }

    public void setExperiencePoints(long ex){
        this.experiencePoints = ex;
    }

    public void setEquipment(Item piece){
        this.equipment = piece;
    }
}
