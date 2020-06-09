package logic.states;

import logic.data.GameData;

public class AwaitSpaceTravel extends StateAdapter
{
    public AwaitSpaceTravel(GameData data)
    {
        super(data);
    }

    @Override
    public IState spaceTravel()
    {
        if(getGameData().isSpaceTravelDone()) {
            if(getGameData().isGameOver())
                return new AwaitGameOver(getGameData());
            return new AwaitPlanetOrbit(getGameData());
        }
        return new AwaitSpaceTravel(getGameData());
    }
}
