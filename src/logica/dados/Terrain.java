package logica.dados;

import logica.dados.nave.SpaceShip;

public class Terrain {

    private final Resource resource;
    SpaceShip spaceShip;
    public String[] resourceTypes = {"Artifact", "Fuel", "Energy Shield", "Ammo"};
    public int[] landingPosition;
    public int[] resourcePosition;

    public String[][] terrainMatrix = new String[6][6];

    public Terrain(SpaceShip spaceShip)
    {
        this.resource = this.randomGeneratedResource();
        this.landingPosition = this.generateRandomPosition();
        this.resourcePosition = this.generateRandomPosition();
        this.spaceShip = spaceShip;
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

    public int[] getLandingPosition()
    {
        return this.landingPosition;
    }

    public int[] getResourcePosition()
    {
        return this.resourcePosition;
    }

    private void buildTerrainMatrix()
    {
        int[] shipPos = this.landingPosition;
        int[] resPos = this.landingPosition;
        this.terrainMatrix[shipPos[0]][shipPos[1]] = "S";
        this.terrainMatrix[resPos[0]][resPos[1]] = this.resource.getNome().substring(0, 1);
    }

}
