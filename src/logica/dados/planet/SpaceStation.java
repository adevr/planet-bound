package logica.dados.planet;

import logica.dados.nave.SpaceShip;

import java.util.HashMap;

public class SpaceStation {

    SpaceShip ship;

    public SpaceStation(SpaceShip ship)
    {
        this.ship = ship;
    }

    public void upgradeCargoHold()
    {
        HashMap<String, Number> cargo = this.ship.getCargo();
        cargo.put(Integer.toString(cargo.size()), 0);

        ship.setCargo(cargo);
    }

    public void hireCrewMember(int member)
    {
        // for one of each resource??
    }

    public void convertResource(int oldResource, int newResource)
    {
        // get oldResrouce from cargo and replaceIt for the new resource
    }

    // updgrade weapon system

    // repair armor from the ship

}
