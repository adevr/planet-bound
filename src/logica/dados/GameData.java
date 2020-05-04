package logica.dados;

import java.util.List;

import logica.dados.evento.*;
import logica.dados.nave.*;

public class GameData
{
    List<Event> events;
    List<SpaceShip> ships;

    private int numActiveShip = 1;

    public GameData()
    {
        this.registerEvents();
        this.registerShips();
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

    public List<Event> getEvents()
    {
        return events;w
    }

    public List<SpaceShip> getShips()
    {
        return ships;
    }

    public SpaceShip getActiveSpaceShip()
    {
        return ships.get(numActiveShip-1);
    }

    public SpaceShip setActiveSpaceShip(int spaceShip)
    {
        this.numActiveShip = spaceShip;
        return getActiveSpaceShip();
    }

}
