package ui.gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import ui.models.GameView;

public class Root extends HBox {

    public Root(GameView observable, Object panel) {
        setSpacing(5);

        getChildren().add((Node) panel);
        setPadding(new Insets(10, 10, 10, 10));
    }
}