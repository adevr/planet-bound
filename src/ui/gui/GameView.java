package ui.gui;

import logic.StateMachine;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameView extends JFrame {
    private final Game game;
    private final PropertyChangeSupport propertyChangeSupport;

    public GameView(Game game) {
        this.game = game;
        propertyChangeSupport = new PropertyChangeSupport(game);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }
    
}
