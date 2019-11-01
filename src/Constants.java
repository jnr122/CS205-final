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
class Constants {
    static final int BOARDSIZE = 28;
    static final int FINISHSIZE = 4;
    static final int HOMESIZE = 4;
    static final int OFFSET = 7;
    static final int NUMPLAYERS = 4;
    static final int NUMPLAYERPIECES = 4;
    static final int NUMDIESIDES = 6;
    static final int FROMHOMETHRESHOLD = 6;
    static final boolean RUNSIM = true;
    static final String FILEPATH = "src/saveData/save.txt";
}