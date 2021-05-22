package validation;

import java.util.ArrayList;

/**
 * Class used to store validation rule information to validate a user input is between specified maximum and minimum lengths.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class StringLengthValidation extends CompositeValidationRule
{

    /**
     * Default constructor which creates the object of the class StringLengthValidation.
     *
     */
    public StringLengthValidation()
    {
        super();
    }

    /**
     * Non-default constructor which creates the object of the class StringLengthValidation.
     *
     * @param minLength         Accepts the minimum length a string can be to pass the validation rule as an integer.
     * @param maxLength         Accepts the maximum length a string can be to pass the validation rule as an integer.
     */
    public StringLengthValidation(int minLength, int maxLength)
    {
        super();
        validationRules.add(new MinLengthValidation(minLength));
        validationRules.add(new MaxLengthValidation(maxLength));
    }

}