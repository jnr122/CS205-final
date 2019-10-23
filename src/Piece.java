import java.util.ArrayList;
import java.util.Scanner;

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

    public String toString() {
        return "Ar: " + this.ar + " Loc: " + this.loc;
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


    public void setArLoc(AreaLoc arLoc) {
        this.ar = arLoc.ar;
        this.relativeLoc = arLoc.loc;
    }

    public ArrayList<AreaLoc> getValidMoves(int n) {
        ArrayList<AreaLoc> areaLocs = new ArrayList<>();

        // moving on board
        if (ar == Area.BOARD) {
            if (relativeLoc + n > BOARDSIZE) { // full lap
                if ((relativeLoc + n) - (BOARDSIZE) > FINISHSIZE) { // continuing around
                    areaLocs.add(new AreaLoc(Area.BOARD,(relativeLoc + n) % BOARDSIZE));
                } else {  // entering finish
                    areaLocs.add(new AreaLoc(Area.FINISH,(relativeLoc + n) - (BOARDSIZE)));
                    areaLocs.add(new AreaLoc(Area.BOARD,(relativeLoc + n) % BOARDSIZE));
                }

            } else {
                areaLocs.add(new AreaLoc(Area.BOARD,relativeLoc + n)); // still completing lap
            }

        } else if (ar == Area.FINISH) {  // moving in finish
            if (relativeLoc + n <= FINISHSIZE) {
                areaLocs.add(new AreaLoc(Area.FINISH,relativeLoc + n));
            }

        } else  {  // tried to move directly from HOME
            if (n == 6) {
                areaLocs.add(new AreaLoc(Area.BOARD,0));
            } else {
                areaLocs.add(new AreaLoc(Area.HOME,-1));            }
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
     *
     * @return relativeLoc
     */
    public int getRelativeLoc() {
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