package ui.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import ui.models.GameView;

public class StartMenu extends HBox
{

    private Pane buttonDiv;
    GameView view;

    public StartMenu(GameView view)
    {
        this.view = view;
        setPadding(new Insets(15, 12, 15, 12));
        setSpacing(10);

        createButtons();
    }

    public void createButtons()
    {
        Button buttonChoose = new Button("Jogar");
        buttonChoose.setPrefSize(150, 20);
        buttonChoose.setPadding(new Insets(10, 30, 10, 30)  );
        buttonChoose.setAlignment(Pos.TOP_CENTER);

        buttonChoose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Object node = mouseEvent.getSource();
                if(node instanceof Button){
                    Popup selectShip = new ChooseShipView(getView());
                    if(!selectShip.isShowing()) {
                        selectShip.show(getScene().getWindow());
                        view.getMachine().play(1);
                    }else
                        selectShip.hide();
                }
            }
        });


        Button buttonExit = new Button("Sair");
        buttonExit.setPrefSize(100, 20);
        buttonExit.setPadding(new Insets(10, 30, 10, 30));
        buttonExit.setAlignment(Pos.BOTTOM_CENTER);

        getChildren().add(buttonChoose);
        getChildren().add(buttonExit);
        setAlignment(Pos.CENTER);
    }

    public GameView getView()
    {
        return view;
    }
}
