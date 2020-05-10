package logica.estados;

import logica.dados.GameData;

public class AwaitBeggining extends EstadoAdapter {

    public AwaitBeggining(GameData data){
        super(data);
    }

    @Override
    public IEstado play() {
        return new AwaitShipSelection(getGameData());
    }
}
