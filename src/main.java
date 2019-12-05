import java.util.ArrayList;

public class main {
    /**
     * Test game structure
     */
    public static void main(String[] args) {
        Loader loader = new Loader();

        ArrayList<Type> types = new ArrayList<>();
        types.add(Type.NULL);
        types.add(Type.CPU);
        types.add(Type.NULL);
        types.add(Type.PLAYER);

        Game g = new Game(types);
//        g = loader.load();

//        g.run();

    }
}