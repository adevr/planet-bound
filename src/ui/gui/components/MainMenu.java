package ui.gui.components;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import ui.models.GameView;

import javax.swing.border.Border;

public class MainMenu extends Pane
{

    private GameView view;
    private GridPane gamePanel;

    public MainMenu(GameView view, GridPane root)
    {
        super();
        this.view = view;
        this.gamePanel = root;
        Label welcome = new Label("Ready to start the space travel?");
        welcome.setLayoutX(200);
        welcome.setLayoutY(160);
        welcome.setFont(Font.font("Cambria", 32));
        getChildren().add(welcome);
        getChildren().addAll(startTravel(),exit());
    }

    public Button startTravel()
    {
        Button start = new Button("Start Space Travel");
        start.setLayoutX(280);
        start.setLayoutY(200);
        start.setPrefWidth(200);
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getMachine().spaceTravel();
                ActionPane travelPane = new ActionPane(view, gamePanel, 1);
                gamePanel.getChildren().remove(2);
                GridPane.setConstraints(travelPane, 1, 0, 1, 2);
                gamePanel.getChildren().add(2, travelPane);
            }
        });
        return start;
    }

    public Button exit()
    {
        Button exit = new Button("Exit Game");
        exit.setLayoutX(280);
        exit.setLayoutY(250);
        exit.setPrefWidth(200);
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getMachine().exit(1);
            }
        });
        return exit;
    }

}
