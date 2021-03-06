public class ScoreBoard {
    Tile [] scoredTiles;
    int totalScore;

    public ScoreBoard() {
        this.scoredTiles = new Tile[5]; //one for each color
        this.scoredTiles[0] = new Tile(Color.BLUE, 0);
        this.scoredTiles[1] = new Tile(Color.GREEN, 0);
        this.scoredTiles[2] = new Tile(Color.RED, 0);
        this.scoredTiles[3] = new Tile(Color.WHITE, 0);
        this.scoredTiles[4] = new Tile(Color.YELLOW, 0);
        this.totalScore = 0;
    }

    public boolean addToScoreBoard(Tile tile) {
        for (int i = 0; i < 5; i++) {
            if (scoredTiles[i].tileColor == tile.tileColor) {
                if (scoredTiles[i].tileValue == tile.tileValue - 1) {
                    scoredTiles[i] = tile;
                    this.totalScore = calculateScore();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private int calculateScore() {
        int sum = 0;
        for (Tile tile : scoredTiles) {
            sum += tile.tileValue;
        }
        return sum;
    }


}
