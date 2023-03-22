/**
 * Our specialty ElectricPokemon that inherits from our Pokemon class.
 */
public class ElectricPokemon extends Pokemon {
    /**
     * The value we will be setting our specialty probability to.
     */
    final double specProb = 0.2;
    /**
     * We now have a specialty attack for the electric pokemon! Thunderbolt attack!
     */
    public String specialtyAttack;
    /**
     * The probability that we execute the specialty attack.
     */
    public double specialtyProbability;

    /**
     * Our ElectricPokemon constructor.
     * Constructs a new ElectricPokemon with the Pokemon Type of electric.
     * ElectricPokemon's specialty attack is THUNDERBOLT
     */
    public ElectricPokemon() {
        pokeType = PokemonType.ELECTRIC;
        specialtyAttack = "THUNDERBOLT";
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
     *  - The type of the opponent pokemon is not ELECTRIC <br>
     *  - The probability of the specialty attack is greater than
     *    the next random value <br>
     *  - We should print out the specialty attack used <br>
     *  - Opponent's HP goes to 0 <br>
     *  - Returns true that the opponent has been defeated and game is over <br>
     *
     * Hint: Math.random() is static, or you can use the random import <br>
     *
     *
     * Example of a specialty attack hitting:
     * Pikachu is attacking Bubba <br>
     * Pikachu rolls an attack bonus of 6 <br>
     * Bubba rolls a defense bonus of 13 <br>
     * The attack missed! <br>
     *
     * Pikachu executes a specialty attack... THUNDERBOLT!!! <br>
     * Bubba has been defeated! <br>
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
