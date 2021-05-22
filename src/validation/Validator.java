package validation;

import java.util.ArrayList;

/**
 * Class which creates a validator that can be used to validate user input against specified validation rules.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Validator
{

    /**
     * Default constructor which creates the object of the class Validator.
     *
     */
    public Validator()
    {

    }

    /**
     * Class method to display validation failure messages for the input entered by the user.
     *
     * @param ruleSet                   Accepts the rule set applied to the user input as a RuleSet object.
     * @param validationFailureMessages Accepts the validation failure messages as an array list of strings.
     */
    public static void printValidationFailureMessages(RuleSet ruleSet, ArrayList<String> validationFailureMessages)
    {
        String validationMessages = String.join(" and ", validationFailureMessages);
        System.out.println(ruleSet + " must " + validationMessages);
    }

    /**
     * Class method to validate user input against a validation rule.
     *
     * @param userInput                 Accepts the user input to validate as a string.
     * @param validationRule            Accepts a single validation rule to validate the string against.
     * @return                          Whether or not the user input passes the validation rule as a boolean value.
     */
    public static boolean validateRule(String userInput, ValidationRule validationRule)
    {
        return validationRule.validate(userInput);
    }

    /**
     * Class method to return validation failure messages for the user input.
     *
     * @param userInput                 Accepts the user input to validate as a string.
     * @param validationRules           Accepts an array list of validation rules to validate the string against.
     * @return                          Validation failure messages for the user input validated against the list of validation rules.
     */
    public static ArrayList<String> validateRules(String userInput, ArrayList<ValidationRule> validationRules)
    {
        ArrayList<String> errorMessages = new ArrayList<String>();
        for (ValidationRule validationRule : validationRules)
        {
            if (!validateRule(userInput, validationRule))
            {
                errorMessages.add(validationRule.getValidationFailureString());
            }
        }
        return errorMessages;
    }

    /**
     * Class method to determine whether or not a user input meets validation requirements.
     *
     * @param userInput                 Accepts the user input to validate as a string.
     * @param ruleSet                   Accepts the ruleset to be applied to the string, as RuleSet object.
     * @return                          Whether or not the user input passes the all validation rules within the specified ruleset.
     */
    public static boolean validateRuleSet(String userInput, RuleSet ruleSet)
    {
        ArrayList<String> validationFailureMessages = validateRules(userInput, ruleSet.getValidationRules());
        if (validationFailureMessages.size() > 0)
        {
            printValidationFailureMessages(ruleSet, validationFailureMessages);
            return false;
        }
        return true;
    }

}