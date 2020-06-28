package ui.gui.components;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.data.Constants;
import ui.gui.Resources;
import ui.models.AwaitedInteraction;
import ui.models.GameObservable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


// falta actions para mudar de estado
public class DockPane extends GridPane {
    private GameObservable view;

    public DockPane(GameObservable observable) {
        super();
        this.view = observable;

        this.view.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateView();
            }
        });

        buildConvertionCenter();
        buildJobCenter();
        buildCargoHoldCenter();
        updateView();
    }

    public void buildCargoHoldCenter() {
        Pane pane = new Pane();
        Button upgrade = new Button("Upgrade Cargo Hold");
        upgrade.setLayoutX(130);
        upgrade.setLayoutY(130);
        pane.setPrefWidth(400);
        pane.setPrefHeight(300);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        GridPane.setConstraints(pane, 0, 0, 1, 1);
        pane.getChildren().add(upgrade);
        getChildren().add(pane);
    }

    public void buildJobCenter() {
        Pane center = new Pane();
        center.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        center.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        center.setPrefWidth(400);
        center.setPrefHeight(300);

        for (int i = 0; i < Constants.CREW_TYPES.length; i++) {
            Button hire = new Button("Hire ".concat(Constants.CREW_TYPES[i]));
            //hire.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            eventHire(hire, Constants.HIRE_ACTION, Constants.CREW_TYPES[i]);
            hire.setLayoutX(135);
            hire.setLayoutY((i + 1) * 40);
            center.getChildren().add(hire);
        }

        GridPane.setConstraints(center, 1, 0, 1, 1);
        getChildren().add(center);
    }

    public void buildConvertionCenter() {
        GridPane ccenter = new GridPane();
        ccenter.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        ccenter.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ccenter.setPrefWidth(800);
        ccenter.setPrefHeight(300);
        BackgroundImage bg = new BackgroundImage(new Image(Resources.getResourceFile("resources\\gun.png")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        createCheckboxCargo(0, ccenter);
        createCheckboxCargo(1, ccenter);

        Pane convertTo = new Pane();
        convertTo.setPrefWidth(400);
        convertTo.setPrefHeight(150);
        CheckBox fuel = new CheckBox("Fuel");
        fuel.setLayoutX(200);
        fuel.setLayoutY(20);
        CheckBox weapons = new CheckBox("Weapons");
        weapons.setLayoutX(200);
        weapons.setLayoutY(60);
        CheckBox shields = new CheckBox("Shields");
        shields.setLayoutX(200);
        shields.setLayoutY(100);

        Button confirm = new Button("Confirm Conversion");
        GridPane.setConstraints(confirm,10, 4);

        convertTo.getChildren().addAll(fuel, weapons, shields);
        GridPane.setConstraints(convertTo,10, 3);

        ccenter.getChildren().add(convertTo);
        ccenter.getChildren().add(confirm);
        GridPane.setConstraints(ccenter, 0, 1, 2, 1);
        getChildren().addAll(ccenter);
    }

    public void updateView() {
        AwaitedInteraction interaction = view.getAwaitedInteraction();
        setVisible(interaction == AwaitedInteraction.DOCKING_STATION);
    }

    public void eventHire(Node elem, int choice, String person)     {
        elem.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.dockingAction(choice, person);
            }
        });
    }

    public void createCheckboxCargo(int y, Pane elem)
    {
        for (int i = 0; i < 6; i++){
            CheckBox box = new CheckBox();
            box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
            box.setPrefWidth(50);
            box.setPrefHeight(50);
            box.setLayoutX((i+1) * 50);
            GridPane.setConstraints(box, i, y);
            elem.getChildren().add(box);
        }
    }
}
