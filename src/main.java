public class main {
    /**
     * Test game structure
     */
    public static void main(String[] args) {
        Board board = new Board();

        Player p1 = new Player(0, board);
        System.out.println(p1);

        // move piece i to space n
        p1.move(2,6);
        p1.move(1,6);
        System.out.println(p1);

        p1.move(2,27);
        p1.move(1,27);
        System.out.println(p1);

        p1.move(2,1);
        p1.move(1,3);
        System.out.println(p1);

    }
}
