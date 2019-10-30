class AreaLoc {
    public Area ar;
    int loc;

    AreaLoc(Area ar, int loc) {
        this.ar = ar;
        this.loc = loc;
    }

    public String toString() {
        return "Ar: " + this.ar + " Loc: " + this.loc;
    }
};

/**
 * Keep track of constants
 */
public class Constants {
    public static final int BOARDSIZE = 28;
    public static final int FINISHSIZE = 4;
    public static final int HOMESIZE = 4;
    public static final int OFFSET = 7;
    public static final int NUMPLAYERS = 4;
    public static final int NUMPLAYERPIECES = 4;
    public static final int NUMDIESIDES = 6;
    public static final int FROMHOMETHRESHOLD = 6;
}
