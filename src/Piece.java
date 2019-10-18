import org.jetbrains.annotations.Contract;

/**
 * Piece class
 *
 * Represents a single game piece
 * Stores area, player num, offset, relativeLocation, board size, finish size
 * Supports moving to board, moving to home, moving n spaces, and getting area
 *
 * Offset value allows player movement to follow the same mechanics but not overlap as they all have
 * different starting relativeLocations
 *
 * Last modified 10/17/19
 */
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
        playerOffset = 0;//playerNum * OFFSET;
    }

    /**
     * Send piece to board and initialize at relative '0'
     */
    public void toBoard() {
        ar = Area.BOARD;
        // adjust starting relativeLoc  because not all players start at 0
        relativeLoc = playerOffset;
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
    public int move(int n) {
        // moving on board
        if (ar == Area.BOARD) {
            // full lap
            if (relativeLoc + n > BOARDSIZE + playerOffset) {
                // continuing around
                if ((relativeLoc + n) - (BOARDSIZE + playerOffset) > FINISHSIZE) {
                    relativeLoc = (relativeLoc + n) % BOARDSIZE;
                    return relativeLoc;
                } else {
                    // entering finish
                    ar = Area.FINISH;
                    relativeLoc = (relativeLoc + n) - (BOARDSIZE + playerOffset);
                    return relativeLoc;
                }

            } else {
                // still completing lap
                relativeLoc = (relativeLoc + n);
//                relativeLoc = (relativeLoc + n) % BOARDSIZE;

                return relativeLoc;
            }
            // moving in finish
        } else if (ar == Area.FINISH) {
            if (relativeLoc + n <= FINISHSIZE) {
                relativeLoc += n;
                return relativeLoc;
            }
            return -1;

            // tried to move directly from HOME
        } else  {
            if (n == 6) {
                ar = Area.BOARD;
                relativeLoc = playerOffset;
                return relativeLoc;
            } else {
                return -1;
            }
        }
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
        String s = "Area: " + ar + " relativeLoc: " + relativeLoc;
        return s;
    }
}