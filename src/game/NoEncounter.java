package game;

/**
 * Class which orchestrates actions a player may take where there is no encounter.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class NoEncounter extends Encounter
{

    /**
     * Default constructor that creates an object of the NoEncounter class
     *
     * @author Matt Burgess
     * @version ver1.0.0
     */
    public NoEncounter()
    {
        super();
    }

    /**
     * Begin the sequence of events when a player does not encounter anything.
     *
     */
    @Override
    public void startEncounter()
    {
        super.playerCharacter.makeChoice(Choice.USE, Item.POTION);
    }
}