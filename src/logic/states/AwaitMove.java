package logic.states;

import logic.data.GameData;

public class AwaitMove extends StateAdapter
{
    public AwaitMove(GameData data)
    {
        super(data);
    }

    @Override
    public IState move(int key)
    {
        if(getGameData().isDroneMoving(key)){
            return new AwaitMove(getGameData());
        }else if(getGameData().getActivePlanet().getExplorablePath().checkForResource()){
            return new AwaitResourceCollection(getGameData());
        }
        else return new AwaitTerrainExploration(getGameData());
    }
}


