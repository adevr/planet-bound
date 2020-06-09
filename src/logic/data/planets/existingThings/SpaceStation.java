package logic.data.planets.existingThings;

import logic.data.Constants;
import logic.data.spaceships.SpaceShip;

public class SpaceStation
{
    /**
     * Stores an instance of ship
     */
    SpaceShip ship;

    public SpaceStation(SpaceShip ship)
    {
        this.ship = ship;
    }

    /**
     * Method to select the crew member to hire
     * 
     * @param person
     * @return bool
     */
    public boolean jobCenter(int person)
    {
        if(person <= 5 ){
            this.ship.hireCrewMember(Constants.CREW_TYPES[person]);
            return true;
        }
        return false;
    }


    public boolean upgradeCargoHold(int resource)
    {
        //this.ship.
        // o que fazer aqui
        return true;
    }

    /**
     * Method to select the resource to convert under convertionCenter
     * 
     * @param location
     * @param choice
     * @return boolean
     */
    public boolean convertionCenter(int[] location, String choice)
    {
        if(choice != ""){
            this.ship.convertResource(location, choice);
            return true;
        }
        return false;
    }
}

