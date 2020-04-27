package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class SalvageShipEvent extends Event
{

    public SalvageShipEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {

    }
}
