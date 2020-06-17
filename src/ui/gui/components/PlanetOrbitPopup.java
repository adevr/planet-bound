package ui.gui.components;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import ui.models.GameView;


public class PlanetOrbitPopup extends Popup
{
    private GameView view;

    public PlanetOrbitPopup(GameView observable)
    {
        super();
        this.view = observable;
        AnchorPane popupBase = new AnchorPane();
        popupBase.setPrefHeight(500);
        popupBase.setPrefWidth(200);
        popupBase.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        popupBase.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                null, new BorderWidths(3))));
        Label title = new Label("Choose your action!");
        title.setLayoutX(50);
        title.setLayoutY(30);
        popupBase.getChildren().addAll(title, dockingActionButton(), landingAction(), conversionAction(), skipAction());
        getContent().add(popupBase);
    }

    public Button dockingActionButton()
    {
        Button dock = new Button("Dock in SpaceStation");
        dock.setPrefWidth(180);
        dock.setPrefHeight(40);
        dock.setLayoutX(10);
        dock.setLayoutY(50);
        dock.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getMachine().enterPlanet(1);
                hide();
            }
        });
        return dock;
    }

    public Button landingAction()
    {
        Button landing = new Button("Land on Planet");
        landing.setPrefWidth(180);
        landing.setPrefHeight(40);
        landing.setLayoutX(10);
        landing.setLayoutY(110);
        landing.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getMachine().enterPlanet(2);
                hide();
            }
        });
        return landing;
    }

    public Button conversionAction()
    {
        Button convert = new Button("Convert Resources");
        convert.setPrefWidth(180);
        convert.setPrefHeight(40);
        convert.setLayoutX(10);
        convert.setLayoutY(170);
        convert.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getMachine().enterPlanet(3);
                hide();
            }
        });
        return convert;
    }

    public Button skipAction()
    {
        Button skip = new Button("Skip Planet");
        skip.setPrefWidth(180);
        skip.setPrefHeight(40);
        skip.setLayoutX(10);
        skip.setLayoutY(230);
        skip.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getMachine().enterPlanet(4);
                hide();
            }
        });
        return skip;
    }
}
