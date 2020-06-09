package logic.data.planets;

import logic.data.planets.existingThings.Terrain;
import logic.data.spaceships.SpaceShip;

public abstract class Planet 
{
    
    private Terrain explorablePath;
    SpaceShip ship;

    public Planet(SpaceShip ship)
    {
        this.ship = ship; 
        this.explorablePath = new Terrain(ship);
    }

    public Terrain getExplorablePath() 
    {
        return this.explorablePath;
    }
    
    public SpaceShip getShip() 
    {
        return this.ship;
    }
}
