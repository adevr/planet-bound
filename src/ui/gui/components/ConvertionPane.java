package ui.gui.components;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
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
        getChildren().add(new Label("Convertion Center"));
    }

    public void updateView()
    {
        AwaitedInteraction interaction = view.getAwaitedInteraction();
        setVisible(interaction == AwaitedInteraction.RESOURCE_CONVERSION);
    }
}
