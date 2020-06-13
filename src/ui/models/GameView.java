package ui.models;

import javafx.stage.Stage;
import logic.StateMachine;
import logic.data.GameData;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class GameView
{
    private final StateMachine machine;
    private Stage rootStage;
    private final PropertyChangeSupport propertyChangeSupport;

    public GameView(StateMachine machine)
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
}
