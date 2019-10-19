import java.util.ArrayList;

/**
 * Piece class
 *
 * Represents a single game piece
 * Stores area, player num, offset, relativeLocation, board size, finish size
 * Supports moving to board, moving to home, moving n spaces, and getting area
 *
 * Last modified 10/18/19
 */

class AreaLoc {
    public Area ar;
    public int loc;

    AreaLoc(Area ar, int loc) {
        this.ar = ar;
        this.loc = loc;
    }
};

public class Piece {

    // fields
    private Area ar;
    private int playerNum;
    private int playerOffset;
    private int relativeLoc = -1;

    // 28 board spaces and 4 finish spaces
    private final int BOARDSIZE = 28;
    private final int FINISHSIZE = 4;

    private final int OFFSET = 7;

    /**
     * Constructor
     * @param playerNum, the player's turn value
     */
    Piece(int playerNum) {
        ar = Area.HOME;
        this.playerNum = playerNum;
        playerOffset = playerNum * OFFSET;
    }

    /**
     * Send piece to board and initialize at relative '0'
     */
    public void toBoard() {
        ar = Area.BOARD;
        relativeLoc = 0;
    }

    /**
     * Send piece back home and reset relativeLoc to -1
     */
    public void toHome() {
        ar = Area.HOME;
        relativeLoc = -1;
    }

    /**
     * Try to move piece n spaces
     *
     * Need to let player decide if they move around or to finish
     * @param n
     * @return return -1 if move unsuccessful, else return relativeLoc
     */
    // split into valid move function that returns valid moves
    public int move(int n) {
        validMoves(n);
        return 0;
    }

    public ArrayList<AreaLoc> validMoves(int n) {
        ArrayList<AreaLoc> areaLocs = new ArrayList<>();
        AreaLoc areaLoc;

        // moving on board
        if (ar == Area.BOARD) {
            // full lap
            if (relativeLoc + n > BOARDSIZE) {
                // continuing around
                if ((relativeLoc + n) - (BOARDSIZE) > FINISHSIZE) {
                    relativeLoc = (relativeLoc + n) % BOARDSIZE;
//                    return relativeLoc;
                } else {
                    // entering finish
                    ar = Area.FINISH;
                    relativeLoc = (relativeLoc + n) - (BOARDSIZE);
//                    return relativeLoc;
                }
            } else {
                // still completing lap
                relativeLoc = (relativeLoc + n);
//                return relativeLoc;
            }
            // moving in finish
        } else if (ar == Area.FINISH) {
            if (relativeLoc + n <= FINISHSIZE) {
                relativeLoc += n;
//                return relativeLoc;
            }
//            return -1;
            // tried to move directly from HOME
        } else  {
            if (n == 6) {
                ar = Area.BOARD;
                relativeLoc = 0;
//                return relativeLoc;
            } else {
//                return -1;
            }
        }


        return areaLocs;
    }

    /**
     * Area getter
     * @return current area
     */
    public Area getAr() {
        return ar;
    }

    /**
     * Computes the absolute location of the piece on the board using its relative location
     *
     * If the piece is in HOME or FINISH absoluteLoc = relativeLoc
     * @return the absolute location of the piece
     */
    public int getAbsoluteLoc() {
        if (ar == Area.BOARD) {
            return (relativeLoc + playerOffset) % BOARDSIZE;
        }
        return relativeLoc;
    }

    /**
     * Overridden toString
     */
    public String toString() {
        String s = "Area: " + ar + " Rel: " + relativeLoc  + " Abs: " + getAbsoluteLoc();;
        return s;
    }
}