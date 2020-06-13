package ui.gui;

import javafx.scene.layout.BorderPane;
import ui.models.GameView;

public class HomeView extends BorderPane
{
    public HomeView(GameView view)
    {
        setLeft(new BackgroundMenu(view));
        setRight(new MainMenu(view));
    }
}
