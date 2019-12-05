import java.util.Random;

/**
 * Simulating die rolls
 */
public class Die {

    private int numSides;
    private int currSide;

    /**
     * Constructor
     * @param numSides
     */
    public Die(int numSides) {
        this.numSides = numSides;
        this.currSide = 0;
    }

    /**
     * Simulate roll
     * @return result
     */
    public int roll() {
        Random rand = new Random();
        currSide = rand.nextInt(numSides) + 1;;
        return currSide;
    }

    public int getCurrSide() {
        return currSide;
    }

}
