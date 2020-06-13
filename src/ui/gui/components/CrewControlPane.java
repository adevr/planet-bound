package ui.gui.components;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.data.GameData;
import ui.gui.Resources;
import ui.models.GameView;

import java.io.InputStream;

public class CrewControlPane extends Pane
{
    private final GameView view;

    public CrewControlPane(GameView view)
    {
        super();
        this.view = view;

        for (int i = 0; i < this.view.getMachine().getData().getActiveShip().getCrew().size(); i++){
            Pane childPane = new Pane();
            childPane.setPrefWidth(40);
            childPane.setPrefHeight(40);
            childPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            childPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
            childPane.setLayoutX(40*i);

            ImageView iv = getOfficerImage(Resources.getResourceFile("resources\\"+this.view.getMachine().getData().getActiveShip().getCrew().get(i)+".png"));

            childPane.getChildren().add(iv);
            getChildren().add(childPane);
        }
    }

    private ImageView getOfficerImage(InputStream data)
    {
        Image officer = new Image(data);
        ImageView iv = new ImageView(officer);
        iv.setFitHeight(35);
        iv.setFitWidth(35);
        iv.setTranslateY(2);
        iv.setTranslateX(2);
        return iv;
    }
}
