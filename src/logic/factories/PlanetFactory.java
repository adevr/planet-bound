package logic.factories;

import logic.Helper;
import logic.data.planets.Planet;
import logic.data.planets.RedPlanet;
import logic.data.planets.WhitePlanet;
import logic.data.spaceships.SpaceShip;

public class PlanetFactory
{
    public static Planet buildPlanet(SpaceShip ship)
    {
        int percentage = Helper.generateRandomInt(100);

        if(percentage < 71) return new WhitePlanet(ship);
        return new RedPlanet(ship);
    }

}
