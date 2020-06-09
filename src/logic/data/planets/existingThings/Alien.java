package logic.data.planets.existingThings;

import logic.data.Constants;
import logic.data.spaceships.Drone;

public class Alien
{
    private int lives = Constants.ALIEN_LIVES;

    /**
     * Method to cause damage on alien
     */
    public void damage()
    {
        this.lives--;
    }

    /**
     * Method that attacks a specific drone
     *
     * @param drone
     * @return bool
     */
    public boolean attack(Drone drone)
    {
        if(this.lives > 0)
        {
            drone.damage();
            return true;
        }
        return false;
    }

    /**
     * Method that gets the alien lives
     *
     * @return integer
     */
    public int getLives()
    {
        return this.lives;
    }
}
