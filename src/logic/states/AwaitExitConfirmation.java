package logic.states;

import logic.data.GameData;

public class AwaitExitConfirmation extends StateAdapter
{
    public AwaitExitConfirmation(GameData data)
    {
        super(data);
    }

    @Override
    public IState exit(int choice)
    {
        if(choice == 1)
            System.exit(0);

        return new AwaitBeginning(getGameData());
    }
}
