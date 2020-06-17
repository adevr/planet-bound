package ui.gui;

import javafx.geometry.Insets;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.data.spaceships.MilitaryShip;
import ui.gui.components.ActionPane;
import ui.gui.components.BoundImageView;
import ui.gui.components.CrewControlPane;
import ui.gui.components.ProgressFuelBar;
import ui.models.GameView;

public class GamePanel extends GridPane
{
    private GameView view;
    private ImageView ship;

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
        Pane action = new ActionPane(this.view, this, 0);
        //GridPane.setConstraints(action, 1, 0);
        GridPane.setConstraints(action, 1, 0, 1, 2);

        getChildren().add(action);
    }

    public void buildPanel()
    {
        Pane control = new Pane();
        control.setPrefHeight(400);
        control.setPrefWidth(300);
        control.setBorder(new Border(new BorderStroke(Color.BLUEVIOLET, BorderStrokeStyle.SOLID,
                null, new BorderWidths(3))));
        control.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        ProgressBar pb = new ProgressFuelBar(this.view);
        pb.setLayoutX(20);
        pb.setLayoutY(20);

        ImageView iv = new BoundImageView(new Image(Resources.getResourceFile("resources\\fuel.png")), 20, 20);
        iv.setLayoutX(pb.getPrefWidth() + 25);
        iv.setLayoutY(30);

        buildCargo(control);
        buildShields(control);
        buildWeapons(control);

        CrewControlPane crewPane = new CrewControlPane(this.view);
        crewPane.setLayoutX(20);
        crewPane.setLayoutY(280);

        ImageView teamI = new BoundImageView( new Image(Resources.getResourceFile("resources\\team.png")), 20, 20 );
        teamI.setLayoutY(285);
        teamI.setLayoutX(265);

        control.getChildren().addAll(pb, iv, crewPane, teamI);
        GridPane.setConstraints(control, 0, 0);
        getChildren().add(control);
        displayShip();
    }

    public void buildCargo(Pane control)
    {
        Pane parentBlock = new Pane();
        buildLinePanes(parentBlock, 6, false);
        parentBlock.setLayoutX(20);
        parentBlock.setLayoutY(100);

        Pane parentBlock2 = new Pane();
        buildLinePanes(parentBlock2, 6, true);
        parentBlock2.setLayoutX(20);
        parentBlock2.setLayoutY(160);

        ImageView iv = new BoundImageView(new Image(Resources.getResourceFile("resources\\cargoIcon.png")), 30, 25);
        iv.setLayoutX(265);
        iv.setLayoutY(130);
        control.getChildren().addAll(parentBlock, parentBlock2, iv);
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

    public void buildShields(Pane control)
    {
        Pane parent = new Pane();
        int space = 40;
        for(int i = 0; i < this.view.getMachine().getData().getActiveShip().getShields() ; i++){
            Pane block = newBlock(40, 40, space, i);
            ImageView iv = new BoundImageView(new Image(Resources.getResourceFile("resources\\shield.png")), 40, 40);
            iv.setTranslateY(2);
            iv.setTranslateX(1);

            block.getChildren().add(iv);
            block.setLayoutX(20);
            block.setLayoutY(210);
            parent.getChildren().add(block);
        }
        control.getChildren().add(parent);
    }

    public void buildWeapons(Pane control)
    {
        Pane parent = new Pane();
        int space = 40;
        for(int i = 0; i < this.view.getMachine().getData().getActiveShip().getArtilary() ; i++){
            Pane block = newBlock(40, 40, space, i);
            ImageView iv = new BoundImageView(new Image(Resources.getResourceFile("resources\\gun.png")), 40, 40);
            iv.setTranslateY(2);
            iv.setTranslateX(1);

            block.getChildren().add(iv);
            block.setLayoutX(20);
            block.setLayoutY(340);
            parent.getChildren().add(block);
        }
        control.getChildren().add(parent);
    }

    public Pane newBlock(int... args)
    {
        Pane block = new Pane();
        block.setMinWidth(args[0]);
        block.setMinHeight(args[1]);
        block.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        block.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        block.setLayoutX(args[2]*args[3]);
        return block;
    }

    public void displayShip()
    {
        Pane ship = new Pane();
        ship.setBorder(new Border(new BorderStroke(Color.BLUEVIOLET, BorderStrokeStyle.SOLID,
                null, new BorderWidths(3))));
        ship.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        if(this.view.getMachine().getData().getActiveShip() instanceof MilitaryShip)
            this.ship = new BoundImageView( new Image(Resources.getResourceFile("resources\\militaryship.png")), 200, 150 );
        else
            this.ship = new BoundImageView( new Image(Resources.getResourceFile("resources\\miningship.png")), 200, 150 );

        this.ship.setLayoutX(50);
        ship.getChildren().add(this.ship);
        GridPane.setConstraints(ship, 0, 1);
        getChildren().add(ship);
    }

}
