package ui.gui.components;

import javafx.scene.layout.Pane;
import ui.models.GameView;

public class DockPane extends Pane
{
    private GameView view;

    public DockPane(GameView observable)
    {
        super();
        this.view = observable;
    }

    public void buildConvertionCenter()
    {

    }
}
