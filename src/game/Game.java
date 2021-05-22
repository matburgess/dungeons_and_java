package game;

import utility.Input;
import validation.RuleSet;

import java.util.ArrayList;

/**
 * A singleton class that stores the current game information.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Game
{
    private static final Game game = new Game();
    private Player player;
    private GameConfiguration gameConfiguration;
    private int monstersEncountered;
    private int numberOfTurns;

    /**
     * Default constructor for a singleton class that creates an object of the Game class.
     *
     */
    private Game()
    {
        this.player = null;
        this.gameConfiguration = null;
        this.monstersEncountered = 0;
        this.numberOfTurns = 0;
    }

    /**
     * Determine whether or not the player has encountered the maximum number of monsters, or whether they can encounter more.
     *
     * @return                               Whether or not a player can encounter another monster as a boolean.
     */
    public boolean canEncounterMoreMonsters()
    {
        return monstersEncountered < gameConfiguration.getMaximumMonsterEncounters();
    }

    /**
     * Evaluate whether or not the game has ended.
     *
     * @return                               Whether or not the game has ended as a boolean.
     */
    public boolean evaluateGameOver()
    {
        if (player.getPosition() >= gameConfiguration.getDungeonLength())
        {
            System.out.println("... and emerge in to fresh air! You've made it through the dungeon alive!!!");
            return true;
        }
        else if (!player.isAlive())
        {
            System.out.println("... you've been killed by the creature!!! GAME OVER");
            return true;
        }
        return false;
    }

    /**
     * Accessor method for the length of the dungeon in the game.
     *
     * @return                               The length of the dungeon as an integer.
     */
    public int getDungeonLength()
    {
        return this.gameConfiguration.getDungeonLength();
    }

    /**
     * Accessor method to return the singleton instance of the game.
     *
     * @return                               The singleton game as a Game object.
     */
    public static Game getGame()
    {
        return game;
    }

    /**
     * Accessor method to return the game configuration.
     *
     * @return                               The game configuration as a GameConfiguration object.
     */
    public GameConfiguration getGameConfiguration()
    {
        return this.gameConfiguration;
    }

    /**
     * Accessor method to return the number of turns in the game so far.
     *
     * @return                               The number of turns taken as a string.
     */
    public int getNumberOfTurns()
    {
        return this.numberOfTurns;
    }

    /**
     * Generates the game result string.
     *
     * @return                               The game result as a string.
     */
    public String getGameResultString()
    {
        boolean playerWon = player.isAlive();
        String gameResult = "";

        gameResult += player.getName() + " " + (player.isAlive() ? "WON" : "LOST") + " the game.";

        gameResult += " They played on " + gameConfiguration.getSelectedDifficulty() + ", killed " + monstersEncountered + " monsters, had " + player.getHealth() + " health remaining and were carrying the following items: " + player.getInventory().toString() + "\n";

        return gameResult;
    }

    /**
     * Accessor method to return the number of monsters already encountered during the game.
     *
     * @return                              The number of monsters encountered during the game as an integer.
     */
    public int getMonstersEncountered()
    {
        return this.monstersEncountered;
    }

    /**
     * Accessor method to return the player of the game.
     *
     * @return                              The game's player as a Player object.
     */
    public Player getPlayer()
    {
        return this.player;
    }

    /**
     * Accessor method to return the valid difficulty levels in the game.
     *
     * @return                              The game's difficulty levels as an array list of DifficultyLevel objects.
     */
    public ArrayList<DifficultyLevel> getValidDifficulties()
    {
        return this.gameConfiguration.getValidDifficulties();
    }

    /**
     * Accessor method to return the valid monsters in the game.
     *
     * @return                              The game's available monsters as an array list of Monster objects.
     */
    public ArrayList<Monster> getValidMonsters()
    {
        return this.gameConfiguration.getValidMonsters();
    }

    /**
     * Increment the number of monsters the player has encountered.
     *
     */
    public void incrementMonstersEncountered()
    {
        this.monstersEncountered++;
    }

    /**
     * Initialise the game configuration.
     *
     */
    public void initialiseGameConfiguration()
    {
        this.gameConfiguration = new GameConfiguration();
        this.gameConfiguration.initialiseConfiguration();
    }

    /**
     * Mutator method to set the game configuration.
     *
     * @param gameConfiguration             Accepts a game configuration as a GameConfiguration object.
     */
    public void setGameConfiguration(GameConfiguration gameConfiguration)
    {
        this.gameConfiguration = gameConfiguration;
    }

    /**
     * Mutator method to set the number of monsters encountered during the game.
     *
     * @param monstersEncountered           Accepts the number of monsters encoutnered as an integer.
     */
    public void setMonstersEncountered(int monstersEncountered)
    {
        this.monstersEncountered = monstersEncountered;
    }

    /**
     * Mutator method to set the number of turns taken in game.
     *
     * @param numberOfTurns                  Accepts the numberof turns taken in the game as an integer.
     */
    public void setNumberOfTurns(int numberOfTurns)
    {
        this.numberOfTurns = numberOfTurns;
    }

    /**
     * Mutator method to set the player of the game.
     *
     * @param player                        Accepts the player of the game as a Player object.
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    /**
     * Starts the game.
     *
     */
    public void startGame()
    {
        initialiseGameConfiguration();
        takeTurns();
    }

    /**
     * Take turns in the game.
     *
     */
    public void takeTurns()
    {

        boolean isGameOver;
        do {
            Turn nextTurn = new Turn(this.player);
            isGameOver = nextTurn.startTurn();
            numberOfTurns++;
            if (!isGameOver)
            {
                Input.enterToContinue();
            }
        } while (!isGameOver);
    }

    /**
     * Returns a string representation of the game.
     *
     * @return                      The string representation of this game
     */
    public String toString()
    {
        return player.toString();
    }

}