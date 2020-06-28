package ui.gui.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import ui.gui.Resources;
import ui.models.AwaitedInteraction;
import ui.models.GameObservable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ConvertionPane extends Pane
{

    private GameObservable view;

    public ConvertionPane(GameObservable view)
    {
        super();
        this.view = view;

        this.view.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateView();
            }
        });

        buildConvertion();
        updateView();
    }

    public void buildConvertion()
    {
        GridPane ccenter = new GridPane();
        ccenter.setLayoutY(150);
        ccenter.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        ccenter.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ccenter.setPrefWidth(795);
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

    public void updateView()
    {
        AwaitedInteraction interaction = view.getAwaitedInteraction();
        setVisible(interaction == AwaitedInteraction.RESOURCE_CONVERSION);
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
