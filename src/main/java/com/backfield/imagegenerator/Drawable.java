package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;

public interface Drawable {

    public void draw(BufferedImage image, int color, int x, int y);

}
