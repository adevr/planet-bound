package ui.models;

import javafx.stage.Stage;
import logic.StateMachine;
import logic.data.GameData;
import logic.data.planets.existingThings.Terrain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class GameObservable
{
    private final StateMachine machine;
    private Stage rootStage;
    private final PropertyChangeSupport propertyChangeSupport;

    public GameObservable(StateMachine machine)
    {
        this.machine = machine;
        this.propertyChangeSupport = new PropertyChangeSupport(machine);
    }

    // o argumento recebido por listenar vai passar a fazer parte da colecao de observadores
    // gerais, geridos pelo objeto propertyCangeSupport, desta classe;
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    // o argumento recebido por listener vai passar a fazer parte da colecao de observadores
    // geridos pelo objeto propertyCangeSupport, desta classe,
    // IDENTIFICADOS com propertyName,
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public PropertyChangeSupport getPropertyChangeSupport()
    {
        return propertyChangeSupport;
    }

    public StateMachine getMachine() {
        return machine;
    }

    public Stage getRootStage()
    {
        return rootStage;
    }

    public void setRootStage(Stage root)
    {
        this.rootStage = root;
    }

    public void play(int choice)
    {
        machine.play(choice);
        propertyChangeSupport.firePropertyChange( null, null, null);
    }

    public void gameOver(int choice)
    {
        machine.gameOver(choice);
        propertyChangeSupport.firePropertyChange( null, null, null);
    }

    public void exit(int choice)
    {
        machine.exit(choice);
        propertyChangeSupport.firePropertyChange( null, null, null);
    }

    public void chooseShip(String type)
    {
        machine.chooseShip(type);
        propertyChangeSupport.firePropertyChange( null, null, null);
    }

    public void enterPlanet(int choice)
    {
        machine.enterPlanet(choice);
        propertyChangeSupport.firePropertyChange( null, false, true);
    }

    public void spaceTravel()
    {
        machine.spaceTravel();
        propertyChangeSupport.firePropertyChange( null, false, true);
    }

    public void convertResource(int[] choice, String convertTo){
        machine.convertResource(choice, convertTo);
        propertyChangeSupport.firePropertyChange( null, false, true);
    }

    public void dockingAction(int action, Object... arguments)
    {
        machine.dockingAction(action, arguments);
        propertyChangeSupport.firePropertyChange( null, false, true);
    }

    public void landing(int choice)
    {
        machine.landing(choice);
        propertyChangeSupport.firePropertyChange( null, false, true);
    }

    public void explore(int choice)
    {
        machine.explore(choice);
        propertyChangeSupport.firePropertyChange( null, false, true);
    }

    public void move(int key)
    {
        machine.move(key);
        propertyChangeSupport.firePropertyChange( null, false, true);
    }

    public void collect(int choice)
    {
        machine.collect(choice);
        propertyChangeSupport.firePropertyChange( null, false, true);
    }

    public AwaitedInteraction getAwaitedInteraction()
    {
        return machine.getAwaitedInteraction();
    }

    public int[] getDroneCoordinates()
    {
        return machine.getData().getActivePlanet().getExplorablePath().getDronePosition();
    }

    public Terrain getExplorablePath()
    {
        return machine.getData().getActivePlanet().getExplorablePath();
    }


}
