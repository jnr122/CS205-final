public class Piece {


    private Area ar;
    private int playerNum;
    private int loc = -1;
    private final int PLAYEROFFSET = 7;

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


}
