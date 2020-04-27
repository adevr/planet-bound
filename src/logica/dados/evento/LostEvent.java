package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class LostEvent extends Event
{

    public LostEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {

    }
}
