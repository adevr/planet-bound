package logica.dados.nave;


import java.util.HashMap;

public class MilitaryShip extends SpaceShip
{
    public String name = "Military Ship";

    public MilitaryShip()
    {
        super();
        this.setName(name);
        this.setFuel(35);
        this.setWeapons(2);
        this.setCargo(this.initialCargo());
        this.setShield(1);
    }

    private HashMap<String, Number> initialCargo()
    {
        HashMap<String, Number> emptyCargo = new HashMap<String, Number>();
        for (int i = 1; i < 5; i++) {
            emptyCargo.put(Integer.toString(i), 0);
        }

        return emptyCargo;
    }

}
