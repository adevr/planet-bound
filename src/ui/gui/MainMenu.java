package ui.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainMenu extends HBox
{

    private Pane buttonDiv;
    GameView view;

    public MainMenu(GameView view)
    {
        this.view = view;
        setPadding(new Insets(15, 12, 15, 12));
        setSpacing(10);

        createButtons();
    }

    public void createButtons()
    {
        Button buttonChoose = new Button("Escolher Nave");
        buttonChoose.setPrefSize(150, 20);
        buttonChoose.setPadding(new Insets(10, 30, 10, 30)  );
        buttonChoose.setAlignment(Pos.TOP_CENTER);

        buttonChoose.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    getChildren().add(new ChooseShipView(getView()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        Button buttonExit = new Button("Sair");
        buttonExit.setPrefSize(100, 20);
        buttonExit.setPadding(new Insets(10, 30, 10, 30));
        buttonExit.setAlignment(Pos.BOTTOM_CENTER);

        getChildren().add(buttonChoose);
        getChildren().add(buttonExit);
        setAlignment(Pos.CENTER);
    }

    public GameView getView() {
        return view;
    }
}
