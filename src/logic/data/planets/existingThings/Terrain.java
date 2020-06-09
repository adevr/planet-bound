package logic.data.planets.existingThings;

import logic.Helper;
import logic.data.resources.Resource;
import logic.data.spaceships.Drone;
import logic.data.spaceships.SpaceShip;
import logic.factories.ResourceFactory;

import java.util.ArrayList;
import java.util.List;

public class Terrain
{

    private int resourceCount;
    private int[] alPosition;
    private int[] dronePosition;
    public Object[][] groundMatrix = new Object[6][6];

    SpaceShip ship;

    public Terrain(SpaceShip ship)
    {
        this.ship = ship;
        this.resourceCount = Helper.generateRandomInt(3);
        this.alPosition = Helper.generateRandomPosition();
        this.dronePosition = Helper.generateRandomPosition();
    }

    /**
     * Method to build the terrain matrix with the objects
     */
    public void buildTerrainMatrix()
    {
        List<Resource> planetResources = new ArrayList<Resource>();
        for (int i = 0; i < this.resourceCount ; i++) {
             Resource r = new ResourceFactory().buildResource();
             planetResources.add(r);
             int[] position = Helper.generateRandomPosition();
             this.groundMatrix[position[0]][position[1]] = r;
        }
        this.groundMatrix[dronePosition[0]][dronePosition[1]] = this.ship.getDrone();
        this.groundMatrix[alPosition[0]][alPosition[1]] = new Alien();
    }

    /**
     * Get drone coordinates
     * @return int[]
     */
    public int[] getDronePosition()
    {
        return dronePosition;
    }

    /**
     * Get Alien coordinates
     * @return int[]
     */
    public int[] getAlPosition()
    {
        return alPosition;
    }

    /**
     * Method to verify if the resource is nearby
     *
     * @return bool
     */
    public boolean checkForResource()
    {
        return ( this.groundMatrix[dronePosition[0]+1][dronePosition[1]] instanceof Resource || this.groundMatrix[dronePosition[0]][dronePosition[1]+1] instanceof Resource);
    }

    /**
     * Method to verify if the resource was collected
     *
     * @param action
     * @return bool
     */
    public boolean isCollected(int action)
    {
        Resource r ;
        int[] pos;
        if(this.checkForResource()){
            if (this.groundMatrix[dronePosition[0]+1][dronePosition[1]] instanceof Resource){
                r = (Resource) this.groundMatrix[dronePosition[0]+1][dronePosition[1]];
                pos = new int[]{dronePosition[0] + 1, dronePosition[1]};
            }else {
                r = (Resource) this.groundMatrix[dronePosition[0]][dronePosition[1]+1];
                pos = new int[]{dronePosition[0], dronePosition[1] + 1};
            }
            if(getTerrainDrone().collectResource(action, r)){
                this.groundMatrix[pos[0]][pos[1]] = getTerrainDrone();
                this.groundMatrix[this.dronePosition[0]][this.dronePosition[1]] = null;
                this.dronePosition = pos;
                return true;
            }else return false;
        }
        return false;
    }

    /**
     * Method to verify if the fight was on
     *
     * @return bool
     */
    public boolean isWrestled()
    {
        if(this.checkAlienProximity()){
            int prob = (int) (Math.random() * ((5 - 0) + 1));
            if(prob > 3){
                this.getTerrainAlien().attack(this.getTerrainDrone());
            }else{
                this.getTerrainDrone().attack(this.getTerrainAlien());
            }
        }else return false;

        if(this.getTerrainAlien().getLives() == 0){
            this.spawnAlien();
        }
        else if (this.getTerrainDrone().getLifes() == 0){
            this.spawnDrone();
        }

        return true;
    }

    /**
     * Method that checks the proximity beetwen the drone and the alien
     *
     * @return bool
     */
    public boolean checkAlienProximity()
    {
        return (this.dronePosition[0]+1 == this.alPosition[0] || this.dronePosition[1]+1 == this.alPosition[1]);
    }

    /**
     * Method that gets the drone inside the terrain
     *
     * @return Drone
     */
    public Drone getTerrainDrone()
    {
        return (Drone) this.groundMatrix[dronePosition[0]][dronePosition[1]];
    }

    /**
     * Method that gets the Alien inside the Terrain
     *
     * @return Alien
     */
    public Alien getTerrainAlien()
    {
        return (Alien) this.groundMatrix[alPosition[0]][alPosition[1]];
    }

    /**
     * Method to spawn alien inside map
     */
    public void spawnAlien()
    {
        this.groundMatrix[this.alPosition[0]][this.alPosition[1]] = null;
        this.alPosition = Helper.generateRandomPosition();
        this.groundMatrix[this.alPosition[0]][this.alPosition[1]] = new Alien();
    }

    /**
     * Method to spawn drone inside map
     */
    public void spawnDrone()
    {
        this.groundMatrix[this.dronePosition[0]][this.dronePosition[1]] = null;
        this.dronePosition = Helper.generateRandomPosition();
        this.ship.regenerateDrone();
        this.groundMatrix[this.dronePosition[0]][this.dronePosition[1]] = this.ship.getDrone();
    }


    public void newDroneCoordinates(int[] newCoordinates)
    {
        this.groundMatrix[newCoordinates[0]][newCoordinates[1]] = getTerrainDrone();
        this.groundMatrix[this.dronePosition[0]][this.dronePosition[1]] = null;
        this.dronePosition = newCoordinates;
    }
}
