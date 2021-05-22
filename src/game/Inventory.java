package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Class which stores information about items in player's inventory
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Inventory
{

    private static final int MAX_INVENTORY_CAPACITY = 5;
    private HashMap<Item, Integer> items;

    /**
     * Default constructor which creates the object of the class Inventory.
     *
     */
    public Inventory()
    {
        this.items = new HashMap<Item, Integer>();
    }

    /**
     * Non-default constructor which creates the object of the class Inventory.
     *
     * @param items              Accepts the items in the player's inventory as an array list of item objects.
     */
    public Inventory(HashMap<Item, Integer> items)
    {
        this.items = items;
    }

    /**
     * Add an item to the player's inventory.
     *
     * @param item                  Accepts the item to add to inventory as an Item object.
     * @param numberOfItems         Accepts the quantity of items to add to inventory as an integer.
     */
    public void addItem(Item item, int numberOfItems)
    {
        int count = items.getOrDefault(item, 0);
        items.put(item, count + numberOfItems);
    }

    /**
     * Formats the players inventory.
     *
     * @return                      The players inventory formatted as a string.
     */
    public String formatDisplay()
    {
        StringJoiner inventoryDisplay = new StringJoiner(", ");

        for (Item item : items.keySet())
        {
            String itemString = item.toString();
            int numberOfItem = items.get(item);

            if (numberOfItem > 1)
            {
                itemString += "s";
            }

            inventoryDisplay.add(numberOfItem + " " + itemString);
        }

        return inventoryDisplay.toString();
    }

    /**
     * Accessor method to getting the items a player has in inventory.
     *
     * @return                      The items in inventory, along with the quantity of items, as a hashmap.
     */
    public HashMap<Item, Integer> getItems()
    {
        return items;
    }

    /**
     * Determine if a player has a specific item in inventory.
     *
     * @param item                  The item to check for in inventory.
     * @return                      Whether or not the player has an of the item in inventory.
     */
    public boolean hasItem(Item item)
    {
        return items.getOrDefault(item, 0) > 0;
    }

    /**
     * Determine how much inventory capacity is remaining
     *
     * @return                     The remaining inventory capacity as an integer.
     */
    public int getRemainingInventoryCapacity()
    {
        int totalItems = 0;
        for (Item item : items.keySet())
        {
            if (item.getCapacityConstraint())
            {
                totalItems += items.get(item);
            }
        }
        return MAX_INVENTORY_CAPACITY - totalItems;
    }

    /**
     * Pick up an item
     *
     * @param itemToPickup          Accepts the item to pick up as an Item object.
     * @param quantityToPickup      Accepts the quantity of the item to pick up as an integer.
     */
    public void pickupItem(Item itemToPickup, int quantityToPickup)
    {
        addItem(itemToPickup, quantityToPickup);
        System.out.println("You picked up " + quantityToPickup + " " + itemToPickup.toString() + "(s).");
    }

    /**
     * Mutator method to set the player's inventory.
     *
     * @param items                 Accepts the items to set as the players inventory as an array list of Item objects.
     */
    public void setInventory(HashMap<Item, Integer> items)
    {
        this.items = items;
    }

    /**
     * Return a string representation of the players inventory.
     *
     * @return                      The representation of the players inventory as a string.
     */
    public String toString()
    {
        return formatDisplay();
    }

    /**
     * Return a string representation of the players inventory.
     *
     * @param itemToUse             Accepts the item to use as an ItemType object.
     * @param player                Accepts the player using the item as a PlayerCharacter object.
     */
    public void useItem(Item itemToUse, PlayerCharacter player)
    {
        int count = items.getOrDefault(itemToUse, 0);
        itemToUse.use(player);
        items.put(itemToUse, --count);
    }

}