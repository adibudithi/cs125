/**
 * Our specialty FirePokemon that inherits from our Pokemon class.
 */
public class FirePokemon extends Pokemon {
    /**
     * The value we will be setting our specialty probability to.
     */
    final double specProb = 0.2;
    /**
     * We now have a specialty attack for the fire pokemon! Flame thrower attack!
     */
    public String specialtyAttack;
    /**
     * The probability that we execute the specialty attack.
     */
    public double specialtyProbability;

    /**
     * Our FirePokemon constructor.
     * Constructs a new FirePokemon with the Pokemon Type of fire.
     * FirePokemon's specialty attack is FLAME THROWER
     */
    public FirePokemon() {
        pokeType = PokemonType.FIRE;
        specialtyAttack = "FLAME THROWER";
        specialtyProbability = specProb;
    }

    /**
     * We have to modify our attack slightly to account for our new specialty attacks.
     * We will first have a normal attack that we're used to with our normal Pokemon.
     * Then, if the normal attack wasn't already fatal, we check to see if the Pokemon can
     * execute a fatal specialty attack to immediately win the game.
     * <p>
     * Requirements for a specialty attack: <br>
     *  - The normal attack wasn't already fatal <br>
     *  - The type of the opponent pokemon is not FIRE <br>
     *  - The probability of the specialty attack is greater than
     *    the next random value <br>
     *  - We should print out the specialty attack used <br>
     *  - Opponent's HP goes to 0 <br>
     *  - Returns true that the opponent has been defeated and game is over <br>
     *
     * Hint: Math.random() is static, or you can use the random import <br>
     *
     * Example of a specialty attack hitting: <br>
     * fireboi is attacking Pikachu <br>
     * fireboi rolls an attack bonus of 6 <br>
     * Pikachu rolls a defense bonus of 13 <br>
     * The attack missed! <br>
     *
     * fireboi executes a specialty attack... FLAME THROWER!!! <br>
     * Pikachu has been defeated! <br>
     *
     * @param opponent the Pokemon to attack
     * @return whether or not the game has ended
     *
     * Implement this.
     */
    public boolean attack(final Pokemon opponent) {
        return false;
    }

}
