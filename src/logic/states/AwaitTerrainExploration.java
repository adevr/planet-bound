package logic.states;

import logic.data.Constants;
import logic.data.GameData;
import ui.models.AwaitedInteraction;

public class AwaitTerrainExploration extends StateAdapter
{
    public AwaitTerrainExploration(GameData data)
    {
        super(data);
    }

    @Override
    public IState explore(int choice)
    {
        if(getGameData().isGameOver())
            return new AwaitGameOver(getGameData());

        if(choice == Constants.SEND_DRONE){
            getGameData().getActiveShip().emptyTank(1);
            return new AwaitMove(getGameData());
        }else if(choice == Constants.ORBIT_ACTION){
            return new AwaitPlanetOrbit(getGameData());
        }

        return new AwaitTerrainExploration(getGameData());
    }

    @Override
    public AwaitedInteraction getAwaitedInteraction() {
        return AwaitedInteraction.EXPLORE;
    }
}
