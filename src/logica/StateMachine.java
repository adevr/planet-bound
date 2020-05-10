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

    public void startGame()
    {
        state.play();
    }

}
