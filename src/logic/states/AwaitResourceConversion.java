package logic.states;

import logic.data.GameData;
import ui.models.AwaitedInteraction;

public class AwaitResourceConversion extends StateAdapter
{
    public AwaitResourceConversion(GameData data)
    {
        super(data);
    }

    @Override
    public IState convertResource(int[] choice, String convertTo)
    {
        if(getGameData().isResourceConverted(choice, convertTo)){
            return new AwaitPlanetOrbit(getGameData());
        }
        return new AwaitResourceConversion(getGameData());
    }

    @Override
    public AwaitedInteraction getAwaitedInteraction() {
        return AwaitedInteraction.RESOURCE_CONVERSION;
    }
}
