package logic.data.events;

import logic.data.Constants;
import logic.data.spaceships.SpaceShip;

public class CrewRescueEvent extends Event
{
    public CrewRescueEvent(SpaceShip ship)
    {
        super(ship);
    }

    @Override
    public void execute()
    {
        if (this.ship.getCrew().size() < 6){
            for (int i = 0; i <= Constants.CREW_TYPES.length; i++) {
                if (!this.ship.getCrew().contains(Constants.CREW_TYPES[i]))
                    this.ship.hireCrewMember(Constants.CREW_TYPES[i]);
            }
        }
    }
}
