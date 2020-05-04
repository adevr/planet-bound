package logica.dados.nave;

import java.util.HashMap;

public class MiningShip extends SpaceShip
{
    public String name = "Mining Ship";

    public MiningShip()
    {
        super();
        this.setFuel(53);
        this.setWeapons(1);
        this.setCargo(this.initialCargo());
        this.setShield(1);
        this.setName(name);
    }

    private HashMap<String, Number> initialCargo()
    {
        HashMap<String, Number> emptyCargo = new HashMap<String, Number>();
        for (int i = 1; i < 3; i++) {
            emptyCargo.put(Integer.toString(i), 0);
        }

        return emptyCargo;
    }


}
