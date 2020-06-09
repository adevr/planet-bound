package logic.states;

import logic.data.GameData;

public class AwaitBeginning extends StateAdapter
{

    public AwaitBeginning(GameData data)
    {
        super(data);
    }


    @Override
    public IState play(int choice)
    {
        if(choice == 1)
            return new AwaitShipSelection(getGameData());

        return new AwaitExitConfirmation(getGameData());
    }
}
