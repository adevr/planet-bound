package logica.dados.nave;

import java.util.HashMap;

public class MilitaryShip extends SpaceShip
{

    public MilitaryShip(Integer fuel, Integer weapons, Integer shield, HashMap<String, Number> cargo) {
        super(fuel, weapons, shield, cargo);
    }

}
