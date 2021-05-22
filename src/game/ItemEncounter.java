package game;

import utility.CumulativeProbability;

import java.util.Map;

/**
 * Class which orchestrates a player finding an item.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
// public class ItemEncounter implements Encounter
public class ItemEncounter extends Encounter
{
    // Constant values for the number of items found. Could easily be extended in the future with a method to generate a random number.
    private static final int POTIONS_FOUND = 1;
    private static final int COINS_FOUND = 1000;
    private static final int ALLOWED_POTIONS = 1;

    // Constant for the probability of a specific encounter occuring.
    private final Map<Item, Integer> POSSIBLE_ITEMS = Map.ofEntries(
            Map.entry(Item.POTION, 50),
            Map.entry(Item.COIN, 40),
            Map.entry(Item.NONE, 10)
    );

    /**
     * Default constructor wich creates an object of the ItemEncoutner class.
     *
     */
    public ItemEncounter()
    {
        super();
    }

    /**
     * Determine the type of item encountered by the player.
     *
     * @return                               The item encountered by the player as an Item object.
     */
    public Item determineItemFound()
    {
        CumulativeProbability<Item> probability = new CumulativeProbability<Item>(this.POSSIBLE_ITEMS);
        return probability.getOption();
    }

    /**
     * Determine the number of an item found by the player.
     *
     * @param itemFound              Accepts the item found as an Item object.
     * @return                       The quantity of an item found as an integer.
     */
    public int determineQuantityOfItemFound(Item itemFound)
    {
        int numberOfItemsFound = 0;
        switch (itemFound)
        {
            case POTION:
                numberOfItemsFound = POTIONS_FOUND;
                break;
            case COIN:
                numberOfItemsFound = COINS_FOUND;
                break;
            default:
                break;
        }
        return numberOfItemsFound;
    }

    /**
     * Pick up an incountered item.
     *
     */
    public void pickUpItem()
    {
        Item itemFound = determineItemFound();
        int numberOfItemsFound = determineQuantityOfItemFound(itemFound);

        printItemFound(itemFound, numberOfItemsFound);

        if (itemFound != Item.NONE)
        {
            playerCharacter.makeChoice(Choice.PICK_UP, itemFound, numberOfItemsFound);
        }
    }

    /**
     * Print the items found to the user
     *
     * @param itemFound              Accepts the item found as an Item object.
     * @param numberOfItemFound      Accepts the number of items found as an integer
     */
    public static void printItemFound(Item itemFound, int numberOfItemFound)
    {
        String itemFoundString = "You stop for a moment to take a look around ";
        if (itemFound == Item.NONE)
        {
            itemFoundString += "but don't see anything of value to loot.";
        }
        else
        {
            itemFoundString += " and find " + numberOfItemFound + " " + itemFound.toString() + "!";
        }

        System.out.println(itemFoundString);
    }

    /**
     * Use up to a specified number of potions
     *
     */
    public void usePotion()
    {
        int usedPotions = 0;
        while (usedPotions < ALLOWED_POTIONS)
        {
            if (!playerCharacter.makeChoice(Choice.USE, Item.POTION))
            {
                break;
            }
            usedPotions++;
        }
    }

    /**
     * Begin the creature encounter.
     *
     */
    @Override
    public void startEncounter()
    {
        pickUpItem();
        usePotion();
    }

}