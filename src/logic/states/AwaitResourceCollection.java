package logic.states;

import logic.data.GameData;

public class AwaitResourceCollection extends StateAdapter
{
    public AwaitResourceCollection(GameData data)
    {
        super(data);
    }

    @Override
    public IState collect(int choice)
    {
        if (getGameData().getActivePlanet().getExplorablePath().checkForResource()) {
            if(getGameData().getActivePlanet().getExplorablePath().isCollected(choice)){
                return new AwaitLanding(getGameData());
            }
        }
        return new AwaitMove(getGameData());
    }
}
