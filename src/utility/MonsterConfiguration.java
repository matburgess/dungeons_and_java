package utility;

import game.Monster;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to parse monster configuration from a file.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class MonsterConfiguration extends Parser<Monster>
{

    /**
     * Default constructor that creates an object of the MonsterConfiguration class.
     *
     */
    public MonsterConfiguration()
    {
        super();
    }

    /**
     * Non-default constructor that creates an object of the MonsterConfiguration class.
     *
     * @param file                  Accepts the file the configuration is stored in as a File object.
     */
    public MonsterConfiguration(File file)
    {
        super(file);
    }

    /**
     * Parse the monster configurations from the configuration file.
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

                String monsterName = line[0];

                int monsterHealth = 0;
                int monsterMinDamage = 0;
                int monsterMaxDamage = 0;

                String exceptionValue = "Invalid monster %s in " + file + " on line %d. ERROR: %s. Skipping line.\n";
                try
                {
                    monsterHealth = Integer.parseInt(line[1]);
                }
                catch (Exception e)
                {
                    System.out.printf(exceptionValue, "health", (i + 1), e.toString());
                    continue;
                }
                try
                {
                    monsterMinDamage = Integer.parseInt(line[2]);
                }
                catch (Exception e)
                {
                    System.out.printf(exceptionValue, "minimum damage", (i + 1), e.toString());
                    continue;
                }
                try
                {
                    monsterMaxDamage = Integer.parseInt(line[3]);
                }
                catch (Exception e)
                {
                    System.out.printf(exceptionValue, "maximum damage", (i + 1), e.toString());
                    continue;
                }
                configurations.add(new Monster(monsterName, monsterHealth, monsterMinDamage, monsterMaxDamage));
            }
        }
        catch (Exception e)
        {
            System.out.println("Unknown error while reading file " + file + ". ERROR: " + e + ". Could not load configuration. Please fix the file and try restarting the applicaiton.");
            System.exit(1);
        }
    }

}