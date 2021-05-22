package game;

/**
 * Abstract super class for the phases of a player turn.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public abstract class TurnPhase
{
    protected PlayerCharacter playerCharacter;

    /**
     * Default constructor which creates an object of the class TurnPhase.
     *
     */
    public TurnPhase()
    {
        this.playerCharacter = new Player();
    }

    /**
     * Non-default constructor which creates an object of the class TurnPhase.
     *
     * @param playerCharacter                Accepts player character for the turn phase as a PlayerCharacter object.
     */
    public TurnPhase(PlayerCharacter playerCharacter)
    {
        this.playerCharacter = playerCharacter;
    }

    /**
     * Accessor method to get the player character that is the subject of the event.
     *
     * @return                               The player character for the turn phase as a PlayerCharacter object.
     */
    public PlayerCharacter getPlayerCharacter()
    {
        return playerCharacter;
    }

    /**
     * Mutator method to set the player character for the turn phase.
     *
     * @param playerCharacter                Accepts the player for the turn phase.
     */
    public void setPlayerCharacter(PlayerCharacter playerCharacter)
    {
        this.playerCharacter = playerCharacter;
    }

    /**
     * Start the turn phase.
     *
     */
    public abstract void startPhase();

}