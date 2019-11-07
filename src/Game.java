import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * Representation of the game
 *
 * To simulate, comment lines
 */
public class Game {

    // Fields
    private Board board;
    private ArrayList<Player> players;
    private ArrayList<Integer> movablePieces;
    private ArrayList<Integer> CPUs;
    private Die die;
    private int winner;
    private boolean gameOver;
    private int startingTurn;
    private Loader loader;
    private Random rand;

    /**
     * Constructor
     */
    public Game(ArrayList<Type> types) {
        gameOver = false;
        rand = new Random();
        players = new ArrayList<>();
        movablePieces = new ArrayList<>();
        board = new Board();
        die = new Die(Constants.NUMDIESIDES);
        for (int i = 0; i < Constants.NUMPLAYERS; i++) {
            players.add(new Player(i, board, types.get(i)));
        }
        loader = new Loader();
        startingTurn = 0;
    }

    public Game(ArrayList<Player> players, Board board, int startingTurn) {
        gameOver = false;
        rand = new Random();
        this.players = players;
        movablePieces = new ArrayList<>();
        this.board = board;
        die = new Die(Constants.NUMDIESIDES);
        loader = new Loader();
        this.startingTurn = startingTurn;
    }

    /**
     * Main game loop
     */
    public void run() {
        int turnCount = this.startingTurn;
        // start turn with player0
        while (!gameOver) {
            turn(turnCount);
            // until the game is over, rotate turns
            if (!gameOver) {
                turnCount += 1;
                turnCount %= Constants.NUMPLAYERS;
            }
            loader.save(turnCount, players);
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
    private void turn(int playerNum) {
        // only play turn if not NULL player
        if (!(players.get(playerNum).getType() == Type.NULL)) {

            int roll;
            int toMove;
            int result;

            Scanner sc = new Scanner(System.in);
            System.out.println(board);

            roll = die.roll();
            movablePieces = players.get(playerNum).getMovablePieces(roll);

            // players can move no pieces
            if (movablePieces.size() == 0) {
                System.out.print("Roll = " + roll + ". Player " + playerNum + " can't move anything. (c) to continue: ");
                if (!Constants.RUNSIM && players.get(playerNum).getType() == Type.PLAYER) {
                    sc.next();
                }
                System.out.println();
            } else {
                String s = "";
                for (int i = 0; i < movablePieces.size(); i++) {
                    s += "(" + movablePieces.get(i) + ") ";
                }
                System.out.println("Roll = " + roll + ". Player " + playerNum + ", Which piece would you like to move " + s);

                if (!Constants.RUNSIM && players.get(playerNum).getType() == Type.PLAYER) {
                    toMove = sc.nextInt();
                } else {
                    toMove = movablePieces.get(rand.nextInt(movablePieces.size()));
                }
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
    }

    /**
     * playerNum wins
     * @param playerNum
     */
    private void win(int playerNum) {
        System.out.println(board);
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