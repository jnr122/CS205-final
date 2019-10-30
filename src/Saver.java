import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {

    String filePath;

    /**
     * Constructor
     * @param filePath
     */
    Saver(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Write string representation of board
     * @param board
     * @param turn
     * @return 1 on success, -1 on failure
     */
    public int save(Board board, int turn) {
        File file = new File(filePath);
        FileWriter fr;
        try {
            fr = new FileWriter(file);
            fr.write(board.toString());
            fr.write(Integer.toString(turn));
            fr.close();
            return 1;

        } catch (IOException e) {
            System.out.println("Couldn't find file");
            return -1;
        }
    }



}
