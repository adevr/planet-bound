package logic.states;

import logic.data.GameData;
import ui.models.AwaitedInteraction;

public class AwaitShipSelection extends StateAdapter
{
    public AwaitShipSelection(GameData data)
    {
        super(data);
    }

    @Override
    public IState chooseShip(String type)
    {
        getGameData().setActiveShip(type);
        return new AwaitSpaceTravel(getGameData());
    }

    @Override
    public AwaitedInteraction getAwaitedInteraction() {
        return AwaitedInteraction.SPACE_TRAVEL;
    }
}
