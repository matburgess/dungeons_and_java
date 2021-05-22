package game;

import utility.RNG;

import java.util.Random;

/**
 * Class which stores the information of monster in the dungeon.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Monster implements Creature
{
    private String type;
    private int health;
    private int minimumDamage;
    private int maximumDamage;
    private int maximumHealth;

    /**
     * Default constructor which creates the object of the class Monster.
     *
     */
    public Monster()
    {
        this.type = "Unknown";
        this.health = -1;
        this.minimumDamage = -1;
        this.maximumDamage = -1;
        this.maximumHealth = -1;
    }

    /**
     * Non-default constructor which creates the object of the class Monster.
     *
     * @param monster                  Accepts a monster obeject to clone the stats of.
     */
    public Monster(Monster monster)
    {
        this.type = monster.type;
        this.health = monster.health;
        this.minimumDamage = monster.minimumDamage;
        this.maximumDamage = monster.maximumDamage;
        this.maximumHealth = monster.health;
    }

    /**
     * Non-default constructor which creates the object of the class Monster.
     *
     * @param type                  Accepts the monster's type as a string.
     * @param health                Accepts the monster's starting health as a string.
     * @param minimumDamage         Accepts the minimum damage a monster does on an attack as an integer.
     * @param maximumDamage         Accepts the maximum damage a monster does on an attack as an integer.
     */
    public Monster(String type, int health, int minimumDamage, int maximumDamage)
    {
        this.type = type;
        this.health = health;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
        this.maximumHealth = health;
    }

    /**
     * Returns the amount of damage done by a monster in an attack.
     *
     * @return                      The amount of attack damage done by the monster as an integer.
     */
    public int attack()
    {
        return RNG.getRandomNumber(this.minimumDamage, this.maximumDamage);
    }

    /**
     * Get the monster's name.
     *
     * @return                      The monster's name.
     */
    public String getName()
    {
        return "the " + this.type;
    }

    /**
     * Accessor method for the monster's health.
     *
     * @return                      The monster's current health as an integer.
     */
    public int getHealth()
    {
        return this.health;
    }

    /**
     * Accessor method for the maximum damage the monster can do.
     *
     * @return                      The maximum damage the monster can do as an integer.
     */
    public int getMaximumDamage()
    {
        return this.maximumDamage;
    }

    /**
     * Accessor method for the monster's maximum health.
     *
     * @return                      The maximum health of the monster.
     */
    public int getMaximumHealth()
    {
        return this.maximumDamage;
    }

    /**
     * Accessor method for the minimum damage the monster can do.
     *
     * @return                      The minumum damage the monster can do as an integer.
     */
    public int getMinimumDamage()
    {
        return this.minimumDamage;
    }

    /**
     * Returns the current health state of the monster.
     *
     * @return                      The current health state of the monster a string.
     */
    public String getHealthState()
    {
        String monsterState = "The " + type;

        if (isOnDeathsDoor())
        {
            monsterState += " is only just hanging on...";
        }
        else if (isBloodied())
        {
            monsterState += " has taken some damage and is looking bloodied.";
        }
        else
        {
            monsterState += " is looking healthy.";
        }

        return monsterState;
    }

    /**
     * Accessor method for the monster's type.
     *
     * @return                      The type of monster as a string.
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Returns whether or not the monster is still alive.
     *
     * @return                      Whether or not the monster is alive as a boolean.
     */
    public boolean isAlive()
    {
        return this.health > 0;
    }

    /**
     * Returns whether or not the monster is looking bloodied.
     *
     * @return                      Whether or not the monster is looking bloodied as a boolean.
     */
    public boolean isBloodied()
    {
        return this.health < (int) (maximumHealth / 2);
    }

    /**
     * Returns whether or not the monster is on death's door.
     *
     * @return                      Whether or not the monster looks like it is on death's door as a boolean.
     */
    public boolean isOnDeathsDoor()
    {
        return this.health < 5;
    }

    /**
     * Mutator method to set the monster's health.
     *
     * @param health                Accepts the monster's heatlh as an integer.
     */
    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * Mutator method to set the maximum damage a monster can do.
     *
     * @param maximumDamage          Accepts the maximum damage a monster can do as an integer.
     */
    public void setMaximumDamage(int maximumDamage)
    {
        this.maximumDamage = maximumDamage;
    }

    /**
     * Mutator method to set the maximum health of the monster.
     *
     * @param maximumHealth          Accepts the maximum health of a can do as an integer.
     */
    public void setMaximumHealth(int maximumHealth)
    {
        this.maximumHealth = maximumHealth;
    }

    /**
     * Mutator method to set the minimum damage a monster can do.
     *
     * @param minimumDamage           Accepts the minmum damage a monster can do as an integer.
     */
    public void setMinimumDamage(int minimumDamage)
    {
        this.minimumDamage = minimumDamage;
    }

    /**
     * Mutator method to set the monster's type.
     *
     * @param type                    Accepts the monster's type as a string.
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Decrease the monster's health by taking damage.
     *
     * @param damage                Accepts the amount of damage taken by the monster as an integer.
     */
    public void takeDamage(int damage)
    {
        this.health -= damage;
    }

    /**
     * Get the string representation of the monster.
     *
     * @return                      The string representation of the monster.
     */
    public String toString()
    {
        return "A vicious " + type + " leaps from the darkness and attacks!";
    }

}