package logica.estados;

import logica.dados.GameData;
import logica.dados.planet.Planet;

public class AwaitMove extends EstadoAdapter
{

    private int x, y;

    public AwaitMove(GameData data, int x, int y)
    {
        super(data);
        this.x = x;
        this.y = y;
    }


    @Override
    public IEstado move(int x, int y)
    {
        int[] alienPos = getGameData().getPlanet().getTerrain().getAlienPosition();

        if(x+1 == alienPos[0] || y+1 == alienPos[1])
            return new AwaitAlientAttack(getGameData());

        if(getGameData().getPlanet().getTerrain().relocateSpaceShip(x, y))
            return this;
    }
}
