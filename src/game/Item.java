package game;

/**
 * Representation of items in the game
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public enum Item
{
    POTION("potion", true) {
        @Override
        public void use(PlayerCharacter target)
        {
            System.out.println("You use a potion to restore some health...");
            target.heal(15);
        }
    },
    COIN("coin", false),
    NONE("nothing") ;

    private String name;
    private boolean capacityConstraint;

    /**
     * Initialise the item with the corresponding name and capacity constraint characteristic.
     *
     * @param name                  Accepts the name of the item as a string.
     */
    Item(String name)
    {
        this.name = name;
        this.capacityConstraint = false;
    }

    /**
     * Initialise the item with the corresponding name and capacity constraint characteristic.
     *
     * @param name                   Accepts the name of the item as a string.
     * @param capacityConstraint     Accepts whether or not the item counts towards inventory capacity constraints as a boolean.
     */
    Item(String name, boolean capacityConstraint)
    {
        this.name = name;
        this.capacityConstraint = capacityConstraint;
    }

    /**
     * Get the appropriate string to display to the user when an item is found.
     *
     * @return                       The string representation to be displayed to the user when the item is found.
     */
    public String foundItemString()
    {
        if (this != NONE)
        {
            return "and found " + this.toString();
        }
        else
        {
            return "but doesn't find any loot.";
        }

    }

    /**
     * Accessor method to return whether or not this item contributes to the inventory capacity constraint.
     *
     * @return                       Whether or not the item counts towards inventory capacity constraints as a boolean.
     */
    public boolean getCapacityConstraint()
    {
        return this.capacityConstraint;
    }

    /**
     * Accessor method to return the name of the item.
     *
     * @return                       The name of the item as a string.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Return the string representation of the item.
     *
     * @return                       The string representation of the item.
     */
    @Override
    public String toString()
    {
        return this.name;
    }

    /**
     * Use the item.
     *
     * @param target                The target of the item usage as a PlayerCharacter object.
     */
    public void use(PlayerCharacter target)
    {
        System.out.println("You inspect the " + this.toString() + " but it dones't look useful at the moment.");
    }

}