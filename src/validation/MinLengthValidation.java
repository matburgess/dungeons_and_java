package validation;

/**
 * Class used to store validation rule information to validate the minimum length of user input.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class MinLengthValidation implements ValidationRule
{

    private int minLength;

    /**
     * Default constructor which creates the object of the class MinLengthValidation.
     *
     */
    public MinLengthValidation()
    {
        this.minLength = 0;
    }

    /**
     * Non-default constructor which creates the object of the class MinLengthValidation.
     *
     * @param minLength         Accepts the minimum length a string can be to pass the validation rule as an integer.
     */
    public MinLengthValidation(int minLength)
    {
        this.minLength = minLength;
    }

    /**
     * Accessor method to get the minimum length applied in the validation.
     *
     * @return                   The minimum length a string can be to pass the validation rule as an integer.
     */
    public int getMinLength()
    {
        return this.minLength;
    }

    /**
     * Returns the string to be displayed to the user if input does not pass validation.
     *
     * @return                  The validation failure message as a string.
     */
    public String getValidationFailureString()
    {
        return "be at least " + minLength + " characters";
    }

    /**
     * Validates whether user input meets the minimum length requirement of the validation rule.
     *
     * @param   userInput        Accepts the user input to validate as a string.
     * @return                   Whether or not the user input passes valiadtion as a boolean value.
     */
    public boolean validate(String userInput)
    {
        return userInput.length() >= this.minLength;
    }

}