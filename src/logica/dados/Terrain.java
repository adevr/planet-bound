package logica.dados;

import logica.dados.nave.SpaceShip;

public class Terrain {

    private final Resource resource;
    Alien al;
    SpaceShip spaceShip;
    public String[] resourceTypes = {"Artifact", "Fuel", "Energy Shield", "Ammo"};
    public int[] spaceshipPosition;
    public int[] resourcePosition;
    public int[] alienPosition;

    public Object[][] terrainMatrix = new Object[6][6];

    public Terrain(SpaceShip spaceShip)
    {
        this.resource = this.randomGeneratedResource();
        this.spaceshipPosition = this.generateRandomPosition();
        this.resourcePosition = this.generateRandomPosition();
        this.alienPosition = this.generateRandomPosition();
        this.spaceShip = spaceShip;
        this.al = new Alien();
        buildTerrainMatrix();
    }

    private Resource randomGeneratedResource()
    {
        int randomIndex = (int) (Math.random() * ((3 - 0) + 1));
        return new Resource(resourceTypes[randomIndex]);
    }

    private int[] generateRandomPosition()
    {
        int x = (int) (Math.random() * ((5 - 0) + 1));
        int y = (int) (Math.random() * ((5 - 0) + 1));

        return new int[]{x, y};
    }

    public Resource getResource()
    {
        return resource;
    }

    public int[] getResourcePosition()
    {
        return this.resourcePosition;
    }

    private void buildTerrainMatrix()
    {
        int[] shipPos = this.spaceshipPosition;
        int[] resPos = this.resourcePosition;
        int[] alPos = this.alienPosition;
        this.terrainMatrix[shipPos[0]][shipPos[1]] = this.spaceShip;
        this.terrainMatrix[resPos[0]][resPos[1]] = this.resource;
        this.terrainMatrix[alPos[0]][alPos[1]] = this.al;
    }

    public boolean relocateSpaceShip(int x, int y)
    {
        if(this.spaceshipPosition[0] > x || this.spaceshipPosition[1] > y){
            this.spaceshipPosition = new int[]{x, y};
            return true;
        }
        return false;
    }

    public int[] getShipPosition()
    {
        return this.spaceshipPosition;
    }

    public int[] getAlienPosition()
    {
        return this.alienPosition;
    }

}
