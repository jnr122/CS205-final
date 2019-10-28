import java.util.ArrayList;

public class Board {
    private ArrayList<BoardSquare> home;
    private ArrayList<BoardSquare> board;
    private ArrayList<BoardSquare> finish;

    public Board() {
        for (int i = 1; i <= Constants.HOMESIZE; i++) {
            home.add(new BoardSquare(null, Area.HOME, i));
        }
        for (int i = 1; i <= Constants.BOARDSIZE; i++) {
            board.add(new BoardSquare(null, Area.BOARD, i));
        }
        for (int i = 1; i <= Constants.FINISHSIZE; i++) {
            finish.add(new BoardSquare(null, Area.FINISH, i));
        }
    }



}
