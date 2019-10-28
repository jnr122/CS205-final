import java.util.ArrayList;

/**
 * Board class
 *
 * Each palyer gets the reference to the board class, which stores arraylists
 * of boardsquares fore homes, finishes, and the board
 *
 * As players move pieces the arraylists are updated
 */
public class Board {
    /**
     * Arraylist representation of the board
     */
    private ArrayList<ArrayList<BoardSquare>> homes;
    private ArrayList<BoardSquare> board;
    private ArrayList<ArrayList<BoardSquare>> finishes;

    /**
     * Constructor
     */
    public Board() {
        homes = new ArrayList<>();
        board = new ArrayList<>();
        finishes = new ArrayList<>();

        // generate multiple homes and finishes
        for (int j = 0; j < Constants.NUMPLAYERS; j++) {
            ArrayList<BoardSquare> home = new ArrayList<>();
            ArrayList<BoardSquare> finish = new ArrayList<>();

            for (int i = 1; i <= Constants.HOMESIZE; i++) {
                home.add(new BoardSquare(null, Area.HOME, i));
            }
            for (int i = 1; i <= Constants.FINISHSIZE; i++) {
                finish.add(new BoardSquare(null, Area.FINISH, i));
            }
            homes.add(home);
            finishes.add(finish);
        }
        // generate board
        for (int i = 1; i <= Constants.BOARDSIZE; i++) {
            board.add(new BoardSquare(null, Area.BOARD, i));
        }

    }

    /**
     * Whenever a player moves, update the board to reflect the move
     * @param p the piece being moved storing its new location
     */
    //TODO setpiece should knock pieces back
    public void update(Piece p) {
        if (p.getAr() == Area.HOME) {
            homes.get(p.getPlayerNum()).get(p.getAbsoluteLoc()).setPiece(p);
        } else if (p.getAr() == Area.BOARD) {
            board.get(p.getAbsoluteLoc()).setPiece(p);
        } else {
            finishes.get(p.getPlayerNum()).get(p.getAbsoluteLoc()).setPiece(p);
        }
    }

    /**
     * Takes area and location and returns a boardsquare, ar is the board
     * @param ar
     * @param loc
     * @return
     */
    public BoardSquare getBoardSquare(Area ar, int loc) {
        if (ar == Area.BOARD) {
            return board.get(loc - 1);
        }
        return null;
    }





}
