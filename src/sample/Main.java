package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.StateMachine;
import logic.data.GameData;
import ui.models.GameView;
import ui.gui.HomeView;
import ui.gui.Root;

public class Main extends Application
{

    private Stage rootStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        this.rootStage = stage;

        GameView view = new GameView(new StateMachine());
        Root root = new Root(view, new HomeView(view));

        Scene scene = new Scene(root);
        this.rootStage.setWidth(700);
        this.rootStage.setHeight(700);
        this.rootStage.setResizable(false);
        this.rootStage.setScene(scene);
        this.rootStage.setTitle("Planet Bound");
        view.setRootStage(this.rootStage);
        this.rootStage.show();
    }

    public Stage getRootStage()
    {
        return rootStage;
    }
}
