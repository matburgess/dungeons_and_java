package utility;

import game.DifficultyLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to parse difficulty level configuration from a file.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class DifficultyLevelConfiguration extends Parser<DifficultyLevel>
{

    /**
     * Default constructor that creates an object of the DifficultyLevelConfiguration class.
     *
     */
    public DifficultyLevelConfiguration()
    {
        super();
    }

    /**
     * Non-default constructor that creates an object of the DifficultyLevelConfiguration class.
     *
     * @param file                  Accepts the file the configuration is stored in as a File object.
     */
    public DifficultyLevelConfiguration(File file)
    {
        super(file);
    }

    /**
     * Parse the difficulty level configurations from the configuration file.
     *
     */
    public void parseConfigurations()
    {
        try
        {
            String fileContents = readConfigurationFile();

            String[] fileLines = fileContents.split("\n");

            for (int i = 0; i < fileLines.length; i++)
            {
                String[] line = fileLines[i].split(",");

                String difficulty = line[0];
                String textDescription = line[5];

                int minDungeonLength = 0;
                int maxDungeonLength = 0;
                int startingPotions = 0;
                int maxMonsterEncounters = 0;

                String exceptionValue = "Invalid %s in " + file + " on line %d. ERROR: %s. Skipping line.\n";

                try
                {
                    minDungeonLength = Integer.parseInt(line[1]);
                }
                catch (Exception e)
                {
                    System.out.printf(exceptionValue, "minimum dungeon length", (i + 1), e.toString());
                    continue;
                }

                try
                {
                    maxDungeonLength = Integer.parseInt(line[2]);
                }
                catch (Exception e)
                {
                    System.out.printf(exceptionValue, "maximum dungeon length", (i + 1), e.toString());
                    continue;
                }

                try
                {
                    startingPotions = Integer.parseInt(line[3]);
                }
                catch (Exception e)
                {
                    System.out.printf(exceptionValue, "starting potions", (i + 1), e.toString());
                    continue;
                }

                try
                {
                    maxMonsterEncounters = Integer.parseInt(line[4]);
                }
                catch (Exception e)
                {
                    System.out.printf(exceptionValue, "maximum monster encounters", (i + 1), e.toString());
                    continue;
                }

                this.configurations.add(new DifficultyLevel(difficulty, minDungeonLength, maxDungeonLength, startingPotions, maxMonsterEncounters, textDescription));
            }
        }
        catch (Exception e)
        {
            System.out.println("Unknown error while reading file " + file + ". ERROR: " + e + ". Could not load configuration. Please fix the file and try restarting the applicaiton.");
            System.exit(1);
        }
    }

}