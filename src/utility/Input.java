package utility;

import validation.RuleSet;
import validation.Validator;

import java.util.Scanner;

/**
 * Class to read input from the user entered to the console.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Input
{

    /**
     * Default constructer which creates an object of the Input class.
     *
     */
    public Input()
    {
    }

    /**
     * Class method which accepts input from the user.
     *
     * @return                   User input as a string.
     */
    public static String acceptStringInput()
    {
        Scanner inputReader = new Scanner(System.in);
        String userInput = inputReader.nextLine();
        quitEntered(userInput);
        return userInput;
    }

    /**
     * Class method that prompts the user to continue the game by pressing enter.
     *
     */
    public static void enterToContinue()
    {
        System.out.println("Press ENTER to continue.");
        String userInput = acceptStringInput();
        quitEntered(userInput);
    }

    /**
     * Class method that prompts the user to enter input until a valid input is received.
     *
     * @param msg                 Accepts the message to prompt the user as a string.
     * @param ruleSet             Accepts the ruleset used to validate the user input as a string.
     * @return                    The validated user input as a string.
     */
    public static String getValidInput(String msg, RuleSet ruleSet)
    {
        String userInput;
        boolean validInput = false;
        do {
            System.out.print(msg + " > ");
            userInput = acceptStringInput();
            validInput = Validator.validateRuleSet(userInput, ruleSet);
        } while (!validInput);

        return userInput;
    }

    /**
     * Class method to determine if a string matches the syntax for a 'yes' answer.
     *
     * @param userInput           Accepts the string to check.
     * @return                    Whether or not the user input matches the syntax for a 'yes' answer.
     */
    public static boolean isYes(String userInput)
    {
        String yesSyntax = "^y\\w+|^y$";
        return userInput.toLowerCase().matches(yesSyntax);
    }

    /**
     * Class method to determine if a user requested to quit the game.
     *
     * @param userInput           Accepts the string entered by the user to check for the quit command.
     */
    public static void quitEntered(String userInput)
    {
        String quitSyntax = "^quit|^q$";
        if (userInput.toLowerCase().matches(quitSyntax))
        {
            String userChoice = getValidInput("\nAre you sure you want to quit?\nYour game results will not be saved.", RuleSet.CHOICE);
            if (isYes(userChoice))
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }
    }

}