package ui.gui;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import ui.gui.components.BoundImageView;
import ui.models.GameObservable;


public class BackgroundMenu extends HBox
{
    private GameObservable view;
    private Image pic;

    public BackgroundMenu(GameObservable view)
    {
        this.view = view;
        Pane background = new Pane();
        background.setPrefWidth(375);
        background.setPrefHeight(640);
        background.setPadding(new Insets(10));
        Image image = new Image(Resources.getResourceFile("resources\\headImage.jpg"));

        if(image != null)
        {
            ImageView imageView = new BoundImageView(image, 375, 624);
            background.getChildren().add(imageView);
        }
        getChildren().add(background);
    }
}
