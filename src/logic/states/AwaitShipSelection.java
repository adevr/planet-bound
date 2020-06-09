package logic.states;

import logic.data.GameData;

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

}
