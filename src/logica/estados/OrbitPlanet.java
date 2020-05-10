package logica.estados;

import logica.dados.GameData;
import logica.dados.nave.SpaceShip;
import logica.dados.planet.Planet;
import logica.dados.planet.RedPlanet;
import logica.dados.planet.WhitePlanet;

public class OrbitPlanet extends EstadoAdapter
{

    public OrbitPlanet(GameData data)
    {
        super(data);
    }

    @Override
    public IEstado selectPlanetAction() {
        GameData data = getGameData();
        Planet planet = data.getPlanet();
        SpaceShip ship = data.getActiveSpaceShip();

        if(planet instanceof WhitePlanet) {
            if(ship.getCrew().containsKey("Landing Party"))
                return new Landing(data);
            else
                return new AwaitSpaceTravel(data);
        }
        return new AwaitStationDocking(data, 0);
    }
}
