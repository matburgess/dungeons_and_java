package game;

import utility.Input;
import validation.RuleSet;

/**
 * Class used to interact with the player when choices are available to them.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class MakeChoice
{

    /**
     * Default constructor which creates the object of the class MakeChoice.
     *
     */
    public MakeChoice()
    {
    }

    /**
     * Class method to determine the quantity of an item to pick up.
     * Allows picking up less than the number found if there is not capacity ina  player's inventory for all of them.
     *
     * @param inventoryCapacity                     Accepts the remaining inventory capacity as an integer.
     * @param numberOfItemsFound                    Accepts the number of items found as an integer.
     * @return                                      The number of items a player can fit in inventory as an integer.
     */
    public static int determineQuantityToPickUp(int inventoryCapacity, int numberOfItemsFound)
    {
        int excessCapacity = inventoryCapacity - numberOfItemsFound;
        if (excessCapacity >= 0)
        {
            return numberOfItemsFound;
        }
        System.out.println("You've only got room in your inventory for " + inventoryCapacity + " of them.");
        return inventoryCapacity;
    }

    /**
     * Class method to orchestrate player interaction with an item.
     *
     * @param choice                                Accepts the choice to be made by the player as a Choice object.
     * @param item                                  Accepts the item that is subject of the players choice as an Item object.
     * @param playerCharacter                       Accepts the player making the choice as a PlayerCharacter object.
     * @return                                      Whether or not the player interacted with the item.
     */
    public static boolean makeChoice(Choice choice, Item item, PlayerCharacter playerCharacter)
    {
        boolean choseYes = false;

        switch (choice)
        {
            case USE:
                choseYes = chooseToUseItem(playerCharacter, item);
                break;
            case PICK_UP:
                choseYes = chooseToPickUpItem(playerCharacter, item, 1);
                break;
        }
        return choseYes;
    }

    /**
     * Class method to orchestrate player interacting with more than one of an item.
     *
     * @param choice                                Accepts the choice to be made by the player as a Choice object.
     * @param item                                  Accepts the item that is subject of the players choice as an Item object.
     * @param playerCharacter                       Accepts the player making the choice as a PlayerCharacter object.
     * @param numberOfItems                         Accepts the number of items the player is interacting with as an integer.
     * @return                                      Whether or not the player interacted with the item.
     */
    public static boolean makeChoice(Choice choice, Item item, PlayerCharacter playerCharacter, int numberOfItems)
    {
        boolean choseYes = false;

        switch (choice)
        {
            case PICK_UP:
                choseYes = chooseToPickUpItem(playerCharacter, item, numberOfItems);
                break;
            default:
                break;
        }
        return choseYes;
    }

    /**
     * Class method for a player to pick up a number of items.
     *
     * @param playerCharacter                       Accepts the player choosing whether or not to pick up the item(s) as a PlayerCharacter object.
     * @param itemToPickUp                          Accepts the item subject to being picked up as an Item object.
     * @param numberOfItemsFound                    Accepts the number of items the player found up as an integer.
     * @return                                      Whether or not the player picked up the objects as a boolean.
     */
    public static boolean chooseToPickUpItem(PlayerCharacter playerCharacter, Item itemToPickUp, int numberOfItemsFound)
    {
        int inventoryCapacity = playerCharacter.getRemainingInventoryCapacity();
        int quantityToPickup = numberOfItemsFound;

        if (itemToPickUp.getCapacityConstraint())
        {
            if (inventoryCapacity <= 0)
            {
                System.out.println("Unfortunately, you don't have room in your inventory and must press on without it.");
                return false;
            }
            else
            {
                quantityToPickup = determineQuantityToPickUp(inventoryCapacity, numberOfItemsFound);
            }
        }

        if (takeAction("Do you want to pick it up?"))
        {
            playerCharacter.pickUpItem(itemToPickUp, quantityToPickup);
            return true;
        }

        return false;
    }

    /**
     * Class method to allow the player to choose whether or not they want to take an action.
     *
     * @param userPrompt                            Accepts the prompt to show the player as a string.
     * @return                                      Whether or not the player took an action as a boolean.
     */
    public static boolean takeAction(String userPrompt)
    {
        String userInput = Input.getValidInput(userPrompt, RuleSet.CHOICE);
        return Input.isYes(userInput);
    }

    /**
     * Class method for a player to pick up a number of items.
     *
     * @param playerCharacter                       Accepts the player choosing whether or not to use the item as a PlayerCharacter object.
     * @param itemToUse                             Accepts the item subject to being used by the player as an Item object.
     * @return                                      Whether or not the player used the item as a boolean.
     */
    public static boolean chooseToUseItem(PlayerCharacter playerCharacter, Item itemToUse)
    {
        if (playerCharacter.hasItem(itemToUse))
        {
            System.out.print("You've got a " + itemToUse.toString() +" in your inventory. ");
            if (takeAction("Do you want to use it to heal up?"))
            {
                playerCharacter.useItem(itemToUse);
                return true;
            }
        }
        else
        {
            System.out.println("You don't have any " + itemToUse.toString() + " in your inventory and must press on.");
        }
        return false;
    }

}