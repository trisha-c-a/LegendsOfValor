public class Nexus extends Cell{

    String hostCharacter;
    Market market;
    public Nexus(String name, String characterType){
        super(name);
        this.hostCharacter = characterType;
        if(this.hostCharacter.equals("H")){
            market = new Market("M");
        }
    }

    public Market getMarket(){
        return this.market;
    }
    public String getHostCharacter(){
        return this.hostCharacter;
    }
}