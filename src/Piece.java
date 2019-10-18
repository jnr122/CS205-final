import org.jetbrains.annotations.Contract;

/**
 * Piece class
 *
 * Represents a single game piece
 * Stores area, player num, offset, location, board size, finish size
 * Supports moving to board, moving to home, moving n spaces, and getting area
 *
 * Offset value allows player movement to follow the same mechanics but not overlap as they all have
 * different starting locations
 *
 * Last modified 10/17/19
 */
public class Piece {

    // fields
    private Area ar;
    private int playerNum;
    private int playerOffset;
    private int loc = -1;

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
        // adjust starting loc  because not all players start at 0
        loc = playerOffset;
    }

    /**
     * Send piece back home and reset loc to -1
     */
    public void toHome() {
        ar = Area.HOME;
        loc = -1;
    }

    /**
     * Try to move piece n spaces
     *
     * Need to let player decide if they move around or to finish
     * @param n
     * @return return -1 if move unsuccessful, else return loc
     */
    public int move(int n) {
        // moving on board
        if (ar == Area.BOARD) {
            // full lap
            if (loc + n > BOARDSIZE + playerOffset) {
                // continuing around
                if ((loc + n) - (BOARDSIZE + playerOffset) > FINISHSIZE) {
                    loc = (loc + n) % BOARDSIZE;
                    return loc;
                } else {
                    // entering finish
                    ar = Area.FINISH;
                    loc = (loc + n) - (BOARDSIZE + playerOffset);
                    return loc;
                }

            } else {
                // still completing lap
                loc += n;
                return loc;
            }
            // moving in finish
        } else if (ar == Area.FINISH) {
            if (loc + n <= FINISHSIZE) {
                loc += n;
                return loc;
            }
            return -1;

            // tried to move directly from HOME
        } else  {
            if (n == 6) {
                ar = Area.BOARD;
                loc = playerOffset;
                return loc;
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
     * Overridden toString
     */
    public String toString() {
        String s = "Area: " + ar + " Loc: " + loc;
        return s;
    }
}