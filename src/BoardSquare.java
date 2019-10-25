/**
 * BoardSquare object class
 *
 * Last modified 10/23/19
 */
public class BoardSquare {
    private Piece piece;

    /**
     * Constructor
     * @param piece, always null when starting game
     */
    BoardSquare(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
