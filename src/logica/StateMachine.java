package logica;

import logica.dados.GameData;
import logica.estados.AwaitBeggining;
import logica.estados.IEstado;

public class StateMachine {

    private GameData data = new GameData();
    private IEstado state;

    public StateMachine(){
        setState(new AwaitBeggining(data));
    }

    public IEstado getState() {
        return state;
    }

    private void setState(IEstado state) {
        this.state = state;
    }

    public void play()
    {
        state.play();
    }

    public void selectSpaceShip(int index)
    {
        state.selectShip(index);
    }

    public void gameOver()
    {

    }

    public void doEvent()
    {
        state.doEvent();
    }

    public void selectPlanetAction()
    {
        state.selectPlanetAction();
    }

    public void move(int x, int y)
    {
        state.move(x, y);
    }

    public void doAction(int action)
    {
        state.doAction(action);
    }

}
