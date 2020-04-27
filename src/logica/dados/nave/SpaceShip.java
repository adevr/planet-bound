package logica.dados.nave;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SpaceShip {

    private Integer fuel;
    private Integer weapons;
    private Integer shield;
    private HashMap<String, Number> cargo;

    public SpaceShip(Integer fuel, Integer weapons, Integer shield, HashMap<String, Number> cargo)
    {
        this.fuel = fuel;
        this.weapons = weapons;
        this.shield = shield;
        this.cargo = cargo;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }

    public Integer getWeapons() {
        return weapons;
    }

    public void setWeapons(Integer weapons) {
        this.weapons = weapons;
    }

    public Integer getShield() {
        return shield;
    }

    public void setShield(Integer shield) {
        this.shield = shield;
    }

    public HashMap<String, Number> getCargo() {
        return cargo;
    }

    public void setCargo(HashMap<String, Number> cargo) {
        this.cargo = cargo;
    }
}
