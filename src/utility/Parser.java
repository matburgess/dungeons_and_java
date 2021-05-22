package utility;

import java.util.ArrayList;

/**
 * A parser for a generic object read from file.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public abstract class Parser<T>
{

    protected File file;
    protected ArrayList<T> configurations;

    /**
     * Default constructor that creates an object of the DifficultyLevelConfiguration class.
     *
     */
    public Parser()
    {
        this.file = null;
        this.configurations = new ArrayList<T>();
    }

    /**
     * Non-default constructor that creates an object of the DifficultyLevelConfiguration class.
     *
     * @param file                  Accepts the file the configuration is stored in as a File object.
     */
    public Parser(File file)
    {
        this.file = file;
        this.configurations = new ArrayList<T>();
    }

    /**
     * Accessor method for the configurations read from file.
     *
     * @return                  The configurations read from file as an array list of generic object.
     */
    public ArrayList<T> getConfigurations()
    {
        return this.configurations;
    }

    /**
     * Accessor method for the configuration file.
     *
     * @return                  The configuration file as a File object.
     */
    public File getFile()
    {
        return this.file;
    }

    public abstract void parseConfigurations();

    /**
     * Get the contents of the configuration file.
     *
     * @return                  The contents of the configuration file as a string.
     */
    public String readConfigurationFile()
    {
        String fileContents = FileIO.readFile(file.getFileName());
        return fileContents;
    }

    /**
     * Mutator method to set the configurations.
     *
     * @param configurations    Accepts the configurations as an array list of DifficultyLevel objects.
     */
    public void setConfigurations(ArrayList<T> configurations)
    {
        this.configurations = configurations;
    }

    /**
     * Mutator method to set the configuration file.
     *
     * @param file              Accepts the configuration file as a File object.
     */
    public void setFile(File file)
    {
        this.file = file;
    }

}