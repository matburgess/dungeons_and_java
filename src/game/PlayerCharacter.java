package game;

/**
 * A player character in the game.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public interface PlayerCharacter extends Creature
{

    public int getPosition();
    public int getRemainingInventoryCapacity();
    public boolean hasItem(Item item);
    public void heal(int healthGained);
    public boolean makeChoice(Choice choice, Item item);
    public boolean makeChoice(Choice choice, Item item, int numberOfItems);
    public void moveForward();
    public void pickUpItem(Item itemToPickup, int quantityToPickup);
    public void useItem(Item itemToUse);

}