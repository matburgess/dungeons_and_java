package utility;

import java.util.Map;
import java.util.HashMap;

/**
 * Generic class which randomly selects an object from a list of possibilities based on a defined probability.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class CumulativeProbability<T>
{

    private Map<T, Integer> possibilities;

    /**
     * Default constructor which creates the object of the CumulativeProbability class.
     *
     */
    public CumulativeProbability()
    {
        this.possibilities = new HashMap<T, Integer>();
    }

    /**
     * Non-default constructor which creates the object of the CumulativeProbability class.
     *
     * @param possibilities             Accepts the possibilities and probability of them occuring as a hash map.
     */
    public CumulativeProbability(Map<T, Integer> possibilities)
    {
        this.possibilities = possibilities;
    }

    /**
     * Randomly select an object from the list of possibilities based on their probability.
     *
     * @return                          The selected possibility as a class of the CumulativeProbability generic object.
     */
    public T getOption()
    {
        int sumOfOptions = 0;
        for (int value : possibilities.values())
        {
            sumOfOptions += value;
        }

        int randomNumber = RNG.getRandomNumber(sumOfOptions);
        int cumulativeProbability = 0;

        for (T t : possibilities.keySet())
        {
            cumulativeProbability += possibilities.get(t);

            if (randomNumber <= cumulativeProbability)
            {
                return t;
            }
        }
        return null;
    }

}