import java.util.ArrayList;

public class Player {

    static int numPieces = 4;
    ArrayList<Piece> pieces;
    int playerNum;

    /**
     * Constructor
     * @param playerNum the player's turn value
     */
    Player(int playerNum) {
        this.playerNum = playerNum;
        pieces = new ArrayList<>();

        for (int i = 0; i < numPieces; i++) {
            pieces.add(new Piece(playerNum));
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
        return pieces.get(i).move(n);
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

            s += pieces.get(i).toString() + "   ";
        }

        return s;
    }

}
