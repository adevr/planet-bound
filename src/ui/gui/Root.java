package ui.gui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class Root extends HBox {

    public Root(GameView observable) {
        setSpacing(5);

        getChildren().add(new HomeView(observable));
        setPadding(new Insets(10, 10, 10, 10));
    }
}