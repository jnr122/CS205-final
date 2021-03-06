import java.util.ArrayList;

/**
 * Piece class
 *
 * Represents a single game piece
 * Stores area, player num, offset, relativeLocation, board size, finish size
 * Supports moving to board, moving to home, moving n spaces, and getting area
 */

public class Piece {

    // fields
    private Area ar;
    private int playerNum;
    private int playerOffset;
    private int pieceNum;
    private int relativeLoc;
    private Type type;

    /**
     * Constructor
     * @param playerNum, the player's turn value
     */
    Piece(int playerNum, int pieceNum, Type type) {
        ar = Area.HOME;
        this.playerNum = playerNum;
        this.pieceNum = pieceNum + 1;
        this.playerOffset = playerNum * Constants.OFFSET;
        this.toHome();
        this.type = type;
    }

    /**
     * Overloaded constructor to accept saved areaLoc
     * @param playerNum, the player's turn value, and saved area and absoluteLoc
     */
    Piece(int playerNum, int pieceNum, Area ar, int relativeLoc, Type type) {
        this.playerNum = playerNum;
        this.pieceNum = pieceNum + 1;
        this.playerOffset = playerNum * Constants.OFFSET;
        this.ar = ar;
        this.relativeLoc = relativeLoc;
        this.type = type;

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
        relativeLoc = pieceNum;
    }


    public void setArLoc(AreaLoc arLoc) {
        this.ar = arLoc.ar;
        this.relativeLoc = arLoc.loc;
    }

    /**
     * Calculate all valid moves given a roll of n
     * @param n
     * @return all valid moves
     */
    public ArrayList<AreaLoc> getValidMoves(int n) {
        ArrayList<AreaLoc> validMoves = new ArrayList<>();

        // moving on board
        if (ar == Area.BOARD) {
            if (relativeLoc + n > Constants.BOARDSIZE) { // full lap
                if ((relativeLoc + n) - (Constants.BOARDSIZE) > Constants.FINISHSIZE) { // continuing around
                    // should only be values [1,28]
                    validMoves.add(new AreaLoc(Area.BOARD,(((relativeLoc + n) % Constants.BOARDSIZE))));
                } else {  // entering finish
                    validMoves.add(new AreaLoc(Area.FINISH,(relativeLoc + n) - (Constants.BOARDSIZE)));
                    // can't choose to continue around the board
//                    validMoves.add(new AreaLoc(Area.BOARD,(relativeLoc + n) % Constants.BOARDSIZE));
                }

            } else {
                validMoves.add(new AreaLoc(Area.BOARD,relativeLoc + n)); // still completing lap
            }

        } else if (ar == Area.FINISH) {  // moving in finish
            if (relativeLoc + n <= Constants.FINISHSIZE) {
                validMoves.add(new AreaLoc(Area.FINISH,relativeLoc + n));
            }

        } else  {  // tried to move directly from HOME
            if (n == Constants.FROMHOMETHRESHOLD) {
                validMoves.add(new AreaLoc(Area.BOARD,1));
            }
        }

        return validMoves;
    }

    /**
     * Area getter
     * @return current area
     */
    public Area getAr() {
        return ar;
    }

    /**
     * Getters
     */
    /**
     * Computes the absolute location of the piece on the board using its relative location
     *
     * If the piece is in HOME or FINISH absoluteLoc = relativeLoc
     * @return the absolute location of the piece
     */
    public int getAbsoluteLoc() {
        if (ar == Area.BOARD) {
            // should only return values [1,28]
            if (((relativeLoc + playerOffset) % Constants.BOARDSIZE) == 0) {
                return Constants.BOARDSIZE;
            }
            return ((relativeLoc + playerOffset) % Constants.BOARDSIZE);
        }
        return relativeLoc;
    }
    public int getPieceNum() {
        return pieceNum-1;
    }
    public int getPlayerNum() {
        return playerNum;
    }
    public int getRelativeLoc() {
        return relativeLoc;
    }
    public Type getType() {
        return type;
    }

    /**
     * Overridden toString
     */
    public String toString() {
        String s = "Area: " + ar + " Rel: " + relativeLoc  + " Abs: " + getAbsoluteLoc();;
        return s;
    }
}