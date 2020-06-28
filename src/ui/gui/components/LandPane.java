package ui.gui.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import ui.gui.Resources;
import ui.models.AwaitedInteraction;
import ui.models.GameObservable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LandPane extends GridPane
{

    private GameObservable view;

    public LandPane(GameObservable view)
    {
        super();
        this.view = view;

        this.view.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateView();
            }
        });


        buildEarth();
        updateView();
    }

    public void buildEarth()
    {
        GridPane earth = new GridPane();
        BackgroundImage bg = new BackgroundImage(new Image(Resources.getResourceFile("resources\\earth.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        earth.setPrefWidth(400);
        earth.setPrefHeight(500);
        earth.setBackground(new Background(bg));
        earth.setGridLinesVisible(true);
        buildGridEarth(earth);
        Pane menu = menu();
        GridPane.setConstraints(menu, 0, 1);
        GridPane.setConstraints(earth, 1, 1);
        getChildren().addAll(menu, earth, spacer());
    }

    public void updateView()
    {
        AwaitedInteraction interaction = view.getAwaitedInteraction();
        setVisible(interaction == AwaitedInteraction.LANDING);
    }

    public void buildGridEarth(GridPane earth)
    {
        for (int i = 0; i<6; i++) {
            for (int j = 0; j < 6; j++) {
                Pane block = new Pane();
                block.setPrefWidth(70);
                block.setPrefHeight(85);
                block.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
                GridPane.setConstraints(block, j, i);
                earth.getChildren().add(block);
            }
        }
    }

    public Pane spacer()
    {
        Pane p = new Pane();
        p.setPrefHeight(50);
        GridPane.setConstraints(p, 1, 0);
        return p;
    }

    public Pane menu()
    {
        Pane menu = new Pane();
        menu.setPrefWidth(400);
        menu.setPrefHeight(200);
        menu.setPadding(new Insets(100, 100, 100, 100));
        menu.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        Button sendDrone = new Button("Send Drone");
        sendDrone.setLayoutX(180);
        sendDrone.setLayoutY(200);
        Button exitOrbit = new Button("Exit Orbit");
        exitOrbit.setLayoutX(180);
        exitOrbit.setLayoutY(250);

        menu.getChildren().addAll(sendDrone, exitOrbit);
        return menu;
    }
}
