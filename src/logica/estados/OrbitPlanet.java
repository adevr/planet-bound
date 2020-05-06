package logica.estados;

import logica.dados.GameData;
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

        if(planet instanceof WhitePlanet) {
            return new Landing(data);
        }
        return new AwaitStationDocking(data);
    }
}
