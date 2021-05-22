package game;

import utility.CumulativeProbability;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Class which orchestrates the event phase of a players turn.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Event extends TurnPhase
{

    // Constant for the probability of a specific encounter occuring.
    private final Map<Encounter, Integer> POSSIBLE_ENCOUNTERS = Map.ofEntries(
            Map.entry(new ItemEncounter(), 40),
            Map.entry(new CreatureEncounter(), 40),
            Map.entry(new NoEncounter(), 20)
    );

    /**
     * Default constructor which creates an object of the class Event.
     *
     */
    public Event()
    {
        super();
    }

    /**
     * Non-default constructor which creates an object of the class Event.
     *
     * @param playerCharacter                The player subject to the event as a PlayerCharacter object.
     */
    public Event(PlayerCharacter playerCharacter)
    {
        super(playerCharacter);
    }

    /**
     * Determines the type of encounter a player has during the event.
     *
     * @return                               The encounter the player will experience during the event phase of their turn as an Encounter object.
     */
    public Encounter determineEncounterType()
    {
        CumulativeProbability<Encounter> probability = new CumulativeProbability<Encounter>(this.POSSIBLE_ENCOUNTERS);
        return probability.getOption();
    }

    /**
     * Starts the encounter a player experiences during the event phase.
     *
     * @param encounter                      Accepts the encounter to start as an Encounter object.
     */
    public void doEncounter(Encounter encounter)
    {
        encounter.setPlayerCharacter(super.playerCharacter);
        encounter.startEncounter();
    }

    /**
     * Accessor method to get the possible encounters that can occur during the event phase of the turn.
     *
     * @return                               The possible encounters and their probablity of occuring as a map.
     */
    public Map<Encounter, Integer> getPossibleEncounters()
    {
        return this.POSSIBLE_ENCOUNTERS;
    }

    /**
     * Begins the event phase of the TurnPhase.
     *
     */
    @Override
    public void startPhase()
    {
        Encounter encounter = determineEncounterType();
        doEncounter(encounter);
    }

}