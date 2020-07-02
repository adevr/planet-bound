package ui.gui.components;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import ui.models.AwaitedInteraction;
import ui.models.GameObservable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ActionPane extends GridPane {
    private GameObservable view;

    public ActionPane(GameObservable view) {
        this.view = view;
        this.view.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateView();
            }
        });
        updateView();
        buildActionPane();
    }

    private void updateView() {
        setPrefWidth(800);
        setPrefHeight(600);
        setBorder(new Border(new BorderStroke(Color.BLUEVIOLET, BorderStrokeStyle.SOLID,
                null, new BorderWidths(3))));
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void buildActionPane() {
        MainMenu menu = new MainMenu(this.view);
        DockPane dockStationPane = new DockPane(this.view);
        LandPane landPane = new LandPane(this.view);
        ConvertionPane convertionPane = new ConvertionPane(this.view);
        OrbitPane action = new OrbitPane(this.view);

        GridPane.setConstraints(menu, 0, 0, 1, 2);
        GridPane.setConstraints(action, 0, 0, 1, 2);
        GridPane.setConstraints(dockStationPane, 0, 0, 1, 2);
        GridPane.setConstraints(landPane, 0, 0, 1, 2);
        GridPane.setConstraints(convertionPane, 0, 0, 1, 2);
        getChildren().addAll(menu, action, dockStationPane, landPane, convertionPane);
    }

}

