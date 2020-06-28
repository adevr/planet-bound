package ui.gui.components;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import logic.states.AwaitLanding;
import logic.states.AwaitStationDocking;
import ui.models.GameObservable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ActionPane extends GridPane {
    private GameObservable view;
    private GridPane gamePanel;
    Integer type;

    public ActionPane(GameObservable view, GridPane root, int type) {
        this.view = view;
        this.gamePanel = root;
        this.type = type;
        updateView();
        buildActionPane();
        /*
        this.view.addPropertyChangeListener("state", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateView();
            }
        });
        updateView(); */
    }

    public void openPopup() {
        Popup po = new PlanetOrbitPopup(this.view);
        if (!po.isShowing()) {
            po.show(this.view.getRootStage().getScene().getWindow());
        }
    }


    public Pane openGame() {
        if (this.view.getMachine().getState() instanceof AwaitStationDocking) {
            return new DockPane(this.view);
        }
        return new Pane();
    }

    private void updateView() {
        setPrefWidth(800);
        setPrefHeight(600);
        setBorder(new Border(new BorderStroke(Color.BLUEVIOLET, BorderStrokeStyle.SOLID,
                null, new BorderWidths(3))));
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        if (type == 1)
            openPopup();
        else
            getChildren().add(new MainMenu(this.view, this.gamePanel));

    }


    public void buildActionPane() {
        DockPane dockStationPane = new DockPane(this.view);
        LandPane landPane = new LandPane(this.view);
        ConvertionPane convertionPane = new ConvertionPane(this.view);

        getChildren().addAll(dockStationPane, landPane, convertionPane);
    }
}

