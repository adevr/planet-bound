package ui.gui.components;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import ui.models.GameView;


public class ActionPane extends GridPane
{
    private GameView view;
    private GridPane gamePanel;

    public ActionPane(GameView view, GridPane root , int type)
    {
        this.view = view;
        this.gamePanel = root;
        setPrefWidth(800);
        setPrefHeight(600);
        setBorder(new Border(new BorderStroke(Color.BLUEVIOLET, BorderStrokeStyle.SOLID,
            null, new BorderWidths(3))));
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        if(type == 1)
            openPopup();
        else
            getChildren().add(new MainMenu(this.view, this.gamePanel));
    }

    public void openPopup()
    {
        Popup po = new PlanetOrbitPopup(this.view);
        if(!po.isShowing()) {
            po.show(this.view.getRootStage().getScene().getWindow());
        }
    }
}
