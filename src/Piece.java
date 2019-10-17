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


    // Constructor takes only player num to decide where
    Piece(int playerNum) {
        ar = Area.HOME;
        this.playerNum = playerNum;
        playerOffset = playerNum * OFFSET;
    }

    // send piece to board and initialize at relative '0'
    public void toBoard() {
        ar = Area.BOARD;
        // adjust starting loc  because not all players start at 0
        loc = playerOffset;
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
        }

        // tried to move directly from HOME
        return -1;

    }

    public Area getAr() {
        return ar;
    }


}
