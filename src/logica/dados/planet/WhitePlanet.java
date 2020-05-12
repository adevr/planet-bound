package logica.dados.planet;

import logica.dados.nave.SpaceShip;

public class WhitePlanet extends Planet{

    SpaceStation dockingStation;

    public WhitePlanet(SpaceShip spaceShip)
    {
        super(spaceShip);
        this.dockingStation = new SpaceStation(spaceShip);
    }

    public boolean isDockingActionDone(int action)
    {
        return this.dockingStation.getActionStatus(action);
    }

}
