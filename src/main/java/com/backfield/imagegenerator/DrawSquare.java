package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;

/**
 * Created by jbackfield on 3/12/15.
 */
public class DrawSquare {

    public void drawIt(BufferedImage image, int color, int x, int y, int squareSize) {
        for(int squareX = 0; squareX < squareSize; squareX++) {
            for(int squareY = 0; squareY < squareSize; squareY++) {
                image.setRGB(
                        x * squareSize + squareX,
                        y * squareSize + squareY,
                        color
                );
            }
        }
    }
}
