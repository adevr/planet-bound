package logic.states;

import logic.data.Constants;
import logic.data.GameData;
import logic.data.planets.WhitePlanet;
import ui.models.AwaitedInteraction;

public class AwaitStationDocking extends StateAdapter {
    private int action;

    public AwaitStationDocking(GameData data) {
        super(data);
    }

    @Override
    public IState dockingAction(int action, Object... arguments) {
        this.action = action;
        if(getGameData().isDockingActionDone(action, arguments)) {
            return new AwaitPlanetOrbit(getGameData());
        }
        return new AwaitPlanetOrbit(getGameData());
    }

    @Override
    public AwaitedInteraction getAwaitedInteraction() {
        if (action == Constants.HOLD_ACTION) {
            return AwaitedInteraction.ORBIT;
        } else if (action == Constants.HIRE_ACTION) {
            return AwaitedInteraction.ORBIT;
        } else if (action == Constants.CONVERSION_ACTION) {
            return AwaitedInteraction.ORBIT;
        } else return AwaitedInteraction.DOCKING_STATION;
    }
}
