package utility;

/**
 * Representation of files available for input and output.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public enum File
{

    MONSTERS("src/config/monsters.txt"),
    DIFFICULTY("src/config/difficulty.txt"),
    OUTPUT("out/production/output.txt");

    private String fileName;

    /**
     * Initialise the file with the corresponding file name.
     *
     * @param validations               Accepts the file name as a string.
     */
    File(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Accessor method to get the file name of the file .
     *
     * @return                          The file name as a string.
     */
    public String getFileName()
    {
        return this.fileName;
    }

}