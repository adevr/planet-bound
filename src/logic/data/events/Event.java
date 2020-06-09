package logic.data.events;

import logic.data.spaceships.SpaceShip;

public abstract class Event
{
    /**
     * Holds an instance of the spaceship used
     */
    public SpaceShip ship;

    /**
     * Constructor to create an Event Object
     * @param ship
     */
    public Event(SpaceShip ship)
    {
        this.ship = ship;
    }

    /**
     * Function to declare in every event
     */
    public abstract void execute();
}
