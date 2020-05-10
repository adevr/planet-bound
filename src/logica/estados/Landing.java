package logica.estados;

import logica.dados.GameData;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Landing extends EstadoAdapter
{
    public Landing(GameData data)
    {
        super(data);
    }

    @Override
    public IEstado move(int x, int y)
    {
        return new AwaitMove(getGameData(), x, y);
    }
}
