package logic.states;

import logic.data.Constants;
import logic.data.GameData;
import ui.models.AwaitedInteraction;

public class AwaitPlanetOrbit extends StateAdapter
{
    public AwaitPlanetOrbit(GameData data)
    {
        super(data);
    }

    @Override
    public IState enterPlanet(int choice)
    {
        if (choice == Constants.DOCKING_ACTION) return new AwaitStationDocking(getGameData());
        else if (choice == Constants.LANDING_ACTION) return new AwaitLanding(getGameData());
        else if (choice == Constants.CONVERSION_ACTION) return new AwaitResourceConversion(getGameData());
        else if (choice == Constants.EXIT_ACTION) return new AwaitSpaceTravel(getGameData());
        else return new AwaitPlanetOrbit(getGameData());
    }

    @Override
    public AwaitedInteraction getAwaitedInteraction() {
        return AwaitedInteraction.ORBIT;
    }
}
