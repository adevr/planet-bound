package logica;

import logica.dados.GameData;
import logica.estados.AwaitBeggining;
import logica.estados.IEstado;

import java.io.Serializable;

public class StateMachine implements Serializable {

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
        setState(state.play());
    }

    public void selectSpaceShip(int index)
    {
        setState(state.selectShip(index));
    }

    public void gameOver()
    {
        setState(state.gameOver());
    }

    public void doEvent()
    {
        setState(state.doEvent());
    }

    public void selectPlanetAction()
    {
        setState(state.selectPlanetAction());
    }

    public void move(int x, int y)
    {
        setState(state.move(x, y));
    }

    public void spaceTravel()
    {
        setState(state.spaceTravel());
    }

    public void doAction(int action)
    {
        setState(state.doAction(action));
    }

    public void convertResource() {
        setState(state.convertResource());
    }
    
    public void doAlienAttack(){
        setState(state.doAlienAttack());
    }

    @Override
    public String toString(){
        return "---> STATE :: " + state.getClass().getSimpleName() + "\n";
    }

}
