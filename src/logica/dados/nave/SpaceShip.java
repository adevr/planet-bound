package logica.dados.nave;

import java.util.HashMap;
import java.util.Map.Entry;

public abstract class SpaceShip {

    String[] OFFICERS = {"Captain", "Navigation", "Landing Party", "Shields", "Weapons", "Cargo"};
    public boolean isGanhou;

    private String name;
    Integer fuel;
    Integer weapons;
    Integer shield;
    HashMap<String, Number> cargo;
    HashMap<Number, String> crew;
    private Boolean resourceConvertionStatus;

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

    public void setGanhou()
    {
        if(isEmptyCargo()) this.isGanhou = false;
        this.isGanhou = true;
    }

    public boolean isEmptyCargo()
    {
        int cargoQty = 0;
        for (Entry<String, Number> cargo: this.getCargo().entrySet()) cargoQty += (int) cargo.getValue();

        return cargoQty == 0;
    }

    public boolean hasCrewDeath()
    {
        if(this.crew.size() < 6) return true;
        return false;
    }

    public boolean isResourceConverted()
    {
        return this.resourceConvertionStatus;
    }

    public void removeCargo(int qty){
        int newQty = (int) this.cargo.get("1") - qty;
        this.cargo.replace("1", this.cargo.get("1"), newQty);
    }

    public void addCargo(int qty){
        int newQty = (int) this.cargo.get("1") + qty;
        this.cargo.replace("1", this.cargo.get("1"), newQty);
    }

    public void addCrewMember(int key, String value)
    {
        this.crew.put(key, value);
    }

    public String[] getOFFICERS(){
        return this.OFFICERS;
    }

}
