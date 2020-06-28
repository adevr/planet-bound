package ui.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import ui.models.GameObservable;


public class ChooseShipView extends Popup
{
    private GameObservable view;

    public ChooseShipView(GameObservable view) {
        this.view = view;
        AnchorPane ap = new AnchorPane();
        ap.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        ap.setPrefWidth(500);
        ap.setPrefHeight(200);

        Label lb = new Label("Escolha a sua nave!");
        lb.setLayoutX(180);
        lb.setLayoutY(10);

        ImageView military = setImageView("resources\\militaryship.png", 30, 30);
        ImageView mining = setImageView("resources\\miningship.png", 250, 30);

        military.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("Aqui Military");
                view.chooseShip("Military");
                initGamePanel(new GamePanel(view));
                hide();
            }
        });

        mining.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Aqui Mining");
                view.chooseShip("Mining");
                hide();
                initGamePanel(new GamePanel(view));
            }
        });

        ap.getChildren().add(lb);
        ap.getChildren().addAll(military, mining);
        getContent().add(ap);
    }


    private ImageView setImageView(String path, int x, int y) {
        Image image = new Image(Resources.getResourceFile(path));
        ImageView iv = new ImageView(image);
        iv.setFitHeight(150);
        iv.setFitWidth(200);
        iv.setLayoutX(x);
        iv.setLayoutY(y);

        return iv;
    }

    private void initGamePanel(GridPane panel) {
        Stage rootWindow = view.getRootStage();
        //Stage window = new Stage();
        Scene gamePanel = new Scene(panel);
//        window.setTitle("Planet Bound");
        rootWindow.setWidth(1200);
        rootWindow.setHeight(700);
        rootWindow.setScene(gamePanel);
        rootWindow.show();
    }
}
