package logica.dados;

import java.util.List;

import logica.dados.evento.*;
import logica.dados.nave.*;

public class GameData
{

    List<Event> events;
    List<SpaceShip> ships;
    SpaceShip selectedShip;

    public GameData()
    {
        this.registerEvents();
    }

    private void registerEvents()
    {
        events.add(new CrewDeathEvent(selectedShip));
        events.add(new SalvageShipEvent(selectedShip));
        events.add(new CargoLossEvent(selectedShip));
        events.add(new FuelLossEvent(selectedShip));
        events.add(new NoneEvent(selectedShip));
        events.add(new CrewRescueEvent(selectedShip));
    }

    private void registerShips()
    {
        ships.add(new MilitaryShip());
        ships.add(new MiningShip());
    }

}
