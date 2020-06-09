package logic.data;

import logic.data.events.Event;
import logic.data.planets.Planet;
import logic.data.planets.WhitePlanet;
import logic.data.spaceships.SpaceShip;
import logic.factories.EventFactory;
import logic.factories.PlanetFactory;
import logic.factories.SpaceShipFactory;

import java.util.Arrays;

public class GameData
{
    SpaceShip activeShip;
    Planet activePlanet;

    public GameData () {}

    /**
     * Gets the active ship
     *
     * @return Ship
     */
    public SpaceShip getActiveShip()
    {
        return activeShip;
    }

    /**
     * Sets the active ship
     *
     * @param type
     */
    public void setActiveShip(String type)
    {
        if (type.equals("Military"))
            this.activeShip = SpaceShipFactory.buildSpaceShip(type, 35, 2, 1, new int[]{2, 6});

        this.activeShip = SpaceShipFactory.buildSpaceShip(type, 53, 1, 1, new int[]{2,6});
    }

    /**
     * Gets the current planet
     *
     * @return Planet
     */
    public Planet getActivePlanet()
    {
        return activePlanet;
    }

    /**
     * Creates a new planet
     */
    public void setActivePlanet()
    {
        this.activePlanet = PlanetFactory.buildPlanet(this.activeShip);
    }

    /**
     * Checks if the game is over
     *
     * @return Boolean
     */
    public Boolean isGameOver()
    {
        return (this.activeShip.isTankEmpty() || this.activeShip.getCrew().size() == 0);
    }

    /**
     * Checks if the fuel was spent
     *
     * @param qty
     * @return Boolean
     */
    public Boolean isFuelSpent(int qty)
    {
        if(!this.activeShip.isTankEmpty()){
            this.activeShip.emptyTank(qty);
        }
        return true;
    }

    /**
     * Checks if the resource was converted
     *
     * @param choice
     * @param convertTo
     * @return Boolean
     */
    public Boolean isResourceConverted(int[] choice, String convertTo)
    {
        if (!convertTo.equals("")) {
            this.activeShip.convertResource(choice, convertTo);
            return true;
        }
        return false;
    }

    /**
     * Checks if space travel done
     *
     * @return Boolean
     */
    public Boolean isSpaceTravelDone()
    {
        Event randomEvent = EventFactory.buildRandomEvent(getActiveShip());
        getActiveShip().emptyTank(1);
        if(randomEvent instanceof Event ) {
            randomEvent.execute();
            return true;
        }
        return false;
    }

    /**
     * Checks if the selected docking action was made
     *
     * @param action
     * @param arguments
     * @return Boolean
     */
    public Boolean isDockingActionDone(int action, Object... arguments)
    {
        if ( getActivePlanet() instanceof WhitePlanet ) {
            if(action == Constants.HOLD_ACTION){
                ((WhitePlanet) getActivePlanet()).getStation().upgradeCargoHold((int)arguments[0]);
                return true;
            } else if (action == Constants.HIRE_ACTION ) {
                ((WhitePlanet) getActivePlanet()).getStation().jobCenter((int)arguments[0]);
                return true;
            } else if(action == Constants.CONVERSION_ACTION ) {
                ((WhitePlanet) getActivePlanet()).getStation().convertionCenter((int[])arguments[0], (String)arguments[1]);
                return true;
            }
        }
        return false;
    }

    /**
     * Verify if drone moves and relocate it based on key direction
     *
     * @param key
     * @return Boolean
     */
    public Boolean isDroneMoving(int key)
    {
        int[] dronePosition = getActivePlanet().getExplorablePath().getDronePosition();
        if(getActivePlanet().getExplorablePath().checkAlienProximity()){
            getActivePlanet().getExplorablePath().isWrestled();
        }

        int[] newPos = getActivePlanet().getExplorablePath().getTerrainDrone().move(dronePosition, key);
        if(!Arrays.equals(newPos, new int[]{0, 0})){
            getActivePlanet().getExplorablePath().newDroneCoordinates(newPos);
            return true;
        }
        return false;
    }
}
