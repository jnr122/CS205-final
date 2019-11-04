import java.io.*;
import java.util.ArrayList;

/**
 * Load and save games in progress
 */
public class Loader {

    private File file;

    /**
     * Constructor
     */
    public Loader() {
        this.file = new File(Constants.FILEPATH);
    }

    /**
     * Write string representation of board
     * @param turn
     * @return 1 on success, -1 on failure
     */
    public int save(int turn, ArrayList<Player> players) {
        FileWriter fr;
        try {
            fr = new FileWriter(file);
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < players.size(); i++) {
                // store each player's piece's area and location
                for (int j = 0; j < players.get(i).getPieces().size(); j++) {
                    s.append(players.get(i).getPieces().get(j).getAr()).append("-").
                            append(players.get(i).getPieces().get(j).getRelativeLoc()).append(",");
                }
                s.append("\n");
            }
            fr.write(s.toString());
            fr.write(Integer.toString(turn));
            fr.close();
            return 1;

        } catch (IOException e) {
            System.out.println("Error writing to file");
            return -1;
        }
    }

    /**
     * Load arraylists of board
     * @return all arraylists of the board
     */
    public Game load() {
        ArrayList<Player> players = new ArrayList<>();
        Piece piece;
        ArrayList<Piece> pieces;
        String[] piecesString;
        String[] pieceString;
        Board board = new Board();
        int curTurn;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            // iterate over save file creating pieces from text and storing them in players array
            for (int i = 0; i < Constants.NUMPLAYERS; i++) {
                st = br.readLine();
                pieces = new ArrayList<>();
                piecesString = st.split(",");
                for (int j = 0; j < piecesString.length; j++) {
                    pieceString = piecesString[j].split("-");
                    pieces.add(new Piece(i, j, stringToArea(pieceString[0]), Integer.parseInt(pieceString[1])));
                }
                players.add(new Player(i, board, pieces));
            }

            curTurn = Integer.parseInt(br.readLine());

            for (int i = 0; i < players.size(); i++) {
                for (int j = 0; j < players.get(i).getPieces().size(); j++) {
                    board.update(players.get(i).getPieces().get(j));
                }
            }

            return (new Game(players, board, curTurn));

        } catch (IOException e) {
            System.out.println("Error reading file");
            return null;
        }
    }

    private Area stringToArea(String s) {
        if (s.equals("HOME"))
            return Area.HOME;
        else if (s.equals("BOARD"))
            return Area.BOARD;
        else
            return Area.FINISH;
    }

}
