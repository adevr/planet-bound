package logic;

import logic.data.GameData;
import logic.states.AwaitBeginning;
import logic.states.IState;

import java.io.Serializable;

public class StateMachine implements Serializable
{
    private GameData data = new GameData();
    private IState state;

    public StateMachine()
    {
        setState(new AwaitBeginning(data));
    }

    public IState getState()
    {
        return state;
    }

    public void setState(IState state)
    {
        this.state = state;
    }

    public void play(int choice)
    {
        setState(state.play(choice));
    }

    public void gameOver(int choice)
    {
        setState(state.gameOver(choice));
    }

    public void exit(int choice)
    {
        setState(state.exit(choice));
    }

    public void chooseShip(String type)
    {
        setState(state.chooseShip(type));
    }

    public void enterPlanet(int choice)
    {
        setState(state.enterPlanet(choice));
    }

    public void spaceTravel()
    {
        setState(state.spaceTravel());
    }

    public void convertResource(int[] choice, String convertTo)
    {
        setState(state.convertResource(choice, convertTo));
    }

    public void dockingAction(int action, Object... arguments)
    {
        setState(state.dockingAction(action, arguments));
    }

    public void landing(int choice)
    {
        setState(state.landing(choice));
    }

    public void explore(int choice)
    {
        setState(state.explore(choice));
    }

    public void move(int key)
    {
        setState(state.move(key));
    }

    public void collect(int choice)
    {
        setState(state.collect(choice));
    }

    @Override
    public String toString(){
        return "---> STATE :: " + state.getClass().getSimpleName() + "\n";
    }

    /**
     * Get GameData
     *
     * @return
     */
    public GameData getData()
    {
        return data;
    }
}
