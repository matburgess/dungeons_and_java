package game;

/**
 * A creature in the game.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public interface Creature
{

    public int attack();
    public boolean isAlive();
    public void takeDamage(int damage);
    public String getHealthState();
    public String getName();

}