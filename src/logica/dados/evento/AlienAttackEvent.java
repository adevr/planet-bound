package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class AlienAttackEvent extends Event
{

    public AlienAttackEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {

    }
}
