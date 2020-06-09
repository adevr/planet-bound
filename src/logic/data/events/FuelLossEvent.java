package logic.data.events;

import logic.data.spaceships.SpaceShip;

public class FuelLossEvent extends Event
{
    public FuelLossEvent(SpaceShip ship)
    {
        super(ship);
    }

    @Override
    public void execute()
    {
        if(!this.ship.isTankEmpty())
            this.ship.emptyTank(1);
    }
}
