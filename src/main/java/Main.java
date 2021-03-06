import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        System.out.println("Enter any input to begin:");
        String userInput = scanner.nextLine();

        game = new Game();
        System.out.println(game);


        while (!game.gameOver) {
            try {

                System.out.printf("%s's turn\n", game.currentPlayer.playerName);
                System.out.println("Enter Command (pass, score, discard, exit)");
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("pass")) {
                    game.passTurn();
                } else if (userInput.contains("score")) {
                    System.out.println("which Tile?");
                    int tileSelection = Integer.valueOf(scanner.nextLine());
                    game.scoreTile(game.currentPlayer.playerHand.get(tileSelection - 1));
                } else if (userInput.equalsIgnoreCase("exit")) {
                    break;
                } else if (userInput.equalsIgnoreCase("discard")) {
                    System.out.println("which Tile?");
                    int tileSelection = Integer.valueOf(scanner.nextLine());
                    game.discardTile(game.currentPlayer.playerHand.get(tileSelection - 1));
                } else if (userInput.equalsIgnoreCase("hint")) {
                    System.out.println("which Tile?");
                    int tileSelection = Integer.valueOf(scanner.nextLine());
                    System.out.println("which hint (1 for color, 2 for value");
                    int hintSelection = Integer.valueOf(scanner.nextLine());
                    game.giveHint(tileSelection - 1, hintSelection);
                } else {
                    System.out.println("Invalid Command!  Try Again:");
                }
                System.out.println(game);
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }
}
