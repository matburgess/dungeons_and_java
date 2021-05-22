package validation;

/**
 * Class used to validate input that can not be all white spaces.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class NotAllWhitespaceValidation implements ValidationRule
{

    /**
     * Default constructor which creates the object of the class YesOrNoValidation.
     *
     */
    public NotAllWhitespaceValidation()
    {
    }

    /**
     * Returns the string to be displayed to the user if input does not pass validation.
     *
     * @return              The validation failure message as a string.
     */
    public String getValidationFailureString()
    {
        return "not contain all whitespaces";
    }

    /**
     * Validates whether user input matches the defined syntax for a 'yes' or 'no' answer.
     *
     * @param   userInput   Accepts the user input to validate as a string.
     * @return              Whether or not the user input passes valiadtion as a boolean value.
     */
    public boolean validate(String userInput)
    {
        for (char character : userInput.toCharArray())
        {
            if (character != ' ')
            {
                return true;
            }
        }
        return false;
    }

}