package game;

import java.lang.Comparable;

/**
 * Class which stores information of difficulty levels for the game
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class DifficultyLevel
{

    private String difficulty;
    private int minDungeonLength;
    private int maxDungeonLength;
    private int startingPotions;
    private int maxMonsterEncounters;
    private String textDescription;

    /**
     * Default constructor which creates the object of the class Difficulty.
     *
     */
    public DifficultyLevel()
    {
        this.difficulty = "unknown";
        this.minDungeonLength = -1;
        this.maxDungeonLength = -1;
        this.startingPotions = -1;
        this.maxMonsterEncounters = -1;
        this.textDescription = "unknown";
    }

    /**
     * Non-default constructor which creates the object of the class Difficulty.
     *
     * @param   difficulty              Accepts the name of the difficulty level as a string.
     * @param   minDungeonLength        Accepts the minimum length of the dungeon for the difficulty level as an integer.
     * @param   maxDungeonLength        Accepts the maximum length of the dungeon for the difficulty level as an integer.
     * @param   startingPotions         Accepts the number of starting potions for the difficulty level as an integer.
     * @param   maxMonsterEncounters    Accepts the maximum number of monster encounters the player can have as an integer.
     * @param   textDescription         Accepts the description of the level as a string.
     */
    public DifficultyLevel(String difficulty, int minDungeonLength, int maxDungeonLength, int startingPotions, int maxMonsterEncounters, String textDescription)
    {
        this.difficulty = difficulty;
        this.minDungeonLength = minDungeonLength;
        this.maxDungeonLength = maxDungeonLength;
        this.startingPotions = startingPotions;
        this.maxMonsterEncounters = maxMonsterEncounters;
        this.textDescription = textDescription;
    }

    /**
     * Get the string representation of the difficulty level along with the full description of the level.
     *
     * @return                          The string description of the difficulty level with the full description.
     */
    public String display()
    {
        String displayString = difficulty + ":\t" + textDescription + "\n\t\tYou will start with " + startingPotions + ", face a maximum of " + maxMonsterEncounters + " monsters and have to travel through a dungeon between " + minDungeonLength + " and " + maxDungeonLength + " spaces long.\n";
        return displayString;
    }

    /**
     * Accessor method to get the name of the difficulty level.
     *
     * @return                          The name of the difficulty level as a string.
     */
    public String getDifficulty()
    {
        return difficulty;
    }

    /**
     * Accessor method to get the maximum dungeon length for the difficulty level.
     *
     * @return                          The maximum length of the dungeon as an integer.
     */
    public int getMaxDungeonLength()
    {
        return maxDungeonLength;
    }

    /**
     * Accessor method to get the maximum number of monster encounters for the difficulty level.
     *
     * @return                          The maximum number of monster encounters for the dungeon as an integer.
     */
    public int getMaxMonsterEncounters()
    {
        return maxMonsterEncounters;
    }

    /**
     * Accessor method to get the minimum dungeon length for the difficulty level.
     *
     * @return                          The minimum length of the dungeon as an integer.
     */
    public int getMinDungeonLength()
    {
        return minDungeonLength;
    }

    /**
     * Accessor method to get the number of potions the player will start with for the difficulty level.
     *
     * @return                          The number of potions the player starts with as an integer.
     */
    public int getStartingPotions()
    {
        return startingPotions;
    }

    /**
     * Accessor method to get the number of potions the player will start with for the difficulty level.
     *
     * @return                          The number of potions the player starts with as an integer.
     */
    public String getTextDescription()
    {
        return textDescription;
    }

    /**
     * Mutator method to set the difficulty
     *
     * @param difficulty                Accepts the difficulty as a string.
     */
    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    /**
     * Mutator method to set the maximum dungeon length for the difficulty level.
     *
     * @param maxDungeonLength          Accepts the maximum dungeon length of the difficulty level as an integer.
     */
    public void setMaxDungeonLength(int maxDungeonLength)
    {
        this.maxDungeonLength = maxDungeonLength;
    }

    /**
     * Mutator method to set the maximum number of monsters a player can encounter for the difficulty level.
     *
     * @param maxMonsterEncounters      Accepts the maximum number of monsters a player can encounter as an integer.
     */
    public void setMaxMonsterEncounters(int maxMonsterEncounters)
    {
        this.maxMonsterEncounters = maxMonsterEncounters;
    }

    /**
     * Mutator method to set the minimum dungeon length for the difficulty level.
     *
     * @param minDungeonLength          Accepts the minimum dungeon length of the difficulty level as an integer.
     */
    public void setMinDungeonLength(int minDungeonLength)
    {
        this.minDungeonLength = minDungeonLength;
    }

    /**
     * Mutator method to set the number of potions a player starts with for the difficulty level.
     *
     * @param startingPotions          Accepts the number of potions a player starts with as an integer.
     */
    public void setStartingPotions(int startingPotions)
    {
        this.startingPotions = startingPotions;
    }

    /**
     * Mutator method to set the text description of the difficulty level.
     *
     * @param textDescription          Accepts the text description of the difficulty level as a string.
     */
    public void setTextDescription(String textDescription)
    {
        this.textDescription = textDescription;
    }

    /**
     * Return string representation of the difficulty level without the full description.
     *
     * @return                          The string representation of the difficulty level.
     */
    public String toString()
    {
        return difficulty;
    }

}