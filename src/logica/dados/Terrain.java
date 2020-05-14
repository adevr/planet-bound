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
            this.terrainMatrix[this.spaceshipPosition[0]][this.spaceshipPosition[1]] = null;
            this.spaceshipPosition = new int[]{x, y};
            this.terrainMatrix[x][y] = this.spaceShip;
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

    public Alien getAlien()
    {
        return this.al;
    }

    public boolean isWrestled()
    {
        if(this.spaceshipPosition[0]+1 == this.alienPosition[0] || this.spaceshipPosition[1]+1 == this.alienPosition[1]){
            int prob = (int) (Math.random() * ((5 - 0) + 1));
            if(prob > 3){
                this.al.attack(this.spaceShip);
            }else{
                this.spaceShip.attack(al);
            }
        }

        if(this.al.getLives() == 0){
            this.terrainMatrix[this.alienPosition[0]][this.alienPosition[1]] = null;
            int[] spawnPos = spawnAlien();
            this.alienPosition = spawnPos;
            this.terrainMatrix[spawnPos[0]][spawnPos[1]] = this.al;
        }else if(this.spaceShip.getLives() == 0){
            if(relocateSpaceShip(0,0)){
                this.spaceShip.resetLives();
            }
        }
        return true;
    }

    public int[] spawnAlien()
    {
        this.al = new Alien();
        return generateRandomPosition();
    }

}
