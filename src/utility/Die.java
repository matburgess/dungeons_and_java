package utility;

/**
 * Representation of die that can be rolled to generate values.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public enum Die
{

    D3(3), D4(4), D6(6), D10(10), D20(20), D100(100);

    private int numSides;

    /**
     * Initialise the die with the corresponding number of sides.
     *
     * @param numSides              Accepts the number of sides on the die.
     */
    Die(int numSides)
    {
        this.numSides = numSides;
    }

    /**
     * Accessor method to get the number of sides on a die.
     *
     * @return                      The number of sides on the die as an integer.
     */
    public int getDieSides()
    {
        return this.numSides;
    }
}