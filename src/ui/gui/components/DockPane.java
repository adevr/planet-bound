package ui.gui.components;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
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
    final ToggleGroup group = new ToggleGroup();

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
        upgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.dockingAction(Constants.HOLD_ACTION, 1);
            }
        });
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
        ccenter.setLayoutY(150);
        ccenter.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        ccenter.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ccenter.setPrefWidth(795);
        ccenter.setPrefHeight(300);
        BackgroundImage bg = new BackgroundImage(new Image(Resources.getResourceFile("resources/gun.png")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);



        Pane convertTo = new Pane();
        convertTo.setPrefWidth(400);
        convertTo.setPrefHeight(150);
        ToggleGroup convert = new ToggleGroup();
        RadioButton fuel = new RadioButton("Fuel");
        fuel.setToggleGroup(convert);
        fuel.setLayoutX(450);
        fuel.setLayoutY(100);
        RadioButton weapons = new RadioButton("Weapons");
        weapons.setToggleGroup(convert);
        weapons.setLayoutX(450);
        weapons.setLayoutY(160);

        RadioButton shields = new RadioButton("Shields");
        shields.setToggleGroup(convert);
        shields.setLayoutX(450);
        shields.setLayoutY(220);
        convertTo.getChildren().addAll(fuel, weapons, shields);

        Pane radios  = buildRadios();
        convertTo.getChildren().add(radios);

        Button confirm = new Button("Confirm Conversion");
        confirm.setLayoutX(200);
        confirm.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        confirm.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        DropShadow e = new DropShadow();
        e.setWidth(2);
        e.setHeight(2);
        e.setOffsetX(2);
        e.setOffsetY(2);
        e.setRadius(2);
        confirm.setEffect(e);
        confirm.setPrefWidth(400);
        confirm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                RadioButton convertFor = (RadioButton) convert.getSelectedToggle();
                int[] coordinates = new int[]{GridPane.getRowIndex(selected), GridPane.getColumnIndex(selected)};

                view.convertResource(coordinates, convertFor.getText().toUpperCase());
            }
        });
        GridPane.setConstraints(confirm,2, 4, 10, 1);
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

    public void createCheckboxCargo(int y, ToggleGroup elem, Pane radios)
    {
        for (int i = 0; i < 2; i++){
            Pane line = new Pane();
            for (int j = 0; j < 6; j++) {
                RadioButton box = new RadioButton();
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
                box.setPrefWidth(50);
                box.setPrefHeight(50);
                box.setLayoutX((j + 1) * 50);
                GridPane.setConstraints(box, j, i);
                box.setToggleGroup(elem);
                line.getChildren().add(box);
            }
            line.setLayoutY((i + 1) * 50);
            radios.getChildren().add(line);
        }
    }

    public Pane buildRadios()
    {
        Pane radios= new Pane();
        //radios.setLayoutX(50);
        createCheckboxCargo(0, group, radios);
        return radios;
    }
}
