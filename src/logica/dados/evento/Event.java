package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public abstract class Event
{

    public SpaceShip ship;

    public Event(SpaceShip ship)
    {
        this.ship = ship;
    }

    public abstract void handle();

}
