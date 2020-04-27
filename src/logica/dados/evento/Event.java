package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public abstract class Event
{

    private SpaceShip ship;

    public Event(SpaceShip ship)
    {
        this.ship = ship;
    }

    abstract void handle();

}
