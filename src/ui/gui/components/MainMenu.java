package ui.gui.components;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import ui.models.AwaitedInteraction;
import ui.models.GameObservable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainMenu extends Pane
{
    private GameObservable view;

    public MainMenu(GameObservable view)
    {
        super();
        this.view = view;
        this.view.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateView();
            }
        });
        setPrefWidth(800);
        setPrefHeight(600);
        Label welcome = new Label("Ready to start the space travel?");
        welcome.setLayoutX(200);
        welcome.setLayoutY(160);
        welcome.setFont(Font.font("Cambria", 32));
        getChildren().add(welcome);
        getChildren().add(startTravel());
        getChildren().add(exit());
    }

    public Button startTravel()
    {
        Button start = new Button("Start Space Travel");
        start.setLayoutX(280);
        start.setLayoutY(200);
        start.setPrefWidth(200);
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.spaceTravel();
            }
        });
        return start;
    }

    public Button exit()
    {
        Button exit = new Button("Exit Game");
        exit.setLayoutX(280);
        exit.setLayoutY(250);
        exit.setPrefWidth(200);
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.exit(1);
            }
        });
        return exit;
    }


    public void updateView()
    {
        AwaitedInteraction interaction = view.getAwaitedInteraction();
        setVisible(interaction == AwaitedInteraction.SPACE_TRAVEL);
    }
}
