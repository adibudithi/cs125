/**
 * Class that implements a Pokemon.
 * <p>
 * Let's play Pokemon! This is our Pokemon class. Each Pokemon has several member variables that
 * make it a Pokemon. Each Pokemon has:
 * <ul>
 * <li>a name</li>
 * <li>a number of hit points that decrement as the game continues</li>
 * <li>up to 50 points to split between attack and defense</li>
 * <li>a 6-sided dice for calculating attack damage</li>
 * <li>a 20-sided die for calculating attack bonuses and defense bonuses</li>
 * </ul>
 * <p>
 * Have a look through the Pokemon file to see how we can construct objects, can use member
 * variables of these objects, and use objects of the same type to make our game.
 */
public class Pokemon {

    /**
     * We now have 3 more sophisticated Pokemon types
     * that we should differentiate between.
     */
    public enum PokemonType {
        /**
         * Electric pokemon.
         */
        ELECTRIC,
        /**
         * Fire pokemon.
         */
        FIRE,
        /**
         * Water pokemon.
         */
        WATER
    }
    /**
     * The Pokemon type we are dealing with.
     */
    public PokemonType pokeType;

    /**
     * Number of hit points this Pokemon has.
     * <p>
     * Hit points can be initialized to between 1 and 50 and decrement as the game plays. The game
     * will end once hitPoints drops below 1.
     */
    private int hitPoints;

    /**
     * This Pokemon's attack level.
     * <p>
     * Users have up to 50 points to split between attack level and defense level.
     */
    private int attackLevel;

    /**
     * This Pokemon's defense level.
     * <p>
     * Users have up to 50 points to split between attack level and defense level.
     */
    private int defenseLevel;

    /**
     * This Pokemon's name.
     */
    private String name;

    /**
     * A 6 sided dice used to calculate attack damage.
     */
    public Dice d6;

    /**
     * A 20 sided dice used to calculate the attack and defense bonuses during an attack.
     */
    public Dice d20;

    /**
     * Create a new Pokemon with default values.
     * <p>
     * Constructs a new Pokemon with a 6-sided die, 20-sided die, 0 hit points, attack level of 0,
     * defense level of 0, and an empty name.
     */
    public Pokemon() {
        final int d6num = 6;
        final int d20num = 20;
        this.d6 = new Dice(d6num);
        this.d20 = new Dice(d20num);
        this.hitPoints = 0;
        this.attackLevel = 0;
        this.defenseLevel = 0;
        this.name = "";
    }

    /**
     * Get the attack level of the pokemon.
     * @return attackLevel the attack level of the pokemon
     */
    public int getAttackLevel() {
        return attackLevel;
    }
    /**
     * Sets the attack level to the parameter attackLvl.
     * @param attackLvl the attack level to set our Pokemon's attack level to
     */
    public void setAttackLevel(final int attackLvl) {
        this.attackLevel = attackLvl;
    }
    /**
     * Get the defense level of the pokemon.
     * @return defenseLevel the defense level of the pokemon
     */
    public int getDefenseLevel() {
        return defenseLevel;
    }
    /**
     * Sets the defense level to the parameter defenseLvl.
     * @param defenseLvl the defense level to set our Pokemon's defense level to
     */
    public void setDefenseLevel(final int defenseLvl) {
        this.defenseLevel = defenseLvl;
    }
    /**
     * Get the hit points of the pokemon.
     * @return hitPoints the hit points of the pokemon
     */
    public int getHitPoints() {
        return this.hitPoints;
    }
    /**
     * Sets the hit points to the parameter HP.
     * @param hp the hit points to set our Pokemon's hit points to
     */
    public void setHitPoints(final int hp) {
        this.hitPoints = hp;
    }

    /**
     * Get the name of the pokemon.
     * @return name the name of the pokemon
     */
    public String getName() {
        return this.name;
    }
    /**
     * Sets the name to the parameter theName.
     * @param theName the name to set our Pokemon's name to
     */
    public void setName(final String theName) {
        this.name = theName;
    }



    /**
     * Attack another Pokemon.
     * <p>
     * Calling this method will cause this Pokemon to attack another Pokemon as follows:
     * <ul>
     * <li>We get the attack bonus and defense bonus.</li>
     * <li>We roll the d6 die 3 times to calculate the damage.</li>
     * <li>We then compare to see if the attack hit or missed, and see if this was a fatal
     * attack.</li>
     * </ul>
     * This is a good function to look through to see objects in action!
     *
     * @param opponent the Pokemon to attack
     * @return whether or not the game has ended
     */
    public boolean attack(final Pokemon opponent) {
        /*
         * Get the attack and defense bonuses.
         */
        int attackBonus = d20.roll();
        int defenseBonus = d20.roll();

        /*
         * Roll the damage dice and compute total damage.
         */
        int damage1 = d6.roll();
        int damage2 = d6.roll();
        int damage3 = d6.roll();
        int totalDamage = damage1 + damage2 + damage3;

        System.out.println(this.name + " is attacking " + opponent.name);
        System.out.println(this.name + " rolls an attack bonus of " + attackBonus);
        System.out.println(opponent.name + " rolls a defense bonus of " + defenseBonus);


        /*
         * Did our attack hit?
         */
        if ((attackLevel + attackBonus) > (opponent.defenseLevel + defenseBonus)) {
            System.out.println("The attack hits dealing 3-D6 damage!");
            System.out.println("The rolls are " + damage1 + ", " + damage2 + ", " + "and "
                    + damage3 + " totaling: " + totalDamage + " damage!");

            /*
             * Does opponent have hit points left?
             */
            if ((opponent.hitPoints - totalDamage) > 0) {
                System.out.println(opponent.name + " has "
                        + (opponent.hitPoints - totalDamage) + " hit points");
            } else {
                System.out.println(opponent.name + " has been defeated!");
            }
            /*
             * Set the opponents hitPoints appropriately.
             */
            opponent.hitPoints = opponent.hitPoints - totalDamage;
        } else {
            System.out.println("The attack missed!");
        }
        System.out.println(" ");
        return (opponent.hitPoints < 1);
    }

}
