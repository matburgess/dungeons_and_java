package game;

/**
 * An encounter the player has throughout the game.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public abstract class Encounter
{
    protected PlayerCharacter playerCharacter;

    /**
     * Accessor method to get the player character in the encounter.
     *
     * @return                               The player as a Creature object.
     */
    public PlayerCharacter getPlayerCharacter()
    {
        return this.playerCharacter;
    }

    /**
     * Mutator method to set the player character in the encounter.
     *
     * @param playerCharacter                Accepts the player that may find an item as a PlayerCharacter object.
     */
    public void setPlayerCharacter(PlayerCharacter playerCharacter)
    {
        this.playerCharacter = playerCharacter;
    }

    /**
     * Start the encoutner.
     *
     */
    public abstract void startEncounter();
}