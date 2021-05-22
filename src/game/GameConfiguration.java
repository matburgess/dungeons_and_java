package game;

import utility.ConfigurationLoader;
import utility.File;
import utility.Input;
import utility.RNG;
import validation.RuleSet;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.Collections;

/**
 * Class which stores the configuration items for a game.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class GameConfiguration
{

    private ArrayList<Monster> validMonsters;
    private HashMap<String, DifficultyLevel> validDifficulties;
    private DifficultyLevel selectedDifficultyLevel;
    private int dungeonLength;

    /**
     * Default constructor which creates an object of the GameConfiguration class.
     *
     */
    public GameConfiguration()
    {
        this.validMonsters = new ArrayList<Monster>();
        this.validDifficulties = new HashMap<String, DifficultyLevel>();
        this.selectedDifficultyLevel = null;
        this.dungeonLength = 0;
    }

    /**
     * Initialise the configuration for the game.
     *
     */
    public void initialiseConfiguration()
    {
        ConfigurationLoader configLoader = new ConfigurationLoader(this);
        configLoader.loadConfigurations();

        Player newPlayer = initialisePlayer();
        initialiseDifficulty(newPlayer);
        System.out.println("Waking up the monsters lurking in the dark...\n");

        Game.getGame().setPlayer(newPlayer);
        Game.getGame().setGameConfiguration(this);
    }

    /**
     * Calculate the length of the dungeon in the game.
     *
     */
    public void calculateDungeonLength()
    {
        int minDungeonLength = selectedDifficultyLevel.getMinDungeonLength();
        int maxDungeonLength = selectedDifficultyLevel.getMaxDungeonLength();
        int dungeonLength = RNG.getRandomNumber(minDungeonLength, maxDungeonLength);
        setDungeonLength(dungeonLength);
    }

    /**
     * Accessor method to get the dungeon length.
     *
     * @return                          The length of the dungeon as an integer.
     */
    public int getDungeonLength()
    {
        return this.dungeonLength;
    }

    /**
     * Get the maximum number of monsters a player can encounter for the selected difficulty level.
     *
     * @return                          The maximum number of monsters a player can encounter as an integer.
     */
    public int getMaximumMonsterEncounters()
    {
        return this.selectedDifficultyLevel.getMaxMonsterEncounters();
    }

    /**
     * Get the name of the selected difficulty level.
     *
     * @return                          The name of the selected difficulty level as a string.
     */
    public String getSelectedDifficulty()
    {
        return this.selectedDifficultyLevel.getDifficulty();
    }

    /**
     * Accessor method to get the selected difficulty level for the game.
     *
     * @return                          The selected difficulty level as a DifficultyLevel object.
     */
    public DifficultyLevel getSelectedDifficultyLevel()
    {
        return this.selectedDifficultyLevel;
    }

    /**
     * Get a specific DifficultyLevel from the list of valid game difficulties.
     *
     * @param difficultyLevel           Accepts the dungeon difficulty level as a string.
     * @return                          The specific difficulty level as a DifficultyLevel object.
     */
    public DifficultyLevel getSpecificDifficultyLevel(String difficultyLevel)
    {
        return validDifficulties.get(difficultyLevel);
    }

    /**
     * Accessor method to get the valid difficulty levels for the game, sorted by minimum dungeon length.
     *
     * @return                          The valid difficulties for the game in an array list of DifficultyLevel objects.
     */
    public ArrayList<DifficultyLevel> getValidDifficulties()
    {
        ArrayList<DifficultyLevel> difficulties = new ArrayList<DifficultyLevel>(validDifficulties.values());
        Collections.sort(difficulties, (dl1, dl2) -> dl1.getMinDungeonLength() - dl2.getMinDungeonLength());
        return difficulties;
    }

    /**
     * Accessor method to get the valid monsters for the game.
     *
     * @return                          The valid monsters for the game in an array list of Monster objects.
     */
    public ArrayList<Monster> getValidMonsters()
    {
        return this.validMonsters;
    }

    /**
     * Initialise the game difficulty.
     *
     * @param player                    Accepts the player playing the game as a Player object.
     */
    public void initialiseDifficulty(Player player)
    {
        String selectedDifficultyString = requestDifficultyLevel();
        setSelectedDifficultyLevel(selectedDifficultyString);

        setStartingInventory(player);
        calculateDungeonLength();
    }

    /**
     * Initialise a player for the game.
     *
     * @return                          The initialised player as a Player object.
     */
    public Player initialisePlayer()
    {
        Player player = new Player();
        player.requestPlayerName();
        return player;
    }

    /**
     * Request the player to select a difficulty level configuration for the game.
     *
     * @return                          The selected difficulty as a string.
     */
    public String requestDifficultyLevel()
    {
        System.out.println("\nThe game has a number of difficulty settings that determine how tough a test you'll face:");
        for (DifficultyLevel difficulty : getValidDifficulties())
        {
            System.out.println("\t" + difficulty.display());
        }

        String selectedDifficulty = Input.getValidInput("Select your difficulty level", RuleSet.DIFFICULTY);

        return selectedDifficulty;
    }

    /**
     * Mutator method to set dungeon length.
     *
     * @param dungeonLength             Accepts the dungeon length as an integer.
     */
    public void setDungeonLength(int dungeonLength)
    {
        this.dungeonLength = dungeonLength;
    }

    /**
     * Mutator method to set the selected difficulty level for the game.
     *
     * @param difficultyLevel           Accepts the dungeon difficulty level as a DifficultyLevel object.
     */
    public void setSelectedDifficultyLevel(DifficultyLevel difficultyLevel)
    {
        this.selectedDifficultyLevel = difficultyLevel;
    }

    /**
     * Set the dungeon difficulty from a string.
     *
     * @param difficultyLevel           Accepts the dungeon difficulty level as a string.
     */
    public void setSelectedDifficultyLevel(String difficultyLevel)
    {
        this.selectedDifficultyLevel = getSpecificDifficultyLevel(difficultyLevel);
    }

    /**
     * Set the starting inventory for a player.
     *
     * @param player                    The player to set the starting inventory for as a Player object.
     */
    public void setStartingInventory(Player player)
    {
        System.out.println("\nHanding out some items from the armoury...");
        player.addInventoryItems(Item.POTION, selectedDifficultyLevel.getStartingPotions());
    }

    /**
     * Mutator method to set the valid difficulty levels for the game.
     *
     * @param validDifficulties         The valid difficulties for the game in an array list of DifficultyLevel objects.
     */
    public void setValidDifficulties(ArrayList<DifficultyLevel> validDifficulties)
    {
        HashMap<String, DifficultyLevel> difficulties = new HashMap<String, DifficultyLevel>();
        for (DifficultyLevel difficulty : validDifficulties)
        {
            difficulties.put(difficulty.toString(), difficulty);
        }
        this.validDifficulties = difficulties;
    }

    /**
     * Mutator method to set the valid difficulty levels for the game.
     *
     * @param validDifficulties         The valid difficulties for the game and their text descriptions as a hashmap.
     */
    public void setValidDifficulties(HashMap<String, DifficultyLevel> validDifficulties)
    {
        this.validDifficulties = validDifficulties;
    }

    /**
     * Mutator method to set the valid monsters for the game.
     *
     * @param validMonsters             The valid monsters for the game in an array list of Monster objects.
     */
    public void setValidMonsters(ArrayList<Monster> validMonsters)
    {
        this.validMonsters = validMonsters;
    }

}