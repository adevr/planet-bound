package ui.gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import ui.models.GameObservable;

public class Root extends HBox {

    private GameObservable observable;

    public Root(GameObservable observable, Object panel)
    {
        this.observable = observable;
        setSpacing(5);

        getChildren().add((Node) panel);
        setPadding(new Insets(10, 10, 10, 10));
    }

    public void buildComponent()
    {

    }
}