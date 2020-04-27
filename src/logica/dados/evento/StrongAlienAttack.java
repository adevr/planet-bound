package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class StrongAlienAttack extends Event
{

    public StrongAlienAttack(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {

    }
}
