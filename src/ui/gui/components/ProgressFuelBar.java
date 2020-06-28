package ui.gui.components;

import javafx.scene.control.ProgressBar;
import ui.models.GameObservable;

public class ProgressFuelBar extends ProgressBar
{
    private GameObservable view;

    public ProgressFuelBar(GameObservable view)
    {
        super();
        this.view = view;
        setPrefWidth(250);
        setPrefHeight(50);

        // get fuel from game data
        setProgress(this.view.getMachine().getData().getActiveShip().getGasTank()/100.0);
    }
}
