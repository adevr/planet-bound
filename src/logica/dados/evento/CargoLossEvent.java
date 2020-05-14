package logica.dados.evento;

import logica.dados.nave.SpaceShip;

import java.util.HashMap;

public class CargoLossEvent extends Event
{

    public CargoLossEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {
        if(this.ship.getCargo().size() > 0){
            this.ship.removeCargo(1);
        }
    }
}
