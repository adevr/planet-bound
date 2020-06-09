package ui.gui;

import java.awt.Container;
import javax.swing.JFrame;

public class GameView extends JFrame {
    private final GameModel model;
    private Container cp;

    public GameView(GameModel game) {
        this(game, 200, 100, 1270, 575);
    }   

    public GameView(GameModel game, int x, int y, int width, int height) 
    {
        super("Planet Bound");

        this.model = game;
        cp = getContentPane();

        setLocation(x, y); 
        setSize(width, height); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();    
    }

}
