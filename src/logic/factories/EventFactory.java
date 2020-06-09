package logic.factories;

import logic.Helper;
import logic.data.Constants;
import logic.data.events.*;
import logic.data.spaceships.SpaceShip;

public class EventFactory
{

    public static Event buildRandomEvent(SpaceShip ship)
    {
        int choice = Helper.generateRandomInt(6);

        if(choice == Constants.CLOSS_EVNT)
            return new CargoLossEvent(ship);
        else if(choice == Constants.CRDEATH_EVNT)
            return new CrewDeathEvent(ship);
        else if(choice == Constants.CRRESCUE_EVNT)
            return new CrewRescueEvent(ship);
        else if(choice == Constants.FULOSS_EVNT)
            return new FuelLossEvent(ship);
        else if(choice == Constants.NONE_EVNT)
            return new NoneEvent(ship);

        return new SalvageShipEvent(ship);
    }


}

