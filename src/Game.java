import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representation of the game
 */
public class Game {

    // Fields
    private Board board;
    private ArrayList<Player> players;
    private Die die;
    private boolean gameOver;

    /**
     * Constructor
     */
    public Game() {
        gameOver = false;
        players = new ArrayList<>();
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
        int turnCount = 0;
        while (!gameOver) {
            turn(turnCount);
            turnCount += 1;
            turnCount %= 4;
        }
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

        roll = die.roll();
        System.out.println("Roll = " + roll + ". Player " + playerNum + ", Which piece would you like to move (0), (1), (2), (3) ");

        // players can move no pieces
        if (players.get(playerNum).allPiecesInArea(Area.HOME) && roll != 6) {
            System.out.println("Can't move anything from home");
        } else {
            toMove = sc.nextInt();
            //
            result = players.get(playerNum).move(toMove, roll);

        }

        if (players.get(playerNum).allPiecesInArea(Area.FINISH)) {
            gameOver = true;
        }
        System.out.println(board);
    }

    /**
     * Overloaded toString
     * @return
     */
    public String toString() {
        return board.toString();
    }

}
