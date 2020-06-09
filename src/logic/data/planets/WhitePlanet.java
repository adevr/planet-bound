package logic.data.planets;

import logic.data.planets.existingThings.SpaceStation;
import logic.data.spaceships.SpaceShip;

public class WhitePlanet extends Planet
{

    private SpaceStation station;

    public WhitePlanet(SpaceShip ship)
    {
        super(ship);
        this.station = new SpaceStation(ship);
    }

    /**
     * Get spacestation
     *
     * @return SpaceStation
     */
    public SpaceStation getStation()
    {
        return this.station;
    }
}
