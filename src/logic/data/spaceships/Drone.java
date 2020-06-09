package logic.data.spaceships;

import logic.data.Constants;
import logic.data.planets.existingThings.Alien;
import logic.data.resources.Resource;

public class Drone
{
    private int lifes = 6;
    private Object[] cargo = new Object[6];

    public Drone(){}

    /**
     * Method to attack a specific alien
     *
     * @param al
     * @return bool
     */
    public boolean attack(Alien al)
    {
        if (this.lifes > 0) {
            al.damage();
            return true;
        }
        return false;
    }

    /**
     * Method to damage drone
     */
    public void damage()
    {
        this.lifes--;
    }

    /**
     * Method to collect resource to drone cargo
     *
     * @param choice
     * @param resource
     * @return bool
     */
    public boolean collectResource(int choice, Resource resource)
    {
        if(choice == 1) {
            for (int i = 0; i<this.cargo.length; i++){
                if(!(this.cargo[i] instanceof Resource)){
                    this.cargo[i] = resource;
                    break;
                }
            }
            return true;
        }else return false;
    }

    /**
     * Method to get the drone lifes
     *
     * @return Integer
     */
    public int getLifes()
    {
        return lifes;
    }

    /**
     * Method to get the cargo
     *
     * @return Object[]
     */
    public Object[] getCargo()
    {
        return cargo;
    }

    public int[] move(int[] current, int key)
    {
        if(key == Constants.KEY_UP)
            return new int[]{current[0], (current[1]+1)};
        else if(key == Constants.KEY_DOWN)
            return new int[]{current[0], (current[1]-1)};
        else if(key == Constants.KEY_RIGHT)
            return new int[]{current[0]+1, (current[1])};
        else if(key == Constants.KEY_LEFT)
            return new int[]{current[0]-1, (current[1])};
        return current;
    }
}
