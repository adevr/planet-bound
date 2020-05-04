package logica.dados.nave;

import java.util.HashMap;

public abstract class SpaceShip {

    private String[] OFFICERS = {"Captain", "Navigation", "Landing Party", "Shields", "Weapons", "Cargo"};
    private String name;
    private Integer fuel;
    private Integer weapons;
    private Integer shield;
    private HashMap<String, Number> cargo;
    private HashMap<Number, String> crew;

    public SpaceShip()
    {
        this.name = "";
        this.fuel = 0;
        this.weapons = 0;
        this.shield = 0;
        this.cargo = new HashMap<String, Number>();
        this.crew  = new HashMap<Number, String>();
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

    public HashMap<Number, String> getCrew() {
        return crew;
    }

    public void setCrew(HashMap<Number, String> crew)
    {
        this.crew = new HashMap<Number, String>();
        for (int i = 0; i < OFFICERS.length; i++) {
            this.crew.put(i, OFFICERS[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
