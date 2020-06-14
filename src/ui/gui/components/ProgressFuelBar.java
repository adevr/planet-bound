package ui.gui.components;

import javafx.scene.control.ProgressBar;
import ui.models.GameView;

public class ProgressFuelBar extends ProgressBar
{
    private GameView view;

    public ProgressFuelBar(GameView view)
    {
        super();
        this.view = view;
        setPrefWidth(250);
        setPrefHeight(50);

        // get fuel from game data
        setProgress(this.view.getMachine().getData().getActiveShip().getGasTank()/100.0);
    }
}
