package validation;

/**
 * A rule used when validating user input.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public interface ValidationRule
{

    public boolean validate(String userInput);
    public String getValidationFailureString();

}