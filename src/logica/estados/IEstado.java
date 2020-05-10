package logica.estados;

public interface IEstado {
    IEstado play();
    IEstado gameOver();
    IEstado selectShip(int index);
    IEstado spaceTravel();
    IEstado doEvent();
    IEstado selectPlanetAction();
    IEstado move(int x, int y);
    IEstado doAction(int action);
}
