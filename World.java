import java.util.*;

public class World {
    public Cell [][] board;
    public int dimension = 8;
    public HashMap<String, List<Character>> laneAndCharacters = new HashMap<>();
    //{laneName:[hero,monster]}

    public World(){
        this.createWorld();
    }

    public int checkMapSize(String size){
        Scanner scnr = new Scanner(System.in);
        while(true){
            try {
                int num = Integer.parseInt(size);
                if(num <= 10 && num >= 3) return num;
                else System.out.println("Please enter a number between 3-10: ");
            } catch (Exception e) {
                System.out.println("Please enter a valid integer: ");
            }
            size = scnr.nextLine();
        }

    }

    public void createWorld(){
        board = new Cell[this.dimension][this.dimension];

        //Adding inaccessible cells
        for(int i=0;i<board.length;i++){
            int j =2;
            while(j<board.length-1){
                board[i][j] = new Inaccessible("X");
                j = j+3;
            }
        }

        List<String> characterType = Arrays.asList("H","M");
        //Adding nexus cells
        int k = 0;
        int cType = 1;
        while(k<this.dimension){
            for(int j=0;j<this.dimension;j++){
                if(board[k][j] instanceof Inaccessible){
                    continue;
                }
                else{
                    board[k][j] = new Nexus("N",characterType.get(cType));
                }
            }
            k = k+7;
            cType-=1;
        }

        Random random = new Random();
        for(int i = 0; i < this.dimension; i++){
            for(int j = 0; j < this.dimension; j++){
                if(board[i][j] instanceof Inaccessible || board[i][j] instanceof Nexus){
                    continue;
                }
                String type = random.cellGeneration();
                switch (type) {
                    case "P":
                        board[i][j] = new Common(type);
                        break;
                    case "B":
                        board[i][j] = new Bush(type);
                        break;
                    case "C":
                        board[i][j] = new Cave(type);
                        break;
                    default:
                        board[i][j] = new Koulou(type);
                }

            }
        }
    }

    public void displayBoard(){
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if(board[i][j].getName().equals("N")) System.out.print("N");
                else if(board[i][j].getName() == "X") System.out.print("X");
                else System.out.print(" ");
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public boolean traverseBoard(Hero hero, int currentX, int currentY, String token){
        if(!(board[currentX][currentY] instanceof Nexus) && token.equals("m")){
            System.out.println("You cannot buy items outside the nexus!");
            return true;
        }
        else if(currentX < 0 || currentX > this.dimension || currentY < 0 || currentY > this.dimension){
            System.out.println("You are trying to exit the world boundary!");
            return true;
        }
        else if(board[currentX][currentY].name == "X"){ System.out.println("Inaccessible zone encountered!"); return true;}
        else if(board[currentX][currentY].name == "N"){
            hero.setCurrPos(Arrays.asList(currentX,currentY));
            if(token.equals("m")){
                ((Nexus)board[currentX][currentY]).getMarket().entrance(hero);
            }
            return true;
        }

        this.updateHeroAttributes(hero);
        hero.setCurrPos(Arrays.asList(currentX,currentY));
        if(board[currentX][currentY].name == "B"){
            ((Bush) board[currentX][currentY]).entry(hero);
        }
        else if(board[currentX][currentY].name == "C"){
            ((Cave) board[currentX][currentY]).entry(hero);
        }
        else if(board[currentX][currentY].name == "K"){
            ((Koulou) board[currentX][currentY]).entry(hero);
        }
        else if(board[currentX][currentY].name == "P") {
        }
        return true;
    }

    public void updateHeroAttributes(Hero h){
        if(board[h.getCurrPos().get(0)][h.getCurrPos().get(1)] instanceof Bush){
            ((Bush)board[h.getCurrPos().get(0)][h.getCurrPos().get(1)]).exit(h);
        } else if (board[h.getCurrPos().get(0)][h.getCurrPos().get(1)] instanceof Cave){
            ((Cave)board[h.getCurrPos().get(0)][h.getCurrPos().get(1)]).exit(h);
        }else if (board[h.getCurrPos().get(0)][h.getCurrPos().get(1)] instanceof Koulou){
            ((Koulou)board[h.getCurrPos().get(0)][h.getCurrPos().get(1)]).exit(h);
        }
    }

    public void createLaneCharacters(HeroGroup group, MonsterPack pack){
        for(int i=0;i<group.getNumberOfHeros();i++){
            this.addCharacter(group.getPack().get(i));
        }

        for(int j=0;j<pack.getNumOfMonster();j++){
            this.addCharacter(group.getPack().get(j));
        }
    }

    public void addCharacter(Character c){
        if(!laneAndCharacters.containsKey(c.getLane())){
            List<Character> temp = new ArrayList<>();
            temp.add(c);
            laneAndCharacters.put(c.getLane(),temp);
        }
        else{
            laneAndCharacters.get(c.getLane()).add(c);
        }
    }

    public void removeMonster(Character c){
        if(c!=null) {
            laneAndCharacters.get(c.getLane()).remove(c);
        }
    }

    public int getDimension(){
        return this.dimension;
    }

    public HashMap<String, List<Character>> getLaneAndCharacters(){
        return this.laneAndCharacters;
    }

    public void setDimension(int dim){
        this.dimension = dim;
    }
}