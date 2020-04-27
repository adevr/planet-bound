package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class NoneEvent extends Event
{

    public NoneEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {

    }
}
