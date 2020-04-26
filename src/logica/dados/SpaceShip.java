package logica.dados;

import java.util.HashMap;

public class SpaceShip{

    private List<int> fuel;
    private List<int> weapons;
    private List<int> shield;
    private HashMap<String, int> cargo;

    public SpaceShip()
    {
        this.weapons = this.shield = this.fuel = new List<int>();
        this.cargo = new HashMap<String, int>();
    }

    public SpaceShip(List<int> weapons, List<int> fuel, List<int> shield, HashMap<String, int> cargo)
    {
        this.weapons = weapons;
        this.fuel = fuel;
        this.shield = shield;
        this.cargo = cargo;
    }

    public HashMap<String, int> getCargo()
    {
        return cargo;
    }

    public void setCargo(HashMap<String, int> cargo)
    {
        this.cargo = cargo;
    }

    public List<int> getFuel()
    {
        return fuel;
    }

    public void setFuel(List<int> fuel)
    {
        this.fuel = fuel;
    }

    public List<int> getWeapons()
    {
        return weapons;
    }

    public void setWeapons(List<int> weapons)
    {
        this.weapons = weapons;
    }

    public List<int> getShield()
    {
        return shield;
    }

    public void setShield(List<int> shield)
    {
        this.shield = shield;
    }
}
