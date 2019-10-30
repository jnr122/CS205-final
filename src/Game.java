import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representation of the game
 */
public class Game {

    // Fields
    private Board board;
    private ArrayList<Player> players;
    private ArrayList<Integer> movablePieces;
    private Die die;
    private int winner;
    private boolean gameOver;

    /**
     * Constructor
     */
    public Game() {
        gameOver = false;
        int winner = -1;
        players = new ArrayList<>();
        movablePieces = new ArrayList<>();
        board = new Board();
        die = new Die(Constants.NUMDIESIDES);
        for (int i = 0; i < Constants.NUMPLAYERS; i++) {
            players.add(new Player(i, board));
        }
    }

    /**
     * Main game loop
     */
    public void run() {
        // start turn with player0
        int turnCount = 0;
        while (!gameOver) {
            turn(turnCount);

            // until the game is over, rotate turns
            if (!gameOver) {
                turnCount += 1;
                turnCount %= Constants.NUMPLAYERS;
            }
        }

        // if the game is over because a winner was selected, win
        if (winner != -1) {
            win(winner);
        }

        // else game was stopped for another reason

    }

    /**
     * Simulate a single turn for player playerNum
     * @param playerNum
     */
    public void turn(int playerNum) {
        int roll;
        int toMove;
        int result;

        Scanner sc = new Scanner(System.in);
        System.out.println(board);

        roll = die.roll();
        //TODO get rid of now redundant move validator in Player.move
        movablePieces = players.get(playerNum).getMovablePieces(roll);

        // players can move no pieces
        if (movablePieces.size() == 0) {
            System.out.print("Roll = " + roll + ". Player " + playerNum + " can't move anything. (c) to continue: ");
            sc.next();
        } else {
            String s = "";
            for (int i = 0; i < movablePieces.size(); i++) {
                s += "(" + movablePieces.get(i) + ") ";
            }
            System.out.println("Roll = " + roll + ". Player " + playerNum + ", Which piece would you like to move " + s);
            toMove = sc.nextInt();
            result = players.get(playerNum).move(toMove, roll);

            // player tried something invalid, should get to try again
            while (result == -1) {
                System.out.println("Invalid pick, try again: " + s);
                toMove = sc.nextInt();
                result = players.get(playerNum).move(toMove, roll);
            }
        }

        if (players.get(playerNum).allPiecesInArea(Area.FINISH)) {
            gameOver = true;
            winner = playerNum;
        }
    }

    /**
     * playerNum wins
     * @param playerNum
     */
    private void win(int playerNum) {
        System.out.println("Congratulations player " + playerNum);
    }

    /**
     * Overloaded toString
     * @return
     */
    public String toString() {
        return board.toString();
    }

}
