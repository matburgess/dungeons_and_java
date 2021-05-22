package game;

import java.util.ArrayList;

/**
 * Class which orchestrates a player's turn.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Turn
{

    private PlayerCharacter playerCharacter;
    private ArrayList<TurnPhase> turnPhases;

    /**
     * Default constructor which creates the object of the class Turn.
     *
     */
    public Turn()
    {
        this.playerCharacter = new Player();
        this.turnPhases = new ArrayList<TurnPhase>();
    }

    /**
     * Non-default constructor which creates the object of the class Turn.
     *
     * @param playerCharacter        Accepts the player taking the turn as a PlayerCharacter object.
     */
    public Turn(PlayerCharacter playerCharacter)
    {
        this.playerCharacter = playerCharacter;
        this.turnPhases = new ArrayList<TurnPhase>();
        turnPhases.add(new Move(playerCharacter));
        turnPhases.add(new Event(playerCharacter));
    }

    /**
     * Evaluates whether or not the game over.
     *
     * @return                       Whether or not the game is over as a boolean.
     */
    public boolean evaluateGameOver()
    {
        return Game.getGame().evaluateGameOver();
    }

    /**
     * Accessor method that returns the player character taking the turn.
     *
     * @return                       The player taking a turn as a PlayerCharacer object.
     */
    public PlayerCharacter getPlayerCharacter()
    {
        return this.playerCharacter;
    }

    /**
     * Mutator method that sets the player character taking the turn.
     *
     * @param playerCharacter        Accepts the player taking the turn as a PlayerCharacter object.
     */
    public void setPlayerCharacter(PlayerCharacter playerCharacter)
    {
        this.playerCharacter = playerCharacter;
    }

    /**
     * Begins the player character's turn.
     *
     * @return                       Whether or not the game is over as a boolean.
     */
    public boolean startTurn()
    {
        printTurnHeader();
        for (TurnPhase phase : this.turnPhases)
        {
            phase.startPhase();
            if (evaluateGameOver())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Print the turn header with current game state to the screen.
     *
     */
    public void printTurnHeader()
    {
        System.out.println("**********************************************************************************************");
        System.out.println(Game.getGame().toString());
    }

}