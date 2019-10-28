/**
 * BoardSquare object class
 *
 * Last modified 10/23/19
 */
public class BoardSquare {
    private Piece piece;
    private AreaLoc arLoc;

    /**
     * Constructor
     * @param piece, always null when starting game
     */
    BoardSquare(Piece piece, Area ar, int loc) {
        this.piece = piece;
        this.arLoc = new AreaLoc(ar, loc);
    }

    /**
     * Getters and setters
     */
    public Piece getPiece() {
        return piece;
    }
    public AreaLoc getArLoc() {
        return arLoc;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Overloaded toString
     * @return s
     */
    public String toString() {
        String s;
        if (this.piece == null) {
            s = "null";
        } else {
            s = this.piece.toString();
        }
        return s;
    }
}
