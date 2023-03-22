import java.util.Scanner;

/**
 * Class that implements a Pokemon colosseum.
 * <p>
 * Our Pokemon console game was a big hit and #1 top app on a fictional website! In order to meet
 * the demands, we have to make our console game even better. We're launching Pokemon 2.0
 * and introducing new features, such as different types of Pokemon with special abilities.
 * The Colosseum class is where all the battles will go down.
 * We will build our Pokemon, let them battle, and see who will be the winner!
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/9/">Lab 9 Description</a>
 */
public class Colosseum {
    /**
     * The maximum number of hit points we will allow a Pokemon to start with.
     */
    static final int MAX_HIT_POINTS = 50;

    /**
     * The maximum number of rounds we will let the Pokemon battle.
     */
    static final int MAX_NUM_ROUNDS = 10;

    /**
     * The first Pokemon we will be fighting.
     */
    static Pokemon firstPokemon;

    /**
     * The second Pokemon we will be fighting.
     */
    static Pokemon secondPokemon;

    /**
     * Input scanner. Use this to take in user's input for buildPokemon(). <br>
     * Useful functions: next(), nextInt() .
     */
    static Scanner myScan;

    /**
     * We are now reimplementing this to meet our new Pokemon specifications. <br>
     * The process will still be the same for getting the information from the user,
     * but now we are adding the feature where the user can pick what TYPE of
     * Pokemon we are going to battle.
     *
     * How we will build our Pokemon to battle.
     * <p>
     * Have the user select from a list of 3 different types of Pokemon.
     * <p>
     * Obtain user input to set Pokemon's member variables
     * <p>
     * Requirements we should check the user for: <br>
     * - The type of Pokemon is 1 of the 3 choices <br>
     * - Hit points are between 1 and MAX_HIT_POINTS <br>
     * - No more than 50 points are split between attack level and defense leve <br>
     * - Attack level and defense level must have at least 1 point each <br>
     * Example of how this will look to the user:
     * <p>
     * Select from the following Pokemon types: <br>
     * 1 - Electric Pokemon <br>
     * 2 - Fire Pokemon <br>
     * 3 - Water Pokemon <br>
     * 1 <br>
     * Please name your Pokemon: Pikachu <br>
     * How many hit points will it have? (1-50): 50 <br>
     * Split fifty points between attack level and defense level <br>
     * Enter your attack level (1-49): 47 <br>
     * Enter your defense level (1-3): 3 <br>
     * <br>
     * Example of checking for bad input: <br>
     * <br>
     * Select from the following Pokemon types: <br>
     * 1 - Electric Pokemon <br>
     * 2 - Fire Pokemon <br>
     * 3 - Water Pokemon <br>
     * 4 <br>
     * Sorry, you must pick either 1, 2, or 3. <br>
     * Select from the following Pokemon types: <br>
     * 1 - Electric Pokemon <br>
     * 2 - Fire Pokemon <br>
     * 3 - Water Pokemon <br>
     * 0 <br>
     * Sorry, you must pick either 1, 2, or 3. <br>
     * Select from the following Pokemon types: <br>
     * 1 - Electric Pokemon <br>
     * 2 - Fire Pokemon <br>
     * 3 - Water Pokemon <br>
     * 2 <br>
     * Please name your Pokemon: Fireboi <br>
     * How many hit points will it have? (1-50): 0 <br>
     * Sorry. Hit points must be between 1 and 50: 55 <br>
     * Sorry. Hit points must be between 1 and 50: 50 <br>
     * Split fifty points between attack level and defense level <br>
     * Enter your attack level (1-49): -10 <br>
     * Sorry. The attack level must be between 1 and 49: 73 <br>
     * Sorry. The attack level must be between 1 and 49: 27 <br>
     * Enter your defense level (1-23): 24 <br>
     * Sorry. The defense level must be between 1 and 23: 23
     *
     * @return tempPokemon - the Pokemon we built and are going to set our fighting Pokemon to <br>
     *         (Look, we can return objects too!)
     *         <p>
     */
    public static Pokemon buildPokemon() {
        Pokemon returnPokemon = null;
        return returnPokemon;
    }

