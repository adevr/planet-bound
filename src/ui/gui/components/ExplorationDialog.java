package ui.gui.components;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import logic.data.Constants;
import ui.models.GameObservable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Optional;

public class ExplorationDialog extends Alert {

    GameObservable view;

    public ExplorationDialog(AlertType alertType, GameObservable view) {
        super(alertType);
        this.view = view;
        this.view.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //
            }
        });
        setTitle("Explore");
        setHeaderText("Choose Action");
        setContentText("Are you willing to explore?");

        Optional<ButtonType> result = showAndWait();
        if (result.get() == ButtonType.OK) {
            view.explore(Constants.SEND_DRONE);
        } else {
           view.explore(Constants.ORBIT_ACTION);
        }
    }
}
