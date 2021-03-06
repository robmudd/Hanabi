public class Tile {

    Color tileColor;
    int tileValue;
    boolean hintColor;
    boolean hintValue;

    public Tile (Color tileColor, int tileValue) {
        this.tileColor = tileColor;
        this.tileValue = tileValue;
        this.hintColor = false;
        this.hintValue = false;
    }

    public String toString() {
        StringBuilder hintString = new StringBuilder();
        if (hintValue || hintColor) {
            hintString.append(" hints: ");
            if (hintColor) hintString.append(this.tileColor.toString() + " ");
            if (hintValue) hintString.append(this.tileValue);
        }
        return "Tile: " + this.tileColor.toString() + " " + this.tileValue + hintString;
    }

}
