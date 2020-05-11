package logica.estados;

import logica.dados.GameData;
import logica.dados.evento.Event;
import logica.dados.nave.SpaceShip;

import java.util.List;

public class AwaitEvent extends EstadoAdapter
{

    public AwaitEvent(GameData data)
    {
        super(data);
    }

    @Override
    public IEstado doEvent()
    {
        if(getGameData().isEventDone()) {
            return new OrbitPlanet(getGameData());
        }
    }
}
