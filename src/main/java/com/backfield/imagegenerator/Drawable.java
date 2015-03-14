package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;

/**
 * Created by jbackfield on 3/12/15.
 */
public interface Drawable {

    public void draw(BufferedImage image, int color, int x , int y, int squareSize);

}
