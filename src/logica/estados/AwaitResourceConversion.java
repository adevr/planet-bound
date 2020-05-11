package logica.estados;

import logica.dados.GameData;

public class AwaitResourceConversion extends EstadoAdapter
{
    public AwaitResourceConversion(GameData data)
    {
        super(data);
    }

    @Override
    public IEstado convertResource()
    {
        if(getGameData().getActiveSpaceShip().isResourceConverted()){
            return new OrbitPlanet(getGameData());
        }
    }
}
