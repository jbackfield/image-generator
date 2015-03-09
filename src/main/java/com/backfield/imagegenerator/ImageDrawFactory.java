package com.backfield.imagegenerator;

public class ImageDrawFactory {

    private int squareSize;
    private int numberOfSquares;

    public ImageDrawFactory(int squareSize, int numberOfSquares) {
        this.squareSize = squareSize;
        this.numberOfSquares = numberOfSquares;
    }

    public ImageDraw create() {
        return new ImageDraw(this.squareSize, this.numberOfSquares);
    }

}
