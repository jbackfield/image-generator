package com.backfield.imagegenerator.java.sep2014.drawables;

import com.backfield.imagegenerator.java.sep2014.ImageGenerator;
import com.backfield.imagegenerator.java.sep2014.drawables.Drawable;

import java.awt.image.BufferedImage;

public class LowerRightTriangleDrawable implements Drawable {

    public static final String NAME = "LOWERRIGHTTRIANGLE";

    @Override
    public void draw(BufferedImage image, int x, int y, int color) {
        for (int squareX = 0; squareX < ImageGenerator.squareSize; squareX++) {
            for (int squareY = (ImageGenerator.squareSize - squareX); squareY < ImageGenerator.squareSize; squareY++) {
                image.setRGB(x * ImageGenerator.squareSize + squareX, y * ImageGenerator.squareSize + squareY, color);
            }
        }
    }
}
