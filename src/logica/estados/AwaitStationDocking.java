package logica.estados;

import logica.dados.GameData;

public class AwaitStationDocking extends EstadoAdapter{

    private int action;

    public AwaitStationDocking(GameData data, int action)
    {
        super(data);
        this.action = action;
    }

    @Override
    public IEstado doAction(int action) {
        if(getGameData().getPlanet().isDockingActionDone(action)){
            return new Landing(getGameData());
        }
        return this;
    }
}
