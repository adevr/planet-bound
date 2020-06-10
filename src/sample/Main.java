package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.StateMachine;
import ui.gui.GameView;
import ui.gui.Root;

public class Main extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        StateMachine machine = new StateMachine();
        GameView view = new GameView(machine);

        Root root = new Root(view);

        Scene scene = new Scene(root);
        stage.setWidth(600);
        stage.setHeight(700);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Planet Bound");
        stage.show();
    }
}
