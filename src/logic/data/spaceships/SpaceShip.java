package logic.data.spaceships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logic.Helper;
import logic.data.Constants;
import logic.data.resources.Resource;

public abstract class SpaceShip
{
    // SpaceShip Properties
    private String name;
    private int gasTank;
    private int artilary;
    private int shields;
    private List<String> crew;
    private HashMap<Integer, Object[]> cargo;
    private Drone drone;

    public SpaceShip(String name, int fuelcells, int weapons, int shield, int[] cargo)
    {
        this.name = name;
        this.gasTank = fuelcells;
        this.artilary = weapons;
        this.shields = shield;
        setInitialCargo(cargo);
        hireNewTeam();
    }

    /**
     * Sets the initial cargo map with empty objects
     *
     * @param cargo
     */
    private void setInitialCargo(int[] cargo)
    {
        this.cargo = new HashMap<Integer, Object[]>();
        for (int i = 0; i < cargo[0] ; i++) {
            this.cargo.put(i+1, new Object[(int)cargo[1]]);
        }
    }

    /**
     * Hires a new team for the spaceship crew
     */
    private void hireNewTeam()
    {
        this.crew = new ArrayList<String>() {
            {
                for (int i = 0; i < Constants.CREW_TYPES.length; i++) {
                    add(Constants.CREW_TYPES[i]);
                }
            }
        };
    }

    /**
     * Decrease the gas inside the tank
     *
     * @param cell
     */
    public void emptyTank(int cell)
    {
        if (this.gasTank > 0)
            this.gasTank -= cell;
    }

    /**
     * Increase the gas quantity inside the tank
     *
     * @param cell
     */
    public void fuelTank(int cell){
        this.gasTank += cell;
    }

    /**
     * Verifies if the gasTank is empty
     *
     * @return boolean
     */
    public boolean isTankEmpty()
    {
        return (this.gasTank == 0);
    }

    /**
     * Decrease Weapons quantity
     */
    public void removeWeapons()
    {
        this.artilary--;
    }

    /**
     * Increase Weapons quantity
     *
     * @param weapon
     */
    public void addWeapons(int weapon)
    {
        this.artilary += weapon;
    }

    /**
     * Decrease Shield quantity
     */
    public void removeShields()
    {
        this.shields--;
    }

    /**
     * Increase Shield quantity
     *
     * @param shield
     */
    public void addShields(int shield)
    {
        this.shields += shield;
    }

    /**
     * Stores a resource inside cargo hold
     *
     * @param resource
     */
    public void storeResource(Resource resource)
    {
        for (Map.Entry<Integer, Object[]> cargo : this.cargo.entrySet()){
            Object[] slots = cargo.getValue();
            for (int i = 0; i < slots.length ; i++){
                if(slots[i] instanceof Object && !(slots[i] instanceof Resource)) {
                    slots[i] = resource;
                    return;
                }
            }
            cargo.setValue(slots);
            return;
        }
    }

    /**
     * Function to convert the selected resource
     *
     * @param coordinates
     * @param convertTo
     */
    public void convertResource( int[] coordinates, String convertTo )
    {
        Object slots[] = this.cargo.get(coordinates[0]);
        switch (convertTo){
            case Constants.FUEL:
                fuelTank(1);
                break;
            case Constants.SHIELD:
                addShields(1);
                break;
            case Constants.WEAPON:
                addWeapons(1);
                break;
        }
        slots[coordinates[1]] = new Object();
    }

    /**
     * Simulates the death of a crew member
     *
     * @param member
     */
    public void killCrewMember(int member)
    {
        if(member >= 0){
            this.crew.remove(member);
        }
    }

    /**
     * Gets the active drone
     *
     * @return Drone
     */
    public Drone getDrone()
    {
        return drone;
    }

    /**
     * Regenerates the drones
     */
    public void regenerateDrone()
    {
        this.drone = new Drone();
    }

    /**
     * Get cargo hold availability
     *
     * @return
     */
    public int getAvailableCargo()
    {
        int availableCargo = 0;
        for (Map.Entry<Integer, Object[]> cargo : this.cargo.entrySet()) {
            Object[] slots = cargo.getValue();
            for (int i = 0; i < slots.length; i++) {
                if (slots[i] instanceof Object && !(slots[i] instanceof Resource)) {
                    availableCargo++;
                }
            }
        }
        return availableCargo;
    }

    /**
     * Getter for cargo hold
     *
     * @return
     */
    public HashMap<Integer, Object[]> getCargo()
    {
        return cargo;
    }

    /**
     * Randomly loose some cargo
     *
     * @param hold
     */
    public void looseCargo(int hold)
    {
        this.cargo.get(hold)[Helper.generateRandomInt(this.cargo.get(hold).length)] = new Object();
    }

    /**
     * Getter for crew
     *
     * @return
     */
    public List<String> getCrew()
    {
        return crew;
    }

    /**
     * Hire crew member to the ship
     *
     * @param member
     */
    public void hireCrewMember(String member)
    {
        this.crew.add(member);
    }

    /**
     * Get shield quantity
     *
     * @return
     */
    public int getShields()
    {
        return shields;
    }

    /**
     * Get weapon Quantity
     *
     * @return
     */
    public int getArtilary()
    {
        return artilary;
    }

    /**
     * Get tank quantity
     *
     * @return
     */
    public int getGasTank()
    {
        return gasTank;
    }
}
