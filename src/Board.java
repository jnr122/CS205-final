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

    //TODO consolidate update and remove

    //possible off by 1 error, believe its been fixed
    /**
     * Whenever a player moves, update the board to reflect the move
     * @param p the piece being moved storing its new location
     */
    public void update(Piece p) {
        if (p.getAr() == Area.HOME) {
            homes.get(p.getPlayerNum()).get(p.getAbsoluteLoc()-1).setPiece(p);
        } else if (p.getAr() == Area.BOARD) {
            if (board.get(p.getAbsoluteLoc()-1).getPiece() != null) {
                board.get(p.getAbsoluteLoc()-1).getPiece().toHome();
                update(board.get(p.getAbsoluteLoc()-1).getPiece());
            }
            board.get(p.getAbsoluteLoc()-1).setPiece(p);
        } else {
            finishes.get(p.getPlayerNum()).get(p.getAbsoluteLoc()-1).setPiece(p);
        }
    }

    /**
     * Before updating position of p, old postion needs to be removed
     * @param p
     */
    public void remove(Piece p) {
        if (p.getAr() == Area.HOME) {
            int x = p.getPlayerNum();
            homes.get(p.getPlayerNum()).get(p.getAbsoluteLoc()-1).setPiece(null);
        } else if (p.getAr() == Area.BOARD) {
            board.get(p.getAbsoluteLoc()-1).setPiece(null);
        } else {
            finishes.get(p.getPlayerNum()).get(p.getAbsoluteLoc()-1).setPiece(null);
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

    /**
     * Overloaded toString for board
     * @return s the representation of the board as a string
     */
    public String toString() {
        String lineBreak = "\n---------------------------------------------------------\n";
        String sHomes = "";
        String sFinishes = "";
        String sBoard = "Board: ";

        // home
        for (int i = 0; i < Constants.NUMPLAYERS; i++) {
            sHomes += "homes " + i + ": | ";
            for (int j = 0; j < homes.get(i).size(); j++) {
                if (homes.get(i).get(j).getPiece() != null) {
                    sHomes += "p" + homes.get(i).get(j).getPiece().getPlayerNum() + "-" +
                            homes.get(i).get(j).getPiece().getPieceNum()+  " | ";
                } else {
                    sHomes += "-- | ";
                }
            }
            sHomes += "\n";
        }

        // finish
        for (int i = 0; i < Constants.NUMPLAYERS; i++) {
            sFinishes += "finishes " + i + ": | ";
            for (int j = 0; j < finishes.get(i).size(); j++) {
                if (finishes.get(i).get(j).getPiece() != null) {
                    sFinishes += "p" + finishes.get(i).get(j).getPiece().getPlayerNum() + "-" +
                            finishes.get(i).get(j).getPiece().getPieceNum()+ " | ";
                } else {
                    sFinishes += "-- | ";
                }
            }
            sFinishes += "\n";
        }

        // board
        for (int i = 0; i < Constants.BOARDSIZE; i++) {
            if (board.get(i).getPiece() == null) {
                sBoard += "- | ";
            } else {
                sBoard +=  "p" + board.get(i).getPiece().getPlayerNum() + "-"
                        + board.get(i).getPiece().getPieceNum() + " | ";
            }
        }
        sBoard += "\n";
        return sHomes + "\n" + sBoard + "\n" + sFinishes + lineBreak;
    }

    /**
     * Getters for various parts of the board
     */
    public ArrayList<ArrayList<BoardSquare>> getHomes() {
            return homes;
    }
    public ArrayList<ArrayList<BoardSquare>> getFinishes() {
        return finishes;
    }
    public ArrayList<BoardSquare> getBoard() {
        return board;
    }
}
