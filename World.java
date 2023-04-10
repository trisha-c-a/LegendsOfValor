import java.util.*;

public class World {
    public Cell [][] board;
    public int dimension;
    public HashMap<String, List<Character>> laneAndCharacters = new HashMap<>();
    //{laneName:[hero,monster]}

    public World(HeroGroup group){

        this.createWorld();
        this.displayBoard();

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
        board = new Cell[8][8];

        //Adding inaccessible cells
        for(int i=0;i<8;i++){
            int j =2;
            while(j<7){
                board[i][j] = new Inaccessible("X");
                j = j+3;
            }
        }

        //Adding nexus cells
        int k = 0;
        while(k<8){
            for(int j=0;j<8;j++){
                if(board[k][j] instanceof Inaccessible){
                    continue;
                }
                else{
                    board[k][j] = new Nexus("N");
                }
            }
            k = k+7;
        }

        Random random = new Random();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].getName().equals("N")) System.out.print("N");
                else if(board[i][j].getName() == "X") System.out.print("X");
                else System.out.print(" ");
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public boolean traverseBoard(Hero hero, int currentX, int currentY, String token){
        if(currentX < 0 || currentX >= this.dimension || currentY < 0 || currentY >= this.dimension){
            System.out.println("You are trying to exit the world boundary!");
            return true;
        }
        else if(board[currentX][currentY].name == "X"){ System.out.println("Inaccessible zone encountered!"); return true;}
        else if(board[currentX][currentY].name == "M"){
            hero.setCurrPos(Arrays.asList(currentX,currentY));
            return ((Market)board[currentX][currentY]).entrance(hero);
        }
        else if(board[currentX][currentY].name == "C") {
            if (token.equals("m")) {System.out.println("You are not on a market cell!"); return true;}
            else{
                hero.setCurrPos(Arrays.asList(currentX,currentY));
                return ((Common)board[currentX][currentY]).entrance(hero);
            }

        }
        return false;
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