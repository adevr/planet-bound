package logica.dados.planet;

import logica.dados.nave.SpaceShip;

public class RedPlanet extends Planet{

    public RedPlanet(SpaceShip spaceShip)
    {
        super(spaceShip);
    }

    @Override
    public boolean isDockingActionDone(int action) {
        return true;
    }

}
