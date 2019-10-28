import java.util.ArrayList;
import java.util.Scanner;

/**
 * Player class
 *
 * Represents a single player
 * Stores an array of pieces and the playerNum
 * Supports movement to and from board, and movement of piece i by n spaces
 *
 * Last modified 10/18/19
 */
public class Player {

    private static final int numPieces = 4;
    ArrayList<Piece> pieces;
    private int playerNum;
    private Board board;

    /**
     * Constructor
     * @param playerNum the player's turn value
     */
    Player(int playerNum, Board board) {
        this.playerNum = playerNum;
        this.board = board;
        pieces = new ArrayList<>();

        for (int i = 0; i < numPieces; i++) {
            pieces.add(new Piece(playerNum, i));
        }
    }

    /**
     * Attempt to move piece
     *
     * @param i piece index
     * @param n num spaces
     * @return -1 on failure, else new loc
     */
    public int move(int i, int n) {

        // get all valid moves
        ArrayList<AreaLoc> validMoves = pieces.get(i).getValidMoves(n);
        validMoves = removeOverlap(validMoves);

        // if making a lap, user gets choice to move into finish or continue around
        if (validMoves.size() == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Move to finish (0) or continue around board (1): ");
            int choice = sc.nextInt();
            pieces.get(i).setArLoc(validMoves.get(choice));
            return 1;

        } else if (validMoves.size() == 1)  {
            pieces.get(i).setArLoc(validMoves.get(0));
            return 1;
        }
        System.out.println("No valid moves");
        return -1;
    }

    /**
     * Take list of valid moves and remove moves that would overlap with player's other pieces
     * @param validMoves
     * @return edited list of valid moves
     */
    private ArrayList<AreaLoc> removeOverlap(ArrayList<AreaLoc> validMoves) {
        for (int j = validMoves.size()-1; j >= 0; j--) {
            for (int i = 0; i < numPieces; i++) {
                if (pieces.get(i).getAr() == validMoves.get(j).ar &&
                        pieces.get(i).getRelativeLoc() == validMoves.get(j).loc) {
                    validMoves.remove(j);
                    if (validMoves.size() == 0) {
                        return validMoves;
                    }
                }
            }
        }
        return validMoves;
    }

    /**
     * Move piece i to board
     * @param i piece index
     */
    public void toBoard(int i) {
        pieces.get(i).toBoard();
    }

    /**
     * Move piece i to home
     * @param i piece index
     */
    public void toHome(int i) {
        pieces.get(i).toHome();
    }

    /**
     * Overloaded toString
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < numPieces; i++) {
            s += pieces.get(i).toString() + "  |  ";
        }
        return s;
    }

}
