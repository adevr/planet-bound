package logic.data.events;

import logic.Helper;
import logic.data.spaceships.SpaceShip;

public class CargoLossEvent extends Event
{
    public CargoLossEvent(SpaceShip ship)
    {
        super(ship);
    }

    @Override
    public void execute()
    {
        if(this.ship.getCargo().size() > 0 && this.ship.getAvailableCargo() > 0)
            this.ship.looseCargo(Helper.generateRandomInt(1));
    }
}
