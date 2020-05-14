package logica.estados;

import logica.dados.GameData;

public class AwaitSpaceTravel extends EstadoAdapter
{

    public AwaitSpaceTravel(GameData data)
    {
        super(data);
    }

    @Override
    public IEstado spaceTravel() {
        if(getGameData().isFuelSpent(1)) {
            return new AwaitEvent(getGameData());
        }
        return this;
    }
}
