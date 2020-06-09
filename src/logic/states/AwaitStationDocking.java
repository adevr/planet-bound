package logic.states;

import logic.data.GameData;

public class AwaitStationDocking  extends StateAdapter
{
    public AwaitStationDocking(GameData data)
    {
        super(data);
    }

    @Override
    public IState dockingAction(int action, Object... arguments) {
        if(getGameData().isDockingActionDone(action, arguments)){
            return new AwaitPlanetOrbit(getGameData());
        }
        return new AwaitStationDocking(getGameData());
    }
}