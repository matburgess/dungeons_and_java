package validation;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Abstract class to define the implementation of a validation rule that is the combination of other validation rules.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public abstract class CompositeValidationRule implements ValidationRule
{
    protected ArrayList<ValidationRule> validationRules;

    /**
     * Default constructor which creates the object of the class CompositeValidationRule.
     *
     */
    public CompositeValidationRule()
    {
        this.validationRules = new ArrayList<ValidationRule>();
    }

    /**
     * Get the validation failure messages for each of the rules in the comoposite rule to create a single validation failure message for the user.
     *
     * @return                  The validation failure message of composite validation rule.
     */
    public String getValidationFailureString()
    {
        StringJoiner validationFailureString = new StringJoiner(" and ");
        for (ValidationRule validation : validationRules)
        {
            validationFailureString.add(validation.getValidationFailureString());
        }
        return validationFailureString.toString();
    }

    /**
     * Accessor method to return the validation rules making up the composite validation rule.
     *
     * @return                  The validation rules making up the composite validation rule as an array list of validation rules.
     */
    public ArrayList<ValidationRule> getValidationRules()
    {
        return this.validationRules;
    }

    /**
     * Mutator method to set the validation rules making up the composite validation rule.
     *
     * @param validationRules   Accepts the validation rules that make up the composite validation rule as an array list of validation rules.
     */
    public void setValidationRules(ArrayList<ValidationRule> validationRules)
    {
        this.validationRules = validationRules;
    }

    /**
     * Validate a user input string against the validation rules making up the composite validation rule.
     *
     * @param userInput        Accepts the user input to validate as a string.
     * @return                 Whether or not the user input passes the composite valiadtion as a boolean value.
     */
    public boolean validate(String userInput)
    {
        for (ValidationRule rule : validationRules)
        {
            if (!rule.validate(userInput))
            {
                return false;
            }
        }
        return true;
    }

}