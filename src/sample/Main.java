package sample;

import logica.StateMachine;
import ui.text.UIText;

public class Main {

    public static void main(String[] args) {

        UIText ui = new UIText(new StateMachine());
        ui.execute();
    }
}
