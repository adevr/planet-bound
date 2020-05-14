package logica.estados;

import logica.dados.GameData;

public class AwaitAlientAttack extends EstadoAdapter
{
    public AwaitAlientAttack(GameData data)
    {
        super(data);
    }

    @Override
    public IEstado doAlienAttack() {
        int[] position = getGameData().getPlanet().getTerrain().getShipPosition();
        if(getGameData().getPlanet().getTerrain().isWrestled()){
            return new AwaitMove(getGameData(), position[0], position[1]);
        }
        return new AwaitGameOver(getGameData());
    }
}
