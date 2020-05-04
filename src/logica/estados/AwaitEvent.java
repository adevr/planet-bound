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
        SpaceShip ship = getGameData().getActiveSpaceShip();
        List<Event> events = getGameData().getEvents();
        int randomPosition = (int) (Math.random() * ((5 - 0) + 1));

        events.get(randomPosition).handle();
        return new OrbitPlanet(getGameData());
    }
}
