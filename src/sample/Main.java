package sample;

import logic.StateMachine;
import ui.gui.GameModel;
import ui.gui.GameView;
import ui.text.UIText;

public class Main {
/*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/


    public static void main(String[] args) {
        GameModel gm = new GameModel(new StateMachine());
        new GameView(gm);
    }
}
