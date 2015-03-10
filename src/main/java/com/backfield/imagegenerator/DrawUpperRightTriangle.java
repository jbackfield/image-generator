package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;

public class DrawUpperRightTriangle implements Drawable {
    @Override
    public void draw(BufferedImage image, int color, int x, int y) {
        for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
            for (int squareY = 0; squareY < squareX; squareY++) {
                image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
            }
        }
    }
}
