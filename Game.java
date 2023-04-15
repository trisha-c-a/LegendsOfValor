import java.util.Scanner;

public class Game {

    //This is the super class of all games
    //It provides the user the ability to choose the game they want to play

    public Game(){
        System.out.println("Welcome to the game world!");
        System.out.println("The following games exist:");
        System.out.println("(1) Legends of Valor");

        while(true){
            System.out.println("Please enter the number of the game you would like to play or enter 'q' to quit");
            Scanner option = new Scanner(System.in);
            String choice = option.nextLine();
            if(choice.equals("1")){
                new LegendsOfValor();
                break;
            }
            else if(choice.equals("q")){
                break;
            }
            else{
                System.out.println("Incorrect entry!");
            }
        }
    }
}
