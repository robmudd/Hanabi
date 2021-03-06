import java.util.ArrayList;

public class Game {
    ArrayList<Tile> drawPile;
    ArrayList<Tile> discardPile;
    Player playerOne;
    Player playerTwo;
    Player currentPlayer; //pointer to the player object whose turn it is! Not it's own object!
    Player inactivePlayer;
    Player[] players;
    ScoreBoard scoreBoard;
    int score;
    int fusesLeft;
    int cluesLeft;
    boolean gameOver;

    public Game () {

        this.drawPile = initDrawPile();
        this.playerOne = new Player (1, "Robert");
        this.playerTwo = new Player (2, "Becky");
        this.players = new Player[2];
        this.players[0] = playerOne;
        this.players[1] = playerTwo;
        playersDrawInitialHand();
        this.cluesLeft = 10;
        this.fusesLeft = 3;
        this.scoreBoard = new ScoreBoard();
        this.currentPlayer = players[0];
        this.inactivePlayer = players[1];
        this.discardPile = new ArrayList<>();
        this.gameOver = false;
    }

    public ArrayList<Tile> initDrawPile() {
        ArrayList<Tile> al = new ArrayList<>();
        for (Color color : Color.values()) {
            al.add(new Tile(color, 1));
            for (int i = 1; i < 5; i++) {
                al.add(new Tile(color, i));
                al.add(new Tile(color, i));
            }
            al.add(new Tile(color, 5));
        }
        return al;
    }

    private void playersDrawInitialHand() {
        for (Player player : this.players) {
            for (int i = 0; i < 5; i++) {
                playerDrawsTile(player);
            }
        }
    }

    private void playerDrawsTile(Player player) {
        int index = (int) (Math.random() * this.drawPile.size());
        Color color = this.drawPile.get(index).tileColor;
        int value = this.drawPile.get(index).tileValue;
        player.playerHand.add(new Tile(color, value));
        this.drawPile.remove(index);
    }

    public String toString() {
        return playerOne.toString() + "\n" + playerTwo.toString() + "\n" + "Total score = " + this.score + "\n" +
                "Fuses Left = " + this.fusesLeft + "\n" + "Clues Left = " + this.cluesLeft;
    }

    public void scoreTile(Tile tile) {
        if (scoreBoard.addToScoreBoard(tile)) {
            currentPlayer.playerHand.remove(tile);
            this.score = scoreBoard.totalScore;
            playerDrawsTile(currentPlayer);
            endTurn();
        } else {
            this.discardPile.add(tile);
            currentPlayer.playerHand.remove(tile);
            fusesLeft--;
            playerDrawsTile(currentPlayer);
            endTurn();
        }
    }

    private void endTurn() {
        this.currentPlayer = currentPlayer.equals(players[0]) ? players[1] : players[0];

        this.inactivePlayer = inactivePlayer.equals(players[0]) ? players[1] : players[0];
    }

    public void passTurn() {
        endTurn();
    }

    public void discardTile(Tile tile) {
        this.discardPile.add(tile);
        this.currentPlayer.playerHand.remove(tile);
        cluesLeft++;
        playerDrawsTile(this.currentPlayer);
        endTurn();
    }

    public void giveHint(int tileIndex, int colorOrValue) { //1 for color, two for value
        if (cluesLeft == 0) {
            return;
        }
        if (colorOrValue == 1) {
            for (Tile tile : inactivePlayer.playerHand) {
                if (tile.tileColor == inactivePlayer.playerHand.get(tileIndex).tileColor) {
                    tile.hintColor = true;
                }
            }
        } else {
            for (Tile tile : inactivePlayer.playerHand) {
                if (tile.tileValue == inactivePlayer.playerHand.get(tileIndex).tileValue) {
                    tile.hintValue = true;
                }
            }
        }
        cluesLeft--;
        endTurn();
    }


}
