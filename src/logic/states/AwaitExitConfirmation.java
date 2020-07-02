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
        if(choice == 1) {
            System.exit(1);
            Runtime.getRuntime().addShutdownHook(new Thread(this::close));
        }

        return new AwaitBeginning(getGameData());
    }

    public void close() {
        System.exit(1);
    }
}
