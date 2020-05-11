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
    public IEstado spaceTravel() {
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

    @Override
    public IEstado doEvent() {
        return this;
    }

    @Override
    public IEstado selectPlanetAction() {
        return this;
    }

    @Override
    public IEstado move(int x, int y) {
        return this;
    }

    @Override
    public IEstado doAction(int action) {
        return this;
    }

    @Override
    public IEstado convertResource() {
        return this;
    }

    @Override
    public IEstado doAlienAttack() {
        return this;
    }
}
