package logic.states;

import logic.data.GameData;

public class AwaitGameOver extends StateAdapter
{
    public AwaitGameOver(GameData data)
    {
        super(data);
    }

    @Override
    public IState gameOver(int choice)
    {
        if(choice == 1)
            return new AwaitExitConfirmation(getGameData());

        return new AwaitBeginning(getGameData());
    }
}
