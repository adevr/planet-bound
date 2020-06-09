package logic.states;

import logic.data.Constants;
import logic.data.GameData;

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
        }

        return new AwaitTerrainExploration(getGameData());
    }
}
