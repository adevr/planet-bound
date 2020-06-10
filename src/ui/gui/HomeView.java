package ui.gui;

import javafx.scene.layout.BorderPane;
import sample.Main;

public class HomeView extends BorderPane
{
    public HomeView(GameView view)
    {
        setLeft(new BackgroundMenu(view));
        setRight(new MainMenu(view));
    }
}
