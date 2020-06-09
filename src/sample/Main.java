package sample;

import logic.StateMachine;
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


    public static void main(String[] args)
    {
        UIText ui = new UIText(new StateMachine());
        ui.execute();
    }
}
