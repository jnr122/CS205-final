public class main {
    /**
     * Test game structure
     */
    public static void main(String[] args) {
        Board board = new Board();
        Player p0 = new Player(0, board);
        Player p1 = new Player(1, board);
        Player p2 = new Player(2, board);
        Player p3 = new Player(3, board);

        System.out.println(board);

        // move piece i to space n
        p0.move(0,6);

        System.out.println(board);

    }
}
