package validation;

import game.Game;
import game.DifficultyLevel;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Class used to validate whether or not a user entered a valid difficulty level.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class DifficultyValidation implements ValidationRule
{

    /**
     * Default constructor which creates the object of the class DifficultyValidation.
     *
     */
    public DifficultyValidation()
    {
    }

    /**
     * Get the valid difficulty levels for the game.
     *
     * @return              The valid difficulties for the game as an array of DifficultyLevel objects.
     */
    public ArrayList<DifficultyLevel> getValidDifficultiesForGame()
    {
        return Game.getGame().getValidDifficulties();
    }


    /**
     * Returns the string to be displayed to the user if input does not pass validation.
     *
     * @return              The validation failure message as a string.
     */
    public String getValidationFailureString()
    {
        StringJoiner validDifficultiesString = new StringJoiner(", ");
        for (DifficultyLevel difficulty : getValidDifficultiesForGame())
        {
            validDifficultiesString.add(difficulty.toString());
        }

        return "be one of " + validDifficultiesString.toString();
    }

    /**
     * Validate whether user input matches a valid difficulty level.
     *
     * @param   userInput   Accepts the user input to validate as a string.
     * @return              Whether or not the user input passes valiadtion as a boolean value.
     */
    public boolean validate(String userInput)
    {

        for (DifficultyLevel difficulty : getValidDifficultiesForGame())
        {
            if (userInput.equalsIgnoreCase(difficulty.toString()))
            {
                return true;
            }
        }
        return false;
    }

}