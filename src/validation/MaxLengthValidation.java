package validation;

/**
 * Class used to store validation rule information to validate the maximum length of user input.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class MaxLengthValidation implements ValidationRule
{

    private int maxLength;

    /**
     * Default constructor which creates the object of the class MaxLengthValidation.
     *
     */
    public MaxLengthValidation()
    {
        this.maxLength = 0;
    }

    /**
     * Non-default constructor which creates the object of the class MaxLengthValidation.
     *
     * @param maxLength         Accepts the maximum length a string can be to pass the validation rule as an integer.
     */
    public MaxLengthValidation(int maxLength)
    {
        this.maxLength = maxLength;
    }

    /**
     * Accessor method to get the maximum length applied in the validation.
     *
     * @return                   The maximum length a string can be to pass the validation rule as an integer.
     */
    public int getMaxLength()
    {
        return this.maxLength;
    }

    /**
     * Returns the string to be displayed to the user if input does not pass validation.
     *
     * @return                  The validation failure message as a string.
     */
    public String getValidationFailureString()
    {
        return "not be longer than " + maxLength + " characters";
    }


    /**
     * Validates whether user input meets the maximum length requirement of the validation rule.
     *
     * @param   userInput   Accepts the user input to validate as a string.
     * @return              Whether or not the user input passes valiadtion as a boolean value.
     */
    public boolean validate(String userInput)
    {
        return userInput.length() <= this.maxLength;
    }

}