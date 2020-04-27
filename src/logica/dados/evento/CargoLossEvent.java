package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class CargoLossEvent extends Event
{

    public CargoLossEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {

    }
}
