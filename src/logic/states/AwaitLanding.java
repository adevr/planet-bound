package logic.states;

import logic.data.Constants;
import logic.data.GameData;
import ui.models.AwaitedInteraction;

public class AwaitLanding extends StateAdapter
{
    public AwaitLanding(GameData data)
    {
        super(data);
    }

    @Override
    public IState landing(int choice)
    {
        if(choice == Constants.EXPLORATION_ACTION){
            return new AwaitTerrainExploration(getGameData());
        }
        return new AwaitPlanetOrbit(getGameData());
    }

    @Override
    public AwaitedInteraction getAwaitedInteraction() {
        return AwaitedInteraction.LANDING;
    }
}
