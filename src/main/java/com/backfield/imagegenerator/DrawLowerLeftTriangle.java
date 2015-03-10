package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;

public class DrawLowerLeftTriangle implements Drawable {
    @Override
    public void draw(BufferedImage image, int color, int x, int y) {
        for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
            for (int squareY = squareX; squareY < ImageDraw.squareSize; squareY++) {
                image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
            }
        }
    }
}
