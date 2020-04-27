package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class CrewRescueEvent extends Event
{
    public CrewRescueEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {

    }
}
