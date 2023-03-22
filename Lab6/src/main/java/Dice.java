import java.util.Random;
/**
 * The Dice class for lab 9.
 * <br>Have a look through the file to see how a simple object class is constructed.
 * <br>The dice class has a random number generator and an int number of sides.
 * <br>We can roll the die to get a random value in the game.
 */
public class Dice {
    /**
     * Private member variables.
     */
    /**
     * Random number generator to "roll" our random dice value.
     */
    private Random myRand;
    /**
     * Integer representing the number of sides on the die.
     */
    private int numSides;


    /**
     * Dice constructor.
     *
     * <br>Constructs a new Dice instance with a random number generator
     * @param sides - the number of sides our dice should be
     */
    public Dice(final int sides) {
        this.myRand = new Random();
        this.numSides = sides;
    }


    /**
     * Rolls a pseudorandom number between 1 and the number of sides.
     *
     * @return the number the die rolled
     */
    public int roll() {
        //nextInt is 0 inclusive and numSides exclusive
        return (myRand.nextInt(numSides) + 1);
    }

}
