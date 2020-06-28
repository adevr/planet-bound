package ui.gui;

import javafx.scene.layout.BorderPane;
import ui.models.GameObservable;

public class HomeView extends BorderPane
{
    public HomeView(GameObservable view)
    {
        setLeft(new BackgroundMenu(view));
        setRight(new StartMenu(view));
    }
}