    /**
     * Prints who is ahead.
     * <p>
     * Compares the two Pokemon to see if there's a tie, or if a pokemon is currently winning.
     * <p>
     * Example: <br>
     * Fire has 41 hit points <br>
     * Dolphin has 44 hit points <br>
     * <br>
     * Print "Dolphin is currently ahead!"
     * <p>
     * You do not need to modify this function again.
     */
    public static void printWhoIsAhead() {
        if (firstPokemon.getHitPoints() > secondPokemon.getHitPoints()) {
            System.out.println(firstPokemon.getName() + " is currently ahead!");
        } else if (secondPokemon.getHitPoints() > firstPokemon.getHitPoints()) {
            System.out.println(secondPokemon.getName() + " is currently ahead!");
        } else {
            System.out.println("It's currently a tie!");
        }
    }

    /**
     * Prints out the overall winner of the battle.
     * <p>
     * This will only be called if there is not a tie, so you don't need to worry about this case.
     * <p>
     * You do not need to modify this function.
     */
    public static void determineWinner() {
        if (firstPokemon.getHitPoints() <= 0) {
            System.out.println(secondPokemon.getName() + " is the winner!");
        } else {
            System.out.println(firstPokemon.getName() + " is the winner!");
        }
    }

    /**
     * Initializes the member Pokemons.
     * <p>
     * You do not need to modify this function.
     */
    public static void initializePokemon() {
        System.out.println("Player 1, build your Pokemon!");
        System.out.println("=================");
        firstPokemon = buildPokemon();

        System.out.println("");

        System.out.println("Player 2, build your Pokemon!");
        System.out.println("==================");
        secondPokemon = buildPokemon();
    }

    /**
     * Determines the order of which Pokemon will go first.
     * <p>
     * Uses a 2-sided die to roll for first.
     * <p>
     * You do not need to modify this function.
     */
    public static void determineOrder() {
        /*
         * Use random throw to decide ordering.
         */
        final Dice d2 = new Dice(2);
        System.out.println("\nPlayer 1 will roll a D2, to decide who goes first.");
        final int firstTurn = d2.roll();
        System.out.print("Player 1 rolls a " + firstTurn + " and will go ");
        if (firstTurn == 1) {
            System.out.print("first");
        } else {
            /*
             * Swap Pokemon for second outcome.
             */
            System.out.print("second");
            Pokemon tempPokemon = new Pokemon();
            tempPokemon = firstPokemon;
            firstPokemon = secondPokemon;
            secondPokemon = tempPokemon;
        }
    }
    /**
     * Just a simple menu printer for the types of Pokemon
     * so we don't clutter other functions printing it over and over. <p>
     * You do not need to modify this function.
     */
    public static void printTypeMenu() {
       System.out.println("Select from the following Pokemon types: ");
       System.out.println("1 - Electric Pokemon ");
       System.out.println("2 - Fire Pokemon");
       System.out.println("3 - Water Pokemon");

    }
    /**
     * Conducts the Pokemon battle.
     * <p>
     * You do not need to modify this function.
     *
     * @param unused unused input arguments.
     */
    public static void main(final String[] unused) {
        myScan = new Scanner(System.in);
        initializePokemon();
        determineOrder();
        System.out.println("");
        boolean ifWinner = false;

        /*
         * Let the battle begin!
         */
        for (int i = 0; i < MAX_NUM_ROUNDS && !ifWinner; i++) {
            System.out.println("");
            System.out.println("Round " + (i + 1) + "!");
            System.out.println("");

            ifWinner = firstPokemon.attack(secondPokemon);
            if (!ifWinner) {
                ifWinner = secondPokemon.attack(firstPokemon);
                if (!ifWinner) {
                    printWhoIsAhead();
                }

            }
        }
        System.out.println("");

        if (!ifWinner) {
            System.out.println("It's a tie!");
        } else {
            determineWinner();
        }

        myScan.close();
    }
}
