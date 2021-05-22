package utility;

import java.util.Random;

/**
 * A random number generator used to get random numbers in a range and roll dice
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class RNG
{

    /**
     * Default constructor which creates the object of the RNG class.
     *
     */
    public RNG()
    {
    }

    /**
     * Returns a random number between 1 and the specified maximum value.
     *
     * @param max               Accepts the maximum random number as an integer.
     * @return                  The randomly generated number as an integer.
     */
    public static int getRandomNumber(int max)
    {
        return getRandomNumber(1, max);
    }

    /**
     * Returns a random number between the specified minimum and maximum.
     *
     * @param min               Accepts the minimum random number as an integer.
     * @param max               Accepts the maximum random number as an integer.
     * @return                  The randomly generated number as an integer.
     */
    public static int getRandomNumber(int min, int max)
    {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Rolls a die multiple times
     *
     * @param die               Accepts a Die object to roll.
     * @param numDice           Accepts the number of times to roll the die as an integer.
     * @return                  The total rolled on all the dice rolls as an integer.
     */
    public static int rollDice(Die die, int numDice)
    {
        int diceRollTotal = 0;
        for (int i = 1; i <= numDice; i++)
        {
            diceRollTotal += rollDie(die);
        }
        return diceRollTotal;
    }

    /**
     * Rolls a die multiple times with a modifier added to the total
     *
     * @param die               Accepts a Die object to roll.
     * @param numDice           Accepts the number of times to roll the die as an integer.
     * @param modifier           Accepts the modifier to add to the total of the dice rolls as an integer.
     * @return                  The total rolled on all the dice rolls pluus a modifer, as an integer.
     */
    public static int rollDice(Die die, int numDice, int modifier)
    {
        int diceRollTotal = rollDice(die, numDice);

        return diceRollTotal + modifier;
    }

    /**
     * Rolls a single die with the number of sides specified in the input;
     *
     * @param die               Accepts a Die object to roll.
     * @return                  The number rolled on the singular die as an integer.
     */
    public static int rollDie(Die die)
    {
        Random rand = new Random();
        return rand.nextInt(die.getDieSides()) + 1;
    }

}