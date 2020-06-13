package ui.gui;

import javafx.geometry.Insets;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import ui.gui.components.CrewControlPane;
import ui.gui.components.ProgressFuelBar;
import ui.models.GameView;

public class GamePanel extends GridPane
{
    private GameView view;

    public GamePanel(GameView view)
    {
        this.view = view;
        Image image = new Image(Resources.getResourceFile("resources\\bg-panel.jpg"));
        BackgroundImage bg = new BackgroundImage(new Image(Resources.getResourceFile("resources\\bg-panel.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        setBackground(new Background(bg));
        setPadding(new Insets(20,20,20,20));
        setVgap(20);
        setHgap(20);
        buildPanel();
    }

    public void buildPanel()
    {
        ProgressBar pb = new ProgressFuelBar(this.view);
        GridPane.setConstraints(pb, 0, 0);

        Image fuel = new Image(Resources.getResourceFile("resources\\fuel.png"));
        ImageView iv = new ImageView(fuel);
        iv.setFitWidth(20);
        iv.setFitHeight(20);
        GridPane.setConstraints(iv, 1, 0);

        getChildren().add(pb);
        getChildren().add(iv);
        buildCargo();
        buildShields();

        CrewControlPane crewPane = new CrewControlPane(this.view);
        GridPane.setConstraints(crewPane, 0, 4);
        getChildren().add(crewPane);
    }

    public void buildCargo()
    {
        Pane parentBlock = new Pane();
        buildLinePanes(parentBlock, 6, false);
        GridPane.setConstraints(parentBlock, 0, 1);

        Pane parentBlock2 = new Pane();
        buildLinePanes(parentBlock2, 6, true);
        GridPane.setConstraints(parentBlock2, 0, 2);

        Image cargo = new Image(Resources.getResourceFile("resources\\cargoIcon.png"));
        ImageView iv = new ImageView(cargo);
        iv.setFitWidth(30);
        iv.setFitHeight(25);
        iv.setTranslateY(15);
        GridPane.setConstraints(iv, 1, 1);

        getChildren().addAll(parentBlock, parentBlock2, iv);
    }

    public void buildLinePanes(Pane parent, int qty, boolean top)
    {
        int space = 40;
        for(int i = 0; i < qty; i++){
            Pane block = newBlock(40, 40, space, i);
            if(top)
                block.setTranslateY(-20);
            parent.getChildren().add(block);
        }
    }

    public void buildShields()
    {
        Pane parent = new Pane();
        int space = 40;
        for(int i = 0; i < this.view.getMachine().getData().getActiveShip().getShields() ; i++){
            Pane block = newBlock(40, 40, space, i);
            Image fuel = new Image(Resources.getResourceFile("resources\\shield.png"));
            ImageView iv = new ImageView(fuel);
            iv.setFitWidth(40);
            iv.setTranslateY(2);
            iv.setTranslateX(1);
            iv.setFitHeight(40);
            block.getChildren().add(iv);
            parent.getChildren().add(block);
        }
        GridPane.setConstraints(parent, 0, 3);
        getChildren().add(parent);
    }

    public Pane newBlock(int... args)
    {
        Pane block = new Pane();
        block.setMinWidth(args[0]);
        block.setMinHeight(args[1]);
        block.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        block.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        block.setLayoutX(args[2]*args[3]);
        return block;
    }

}
