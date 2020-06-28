package logic.states;

import ui.models.AwaitedInteraction;

public interface IState
{
    IState play(int choice);
    IState gameOver(int choice);
    IState exit(int choice);
    IState chooseShip(String type);
    IState enterPlanet(int choice);
    IState spaceTravel();
    IState convertResource(int[] choice, String convertTo);
    IState dockingAction(int action, Object... arguments);
    IState landing(int choice);
    IState explore(int choice);
    IState move(int key);
    IState collect(int choice);
    AwaitedInteraction getAwaitedInteraction();
}
