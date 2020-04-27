package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class FuelLossEvent extends Event
{

    public FuelLossEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle()
    {

    }
}
