import java.util.Random;

/**
 * Simulating die rolls
 */
public class Die {

    private int numSides;

    /**
     * Constructor
     * @param numSides
     */
    public Die(int numSides) {
        this.numSides = numSides;
    }

    /**
     * Simulate roll
     * @return result
     */
    public int roll() {
        Random rand = new Random();
        return rand.nextInt(numSides) + 1;
    }
}
