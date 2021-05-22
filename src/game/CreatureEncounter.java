package game;

import utility.Input;
import utility.RNG;

import java.util.ArrayList;

/**
 * Class which orchestrates a player encounter with a creature.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
// public class CreatureEncounter implements Encounter
public class CreatureEncounter extends Encounter
{

    private Creature encounteredCreature;

    /**
     * Default constructor that creates an object of the CreatureEncounter class.
     *
     */
    public CreatureEncounter()
    {
        super();
        this.encounteredCreature = null;
    }

    /**
     * Begin the battle between the player and encountered monster.
     *
     */
    public void beginBattle()
    {
        System.out.println(this.encounteredCreature.toString());
        int attacks = 0;
        do
        {
            if ((++attacks % 2) == 0)
            {
                System.out.print("The creature rushes at the player and attacks...");
                makeAttack(this.encounteredCreature, super.playerCharacter);
                System.out.println(toString());
                Input.enterToContinue();
            }
            else
            {
                if (attacks != 1)
                {
                    System.out.println(super.playerCharacter.getName() + " is locked in battle with " + this.encounteredCreature.getName());
                }
                System.out.print("You lunge forward and attack " + encounteredCreature.getName() + "...");
                makeAttack(super.playerCharacter, this.encounteredCreature);
            }
        } while (super.playerCharacter.isAlive() && this.encounteredCreature.isAlive());

        determineSurvivingCreature();
    }

    /**
     * Determine the type of monster encountered by the player.
     *
     */
    public void determineEncounteredCreature()
    {
        ArrayList<Monster> validMonsters = Game.getGame().getValidMonsters();
        this.encounteredCreature = new Monster(validMonsters.get(RNG.getRandomNumber(0, validMonsters.size() - 1)));
    }

    /**
     * Determine the creature that survived the encounter
     *
     */
    public void determineSurvivingCreature()
    {
        if (!super.playerCharacter.isAlive())
        {
            System.out.println(encounteredCreature.getName() + " has killed " + super.playerCharacter.getName() + "!");
        }
        else
        {
            System.out.println(super.playerCharacter.getName() + " has killed " + encounteredCreature.getName() + "!");
            Game.getGame().incrementMonstersEncountered();
        }
    }

    /**
     * Accessor method to get the encountered monster.
     *
     * @return                               The encoutnered monster as a Creature object.
     */
    public Creature getEncounteredCreature()
    {
        return this.encounteredCreature;
    }

    /**
     * Make an attack by one creature against another.
     *
     * @param attacker                       The creature performing the attack as a Creature object.
     * @param defender                       The creature receiving damage from the attack as a Creature object.
     */
    public void makeAttack(Creature attacker, Creature defender)
    {
        int attackDamage = attacker.attack();
        System.out.print("... doing " + attackDamage + " damage.\n");
        defender.takeDamage(attackDamage);
    }

    /**
     * Mutator method to set the encountered creature.
     *
     * @param encounteredCreature            The encoutnered creature as a Creature object
     */
    public void setEncounteredCreature(Creature encounteredCreature)
    {
        this.encounteredCreature = encounteredCreature;
    }

    /**
     * Begin the creature encounter.
     *
     */
    @Override
    public void startEncounter()
    {
        if (!Game.getGame().canEncounterMoreMonsters())
        {
            System.out.println("The coast looks clear for now... the monsters must be busy plotting their next move.");
        }
        else
        {
            determineEncounteredCreature();
            beginBattle();
        }
    }

    /**
     * Return the string representation of the creature encounter
     *
     * @return                               The string representation of the creature encounter.
     */
    public String toString()
    {
        String creatureEncounterDisplay = "";
        creatureEncounterDisplay += "\n" + super.playerCharacter.getHealthState();
        creatureEncounterDisplay += "\n" + this.encounteredCreature.getHealthState();
        return creatureEncounterDisplay;
    }

}