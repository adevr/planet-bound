package logica.estados;

import logica.dados.GameData;

import java.io.Serializable;

public class EstadoAdapter implements IEstado, Serializable {

    private GameData gameData;

    public EstadoAdapter(GameData data)
    {
        this.gameData = data;
    }

    public GameData getGameData()
    {
        return gameData;
    }

    @Override
    public IEstado selectShip(int index) {
        return this;
    }

    @Override
    public IEstado startGame() {
        return this;
    }

    @Override
    public IEstado play() {
        return this;
    }

    @Override
    public IEstado gameOver() {
        return this;
    }
}
