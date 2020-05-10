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
        return new AwaitEvent(getGameData());
    }
}
