package logica.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import logica.dados.evento.*;
import logica.dados.nave.*;
import logica.dados.planet.Planet;
import logica.dados.planet.RedPlanet;
import logica.dados.planet.WhitePlanet;

public class GameData
{
    List<Event> events = new ArrayList<Event>();
    List<SpaceShip> ships = new ArrayList<SpaceShip>();
    Planet planet;
    Boolean isEventDone;

    private int numActiveShip = 1;

    public GameData()
    {
        this.registerShips();
        this.registerEvents();
        this.planet = generateRandomPlanet();
    }

    private void registerEvents()
    {
        events.add(new CrewDeathEvent(getActiveSpaceShip()));
        events.add(new SalvageShipEvent(getActiveSpaceShip()));
        events.add(new CargoLossEvent(getActiveSpaceShip()));
        events.add(new FuelLossEvent(getActiveSpaceShip()));
        events.add(new NoneEvent(getActiveSpaceShip()));
        events.add(new CrewRescueEvent(getActiveSpaceShip()));
    }

    private void registerShips()
    {
        SpaceShip mil = new MilitaryShip();
        this.ships.add(mil);
        this.ships.add(new MiningShip());
    }

    public List<Event> getEvents()
    {
        return events;
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

    public Planet generateRandomPlanet()
    {
        int r = new Random().nextInt(100);

        if(r < 71) return new WhitePlanet(getActiveSpaceShip());
        return new RedPlanet(getActiveSpaceShip());
    }

    public Planet getPlanet()
    {
        return this.planet;
    }

    public int[] move(int x, int y)
    {
        SpaceShip ship = getActiveSpaceShip();
        int[] lastPosition = getPlanet().getTerrain().getShipPosition();

        if(x < 0 || x >= 6 || y < 0 || y >= 6)
            return lastPosition;

        if(getPlanet().getTerrain().relocateSpaceShip(x, y))
            return getPlanet().getTerrain().getShipPosition();

        return lastPosition;
    }

    public Boolean isEventDone() {
        int random = (int) (Math.random() * ((5 - 0) + 1));
        events.get(random).handle();
        isEventDone = true;
        this.planet = generateRandomPlanet();
        return true;
    }

    public void resetEventStatus()
    {
        this.isEventDone = false;
    }

    public Boolean isGameOver()
    {
        return (this.getActiveSpaceShip().getFuel() == 0 || this.getActiveSpaceShip().getCrew().size() == 0);
    }

    public Boolean isFuelSpent(int qty)
    {
        if(getActiveSpaceShip().getFuel() > 0){
            getActiveSpaceShip().expendFuel(qty);
        }
        return true;
    }
}
