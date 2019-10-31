import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Player class
 *
 * Represents a single player
 * Stores an array of pieces and the playerNum
 * Supports movement to and from board, and movement of piece i by n spaces
 */
public class Player {

    ArrayList<Piece> pieces;
    private int playerNum;
    private Board board;

    /**
     * Constructor
     * @param playerNum the player's turn value
     */
    Player(int playerNum, Board board) {
        this.playerNum = playerNum;
        this.board = board;
        pieces = new ArrayList<>();

        for (int i = 0; i < Constants.NUMPLAYERPIECES; i++) {
            Piece p = new Piece(playerNum, i);
            pieces.add(p);
            board.update(p);
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
        int choice;

        // get all valid moves
        ArrayList<AreaLoc> validMoves = pieces.get(i).getValidMoves(n);
        validMoves = removeOverlap(validMoves);

        // if making a lap, user gets choice to move into finish or continue around
        if (validMoves.size() == 2) {
            Scanner sc = new Scanner(System.in);
            if (!Constants.RUNSIM) {
                System.out.print("Move to finish (0) or continue around board (1): ");
                choice = sc.nextInt();
            } else {
                choice = 0;
            }
            board.remove(pieces.get(i));
            pieces.get(i).setArLoc(validMoves.get(choice));
            board.update(pieces.get(i));
            return 1;

        } else if (validMoves.size() == 1)  {
            board.remove(pieces.get(i));
            pieces.get(i).setArLoc(validMoves.get(0));
            board.update(pieces.get(i));
            return 1;
        }
        return -1;
    }

    /**
     * Return movable piece indices given roll n
     * @param n
     * @return movable piece indices
     */
    public ArrayList<Integer> getMovablePieces(int n) {
        ArrayList<Integer> movablePieces = new ArrayList<>();
        for (int i = 0; i < Constants.NUMPLAYERPIECES; i++) {
            if (removeOverlap(pieces.get(i).getValidMoves(n)).size() > 0) {
                movablePieces.add(i);
            }
        }
        return movablePieces;
    }

    /**
     * Take list of valid moves and remove moves that would overlap with player's other pieces
     * @param validMoves
     * @return edited list of valid moves
     */
    private ArrayList<AreaLoc> removeOverlap(ArrayList<AreaLoc> validMoves) {
        System.out.println("\n---------");
//        for (int j = validMoves.size()-1; j >= 0; j--) {
////        for (int j = 0; j < validMoves.size()-1; j++) {
//
//            for (int i = 0; i < Constants.NUMPLAYERPIECES; i++) {
//                System.out.println("size: " + validMoves.size());
//                System.out.println("j:" + j);
//                System.out.println("i:" + i);
//                if (pieces.get(i).getAr() == validMoves.get(j).ar &&
//                        pieces.get(i).getRelativeLoc() == validMoves.get(j).loc) {
//                    validMoves.set(j, null);
//                }
//            }
//        }

        for (int i = 0; i < Constants.NUMPLAYERPIECES; i++) {
            for (int j = 0; j < validMoves.size(); j++) {
                System.out.println("size: " + validMoves.size());
                System.out.println("j:" + j);
                System.out.println("i:" + i);

                if (validMoves.get(j) != null) {
                    if (pieces.get(i).getAr() == validMoves.get(j).ar && pieces.get(i).getRelativeLoc() == validMoves.get(j).loc) {
                        validMoves.set(j, null);
                    }
                }
            }
        }

        if (validMoves.size() > 0) {
            validMoves.removeAll(Collections.singleton(null));
        }
        return validMoves;
    }

    /**
     * Check if all of a players pieces are in a given area
     * @param ar area to check
     * @return true if all pieces are in a given area, else false
     */
    public boolean allPiecesInArea(Area ar) {
        for (int i = 0; i < Constants.NUMPLAYERPIECES; i++) {
            if (pieces.get(i).getAr() != ar) {
                return false;
            }
        }
        return true;
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
        for (int i = 0; i < Constants.NUMPLAYERPIECES; i++) {
            s += pieces.get(i).toString() + "  |  ";
        }
        return s;
    }

    public int getPlayerNum() {
        return playerNum;
    }

}
