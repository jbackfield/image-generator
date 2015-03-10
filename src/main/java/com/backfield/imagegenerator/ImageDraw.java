package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageDraw {

    private BufferedImage image;

    public static int squareSize;
    private int numberOfSquares;

    private int x = 0;
    private int y = 0;

    private Random random = new Random();

    private final int baseColor = 0x313A75;

    private final int[] baseColorPalette = {0x182157, 0x080F3A, 0x525B92, 0x7C93AF};

    private final int compliment = 0xAA8A39;

    private final int[] complimentPalette = {0xFFE7AA, 0xD4B66A, 0x806115, 0x553D00};

    public ImageDraw(int squareSize, int numberOfSquares) {
        ImageDraw.squareSize = squareSize;
        this.numberOfSquares = numberOfSquares;
        this.image = new BufferedImage(ImageDraw.squareSize * this.numberOfSquares, ImageDraw.squareSize * this.numberOfSquares, BufferedImage.TYPE_INT_RGB);
    }

    public void setSeed(int hash) {
        this.random.setSeed(hash);
    }

    private void drawLowerLeftTriangle(BufferedImage image, int color, int x, int y) {
        for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
            for (int squareY = squareX; squareY < ImageDraw.squareSize; squareY++) {
                image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
            }
        }
    }

    private void drawLowerRightTriangle(BufferedImage image, int color, int x, int y) {
        for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
            for (int squareY = (ImageDraw.squareSize - squareX); squareY < ImageDraw.squareSize; squareY++) {
                image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
            }
        }
    }

    private void drawUpperLeftTriangle(BufferedImage image, int color, int x, int y) {
        for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
            for (int squareY = 0; squareY < ImageDraw.squareSize; squareY++) {
                image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
            }
        }
    }

    private void drawUpperRightTriangle(BufferedImage image, int color, int x, int y) {
        for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
            for (int squareY = 0; squareY < squareX; squareY++) {
                image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
            }
        }
    }

    private void drawSquare(BufferedImage image, int color, int x, int y) {
        for(int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
            for(int squareY = 0; squareY < ImageDraw.squareSize; squareY++) {
                image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
            }
        }
    }

    private int nextColor() {
        float rand = this.random.nextFloat();
        int base;
        int[] palette;
        if(rand < 0.1) {
            base = compliment;
            palette = complimentPalette;
        } else {
            base = baseColor;
            palette = baseColorPalette;
        }
        if(rand < 0.6) {
            return base;
        } else {
            return palette[(int)(rand * 4)];
        }
    }

    public BufferedImage draw() {
        for(this.x = 0; this.x < this.numberOfSquares; this.x++) {
            for(this.y = 0; this.y < this.numberOfSquares; this.y++) {
                float rand = this.random.nextFloat();
                if(rand < 0.2) {
                    this.drawSquare(this.image, nextColor(), x, y);
                } else if(rand < 0.4) {
                    this.drawUpperRightTriangle(this.image, nextColor(), x, y);
                } else if(rand < 0.6) {
                    this.drawUpperLeftTriangle(this.image, nextColor(), x, y);
                } else if(rand < 0.8) {
                    this.drawLowerRightTriangle(this.image, nextColor(), x, y);
                } else {
                    this.drawLowerLeftTriangle(this.image, nextColor(), x, y);
                }
            }
        }
        return this.image;
    }

}
