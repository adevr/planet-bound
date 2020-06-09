package logic.states;

import logic.data.GameData;

import java.io.Serializable;

public class StateAdapter implements IState, Serializable {

    private GameData data;

    public StateAdapter(GameData data)
    {
        this.data = data;
    }

    public GameData getGameData() { return data; }

    @Override
    public IState play(int choice) {
        return this;
    }

    @Override
    public IState gameOver(int choice) {
        return this;
    }

    @Override
    public IState exit(int choice) { return this; }

    @Override
    public IState chooseShip(String type) {
        return this;
    }

    @Override
    public IState enterPlanet(int choice) { return this; }

    @Override
    public IState spaceTravel() {
        return this;
    }

    @Override
    public IState convertResource(int[] choice, String convertTo) {
        return this;
    }

    @Override
    public IState dockingAction(int action, Object... arguments) {
        return this;
    }

    @Override
    public IState landing(int choice) {
        return this;
    }

    @Override
    public IState explore(int choice) {
        return this;
    }

    @Override
    public IState move(int key) {
        return this;
    }

    @Override
    public IState collect(int choice) {
        return this;
    }
}
