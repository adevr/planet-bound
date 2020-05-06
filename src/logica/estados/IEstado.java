package logica.estados;

public interface IEstado {
    IEstado selectShip(int index);
    IEstado startGame();
    IEstado play();
    IEstado gameOver();
    IEstado doEvent();
    IEstado selectPlanetAction();
}
