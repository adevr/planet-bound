package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class CrewDeathEvent extends Event
{

    public CrewDeathEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {
        int officer = (int) (Math.random() * ((5 - 0) + 1));
        this.ship.getCrew().remove(officer);
    }
}
