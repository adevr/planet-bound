package logic.data.events;

import logic.data.spaceships.SpaceShip;

public class NoneEvent extends Event
{
    public NoneEvent(SpaceShip ship)
    {
        super(ship);
    }

    @Override
    public void execute()
    {
        // nothing happens
    }
}
