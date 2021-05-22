package utility;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;

/**
 * Class to interact with files in the file system.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class FileIO
{

    /**
     * Default constructer which creates an object of the FileIO class.
     *
     */
    public FileIO()
    {
    }

    /**
     * Read the contents of a file.
     *
     * @param fileName               Accepts the name of the file to read as a string.
     * @return                       The file contents as a string.
     */
    public static String readFile(String fileName)
    {
        StringBuffer fileContent = new StringBuffer();
        FileReader reader = null;
        try
        {
            reader = new FileReader(fileName);
            Scanner fileInput = new Scanner(reader);

            while (fileInput.hasNextLine())
            {
                fileContent.append(fileInput.nextLine());
                fileContent.append("\n");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not find file " + fileName + ". The file is critical to game functioning. Please create the file with valid data and restart the application.");
            System.exit(1);
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (Exception e)
            {
                System.out.println("Error reading from file: " + e.toString());
            }
        }

        return fileContent.toString();

    }

    /**
     * Write to a file.
     *
     * @param file                   Accepts the file to write to as a File object.
     * @param fileContents           Accepts the contents to write to file as a string.
     */
    public static void writeFile(File file, String fileContents)
    {
        try
        {
            FileWriter writer = new FileWriter(file.getFileName(), true);
            try
            {
                writer.append(fileContents);
            }
            catch (Exception e)
            {
                System.out.println("Error writing to file.");
            }
            finally
            {
                try
                {
                    writer.close();
                }
                catch (Exception e)
                {
                    System.out.println("Could not close file: " + e);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error writing to file.");
        }
    }
}