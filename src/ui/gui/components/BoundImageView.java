package ui.gui.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BoundImageView extends ImageView
{
    /**
     * Constructor to create a custom measured ImageView
     *
     * @param img
     * @param width
     * @param height
     */
    public BoundImageView(Image img, int width, int height)
    {
        super(img);
        setFitHeight(height);
        setFitWidth(width);
    }

}
