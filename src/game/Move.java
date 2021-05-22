package game;

/**
 * Class which orchestrates the movement phase of a players turn.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Move extends TurnPhase
{

    /**
     * Default constructor which creates the object of the Move class.
     *
     */
    public Move()
    {
        super();
    }

    /**
     * Non-default constructor which creates an object of the class Event.
     *
     * @param playerCharacter                The player making the move as a PlayerCharacter object.
     */
    public Move(PlayerCharacter playerCharacter)
    {
        super(playerCharacter);
    }

    /**
     * Begins the movement phase of the turn.
     *
     */
    @Override
    public void startPhase()
    {
        super.playerCharacter.moveForward();
    }
}