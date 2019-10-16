public class Piece {

    // fields
    private Area ar;
    private int playerNum;
    private int loc = -1;
    private final int PLAYEROFFSET = 7;

    // 28 board spaces and 4 finish spaces
    private int BOARDSIZE = 28;
    private int TOTALSIZE = 32;


    // Constructor takes only player num to decide where
    Piece(int playerNum) {
        ar = Area.HOME;
        this.playerNum = playerNum;
    }

    // send piece to board and initialize at relative '0'
    public void toBoard() {
        ar = Area.BOARD;
        // adjust starting loc  because not all players start at 0
        loc = playerNum * PLAYEROFFSET;

    }

    // send piece back home and reset loc to -1
    public void toHome() {
        ar = Area.HOME;
        loc = -1;
    }

    // return -1 if move unsuccessful, else return loc
    public int move(int n) {
        // moving on board
        if (ar == Area.BOARD) {
            loc = (loc + n) % TOTALSIZE;
            // if moving into finish
            if (loc > (BOARDSIZE + PLAYEROFFSET * playerNum)) {
                ar = Area.FINISH;
            }
            return loc;
            // if moving in finish
        }
//        else if (ar == Area.FINISH) {
//
//        }
        return -1;
    }


}
