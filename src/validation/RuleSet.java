package validation;

import utility.File;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation of rulesets available for validation of a user input.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public enum RuleSet
{

    NAME(new StringLengthValidation(3, 12), new NotAllWhitespaceValidation()),
    CHOICE(new YesOrNoValidation()),
    DIFFICULTY(new DifficultyValidation());

    private ArrayList<ValidationRule> validationRules;

    /**
     * Default constructor for the representation of a RuleSet.
     *
     */
    RuleSet()
    {
        this.validationRules = new ArrayList<ValidationRule>();
    }

    /**
     * Default constructor for the representation of a RuleSet.
     *
     * @param validations               Accepts the validation rules applied by the ruleset.
     */
    RuleSet(ValidationRule... validationRules)
    {
        this.validationRules = new ArrayList<ValidationRule>();
        for (ValidationRule rule : validationRules)
        {
            this.validationRules.add(rule);
        }
    }

    /**
     * Accessor method to get the validation rules contained in the ruleset.
     *
     * @return                          The validation rules in the ruleset as an array of validation rule objects.
     */
    public ArrayList<ValidationRule> getValidationRules()
    {
        return this.validationRules;
    }

    /**
     * Return string representation of the RuleSet
     *
     * @return                          The string representation of the ruleset.
     */
    public String toString()
    {
        return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
    }

}