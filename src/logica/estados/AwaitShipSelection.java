package logica.estados;

import logica.dados.GameData;
import logica.dados.nave.SpaceShip;

public class AwaitShipSelection extends EstadoAdapter
{

    public AwaitShipSelection(GameData data)
    {
        super(data);
    }

    @Override
    public IEstado selectShip(int index) {
        SpaceShip ship  = getGameData().setActiveSpaceShip(index);
        return new AwaitSpaceTravel(getGameData());
    }
}
