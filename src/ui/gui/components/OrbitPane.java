package ui.gui.components;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import ui.models.AwaitedInteraction;
import ui.models.GameObservable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OrbitPane extends Pane {
    private GameObservable view;

    public OrbitPane(GameObservable view)
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
        updateView();
    }

    public void updateView()
    {
        Label title = new Label("Choose your action!");
        title.setLayoutX(300);
        title.setLayoutY(30);
        getChildren().addAll(title, dockingActionButton(), landingAction(), conversionAction(), skipAction());

        AwaitedInteraction interaction = view.getAwaitedInteraction();
        setVisible(interaction == AwaitedInteraction.ORBIT);
    }


    public Button dockingActionButton()
    {
        Button dock = new Button("Dock in SpaceStation");
        dock.setPrefWidth(180);
        dock.setPrefHeight(40);
        dock.setLayoutX(300);
        dock.setLayoutY(50);
        dock.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.enterPlanet(1);
            }
        });
        GridPane.setConstraints(dock, 2,1);
        return dock;
    }

    public Button landingAction()
    {
        Button landing = new Button("Land on Planet");
        landing.setPrefWidth(180);
        landing.setPrefHeight(40);
        landing.setLayoutX(300);
        landing.setLayoutY(110);
        landing.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.enterPlanet(2);
            }
        });
        GridPane.setConstraints(landing, 2,2);
        return landing;
    }

    public Button conversionAction()
    {
        Button convert = new Button("Convert Resources");
        convert.setPrefWidth(180);
        convert.setPrefHeight(40);
        convert.setLayoutX(300);
        convert.setLayoutY(170);
        convert.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.enterPlanet(3);
            }
        });
        GridPane.setConstraints(convert, 2,3);
        return convert;
    }

    public Button skipAction()
    {
        Button skip = new Button("Skip Planet");
        skip.setPrefWidth(180);
        skip.setPrefHeight(40);
        skip.setLayoutX(300);
        skip.setLayoutY(230);
        GridPane.setConstraints(skip, 2,4);
        skip.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.enterPlanet(4);
            }
        });
        return skip;
    }
}
