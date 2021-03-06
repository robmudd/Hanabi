import java.util.ArrayList;

public class Player {

    ArrayList<Tile> playerHand;
    //Game currentGame;
    int playerNumber;
    String playerName;

    public Player ( int playerNumber, String playerName){

        //this.currentGame = currentGame;
        this.playerNumber = playerNumber;
        this.playerHand = new ArrayList<Tile>();
        this.playerName = playerName;
    }

    public String toString() {
        StringBuilder tileString = new StringBuilder();

        for (int i = 0; i < this.playerHand.size(); i++) {
            tileString.append(this.playerHand.get(i).toString());
            tileString.append("\n");
        }

        return this.playerName + "'s hand is :\n" + tileString.toString();
    }



}
