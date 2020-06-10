package ui.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ChooseShipView extends HBox
{

    public ChooseShipView(GameView view) throws IOException {
        Parent popup = FXMLLoader.load(getClass().getResource("resources\\chooseShip.fxml"));

        getChildren().add(popup);
    }

}
