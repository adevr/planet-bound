package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class CrewDeathEvent extends Event
{

    public CrewDeathEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {

    }
}