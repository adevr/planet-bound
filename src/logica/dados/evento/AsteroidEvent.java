package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class AsteroidEvent extends Event
{

    public AsteroidEvent(SpaceShip ship) {
        super(ship);
    }


    @Override
    public void handle() {

    }
}
