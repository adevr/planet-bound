package logic.data.events;

import logic.Helper;
import logic.data.spaceships.SpaceShip;

public class CrewDeathEvent extends Event
{
    public CrewDeathEvent(SpaceShip ship)
    {
        super(ship);
    }

    @Override
    public void execute()
    {
        this.ship.killCrewMember(Helper.generateRandomInt(5));
    }
}
