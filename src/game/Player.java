package game;

import utility.Die;
import utility.RNG;

import utility.Input;
import validation.RuleSet;

import java.util.ArrayList;

/**
 * Class which stores information of players of the game
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Player implements PlayerCharacter
{
    private static final int MAX_HEALTH = 100;
    private String name;
    private int health;
    private int position;
    private Inventory inventory;

    /**
     * Default constructor which creates the object of the class Player.
     *
     */
    public Player()
    {
        this.name = "unknown";
        this.health = MAX_HEALTH;
        this.position = 0;
        this.inventory = new Inventory();
    }

    /**
     * Add a specified quantity of an item to the players inventory.
     *
     * @param itemToAdd             Accepts the item to add to inventory as an Item object.
     * @param quantityToAdd         Accepts the quantity of the item to add to the inventory as an integer.
     */
    public void addInventoryItems(Item itemToAdd, int quantityToAdd)
    {
        this.inventory.addItem(itemToAdd, quantityToAdd);
    }

    /**
     * Returns the amount of damage done by the player in an attack.
     *
     * @return                      The amount of attack damage done by the player as an integer.
     */
    public int attack()
    {
        return RNG.rollDie(Die.D20);
    }

    /**
     * Return a string representation of the player state.
     *
     * @return                      The state of the player as a string.
     */
    public String toString()
    {
        int turnNumber = Game.getGame().getNumberOfTurns();
        if (turnNumber == 0)
        {
            return name + " is entering the dungeon with " + health + " and " + inventory.toString() + " in inventory.";
        }
        return name + " has " + health + " health remaining, has moved " + position + " spaces and has " + inventory.toString() + " in inventory.";
    }

    /**
     * Accessor method to get the player's health.
     *
     * @return                      The current health of the player as an integer.
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Accessor method to get the player's inventory.
     *
     * @return                      The current inventory of the player as an Inventory object.
     */
    public Inventory getInventory()
    {
        return inventory;
    }

    /**
     * Accessor method to get the player's name.
     *
     * @return                      The player's name as a string.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor method to get the player's current position.
     *
     * @return                      The player's position as an integer.
     */
    public int getPosition()
    {
        return position;
    }

    /**
     * Whether or not the player has a specific item in their inventory.
     *
     * @param item                  Accepts the item to check for in the player's inventory as an Item object.
     * @return                      Whether or not the player has the specific item in their inventory.
     */
    public boolean hasItem(Item item)
    {
        return inventory.hasItem(item);
    }

    /**
     * Calculates remaining capacity in the player's inventory.
     *
     * @return                      The remaining capacity in the players inventory as an integer.
     */
    public int getRemainingInventoryCapacity()
    {
        return inventory.getRemainingInventoryCapacity();
    }

    /**
     * Heal the player a specified amount, not going over the player's maximum possible health.
     *
     * @param healthGained          Accepts the amount of health gained by the player as an integer.
     */
    public void heal(int healthGained)
    {
        health = Math.min(health + healthGained, MAX_HEALTH);
    }

    /**
     * Determine whether or not the player is still alive.
     *
     * @return                      Whether or not the player is still alive as a boolean.
     */
    public boolean isAlive()
    {
        return this.health > 0;
    }

    /**
     * Get a string representation of the player's current state of health.
     *
     * @return                      The player's current state of health represented as a string.
     */
    public String getHealthState()
    {
        String playerState = name;

        if (isOnDeathsDoor())
        {
            playerState += " is only just hanging on...";
        }
        else if (isBloodied())
        {
            playerState += " has taken a few hits and is looking bloodied.";
        }
        else
        {
            playerState += " is looking healthy.";
        }

        return playerState;
    }

    /**
     * Returns whether or not the player is looking bloodied.
     *
     * @return                      Whether or not the player is looking bloodied as a boolean.
     */
    public boolean isBloodied()
    {
        return this.health < (int) (MAX_HEALTH / 2);
    }

    /**
     * Returns whether or not the player is on death's door.
     *
     * @return                      Whether or not the player is on death's door as a boolean.
     */
    public boolean isOnDeathsDoor()
    {
        return this.health < 5;
    }

    /**
     * Make a choice during the game
     *
     * @param choice                Accepts the choice the player is required to make as a Choice object.
     * @param item                  Accepts the item that is the subject of the player choice as an Item object.
     * @return                      The choice the player made as a boolean (true = yes, false = no).
     */
    public boolean makeChoice(Choice choice, Item item)
    {
        return MakeChoice.makeChoice(choice, item, this);
    }

    /**
     * Make a choice during the game
     *
     * @param choice                Accepts the choice the player is required to make as a Choice object.
     * @param item                  Accepts the item that is the subject of the player choice as an Item object.
     * @param numberOfItems         Accepts the number of items subject to the player's choice as an integer.
     * @return                      The choice the player made as a boolean (true = yes, false = no).
     */
    public boolean makeChoice(Choice choice, Item item, int numberOfItems)
    {
        return MakeChoice.makeChoice(choice, item, this, numberOfItems);
    }

    /**
     * Move the player forward a random number of spaces.
     *
     */
    public void moveForward()
    {
        int spacesMoved = RNG.rollDice(Die.D6, 2);
        System.out.println("\nYou move forward " + spacesMoved + " spaces...");
        position += spacesMoved;
    }

    /**
     * Pick up a specified quantity of an item.
     *
     * @param itemToPickup          Accepts the item to pick up as an Item object.
     * @param quantityToPickup      Accepts the quantity of an item to pick up as an integer.
     */
    public void pickUpItem(Item itemToPickup, int quantityToPickup)
    {
        inventory.pickupItem(itemToPickup, quantityToPickup);
    }

    /**
     * Request the player to input their name.
     *
     */
    public void requestPlayerName()
    {
        System.out.println("What shall we call you, brave warrior?");
        name = Input.getValidInput("Enter player name", RuleSet.NAME);
        setName(name);
    }

    /**
     * Mutator method to set the player's health.
     *
     * @param health                Accepts the player's health as an integer.
     */
    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * Mutator method to set the player's inventory.
     *
     * @param inventory                Accepts the players inventory as an Inventory object.
     */
    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    /**
     * Mutator method to set the player's name.
     *
     * @param name                Accepts the players name as a string.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator method to set the player's position.
     *
     * @param position                Accepts the players position as an integer.
     */
    public void setPosition(int position)
    {
        this.position = position;
    }

    /**
     * Deal damage to the player.
     *
     * @param damage                Accepts the amount of damage done to the player as an integer.
     */
    public void takeDamage(int damage)
    {
        health = Math.min(health - damage, MAX_HEALTH);
    }

    /**
     * Use a specific item.
     *
     * @param item                  Accepts an item for the player to use as an Item object.
     */
    public void useItem(Item item)
    {
        if (inventory.hasItem(item))
        {
            inventory.useItem(item, this);
        }
    }

}