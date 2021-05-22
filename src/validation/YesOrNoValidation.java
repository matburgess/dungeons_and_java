package validation;

/**
 * Class used to validate input requiring a yes or no answer.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class YesOrNoValidation implements ValidationRule
{

    private static final String YES_OR_NO_SYNTAX = "^y\\w+|^y$|^n\\w+|^n$";

    /**
     * Default constructor which creates the object of the class YesOrNoValidation.
     *
     */
    public YesOrNoValidation()
    {
    }

    /**
     * Returns the string to be displayed to the user if input does not pass validation.
     *
     * @return              The validation failure message as a string.
     */
    public String getValidationFailureString()
    {
        return "be either \"yes\" or \"no\" .... if you're not up to typing those three little letters, \"y\" and \"n\" will work too...";
    }

    /**
     * Validates whether user input matches the defined syntax for a 'yes' or 'no' answer.
     *
     * @param   userInput   Accepts the user input to validate as a string.
     * @return              Whether or not the user input passes valiadtion as a boolean value.
     */
    public boolean validate(String userInput)
    {
        return userInput.matches(YES_OR_NO_SYNTAX);
    }

}