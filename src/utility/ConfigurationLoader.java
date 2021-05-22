package utility;

import game.DifficultyLevel;
import game.GameConfiguration;
import game.Monster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class which loads configuration items from file for a game.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class ConfigurationLoader
{

    private GameConfiguration gameConfiguration;

    /**
     * Default constructor which creates an object of the ConfigurationLoader class.
     *
     */
    public ConfigurationLoader()
    {
        this.gameConfiguration = null;
    }

    /**
     * Non-default constructor which creates an object of the ConfigurationLoader class.
     *
     * @param gameConfiguration         Accepts the game configuration to load configuraiton items to as a GameConfiguration item.
     */
    public ConfigurationLoader(GameConfiguration gameConfiguration)
    {
        this.gameConfiguration = gameConfiguration;
    }

    /**
     * Accessor method to get the game configuration.
     *
     * @return                          The game configuration configuration items are being loaded to as a GameConfiguration item.
     */
    public GameConfiguration getGameConfiguration()
    {
        return this.gameConfiguration;
    }

    /**
     * Load a specific configuration file in to the game configuration.
     *
     * @param configFile                Accepts the configuration file to load as a File object.
     */
    public void loadConfigurationFile(File configFile)
    {
        boolean nonEmpty = true;

        switch (configFile)
        {
            case MONSTERS:
                MonsterConfiguration monsterLoader = new MonsterConfiguration(configFile);
                monsterLoader.parseConfigurations();
                ArrayList<Monster> monsters = monsterLoader.getConfigurations();
                if (monsters.size() > 0)
                {
                    this.gameConfiguration.setValidMonsters(monsters);
                }
                else
                {
                    nonEmpty = false;
                }
                break;
            case DIFFICULTY:
                DifficultyLevelConfiguration difficultyLoader = new DifficultyLevelConfiguration(configFile);
                difficultyLoader.parseConfigurations();
                ArrayList<DifficultyLevel> difficulties = difficultyLoader.getConfigurations();
                if (difficulties.size() > 0)
                {
                    this.gameConfiguration.setValidDifficulties(difficulties);
                }
                else
                {
                    nonEmpty = false;
                }
                break;
            default:
                break;
        }

        if (!nonEmpty)
        {
            System.out.println(configFile.getFileName() + " contains no valid " + configFile + " configurations. Please fix this file and restart the application.");
            System.exit(1);
        }

    }

    /**
     * Loads configuration items from configuration files.
     *
     */
    public void loadConfigurations()
    {
        for (File file : File.values())
        {
            loadConfigurationFile(file);
        }
    }

    /**
     * Mutator method to set the game configuration file configuration items are loaded to.
     *
     * @param gameConfiguration         Accepts the game configuration to load configuraiton items to as a GameConfiguration item.
     */
    public void setGameConfiguration(GameConfiguration gameConfiguration)
    {
        this.gameConfiguration = gameConfiguration;
    }

}