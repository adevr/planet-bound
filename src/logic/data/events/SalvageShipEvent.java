package logic.data.events;

import logic.Helper;
import logic.data.Constants;
import logic.data.spaceships.SpaceShip;
import logic.factories.SpaceShipFactory;

import java.util.HashMap;

public class SalvageShipEvent extends Event
{
    public SalvageShipEvent(SpaceShip ship)
    {
        super(ship);
    }

    @Override
    public void execute()
    {
        //SpaceShip lostShip = new SpaceShipFactory().buildSpaceShip(Constants.SHIP_TYPES[Helper.generateRandomInt(1)]);
        // create a new resource to random factorie and add it to the ship.. check for cargo availability;
    }


}
