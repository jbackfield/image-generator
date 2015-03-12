package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;

/**
 * Created by jbackfield on 3/12/15.
 */
public class DrawLowerRightTriangle {

    public static void draw(BufferedImage image, int color, int x, int y, int squareSize) {
        for (int squareX = 0; squareX < squareSize; squareX++) {
            for (int squareY = (squareSize - squareX); squareY < squareSize; squareY++) {
                image.setRGB(
                        x * squareSize + squareX,
                        y * squareSize + squareY,
                        color
                );
            }
        }
    }
}
