package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ImageDraw {

    private final static int baseColor = 0x313A75;

    private final static int[] baseColorPalette = {0x182157, 0x080F3A, 0x525B92, 0x7C93AF};

    private final static int compliment = 0xAA8A39;

    private final static int[] complimentPalette = {0xFFE7AA, 0xD4B66A, 0x806115, 0x553D00};

    public final static List<Drawable> drawables = Arrays.asList(
        new DrawSquare()::drawIt,
        DrawUpperRightTriangle::draw,
        DrawUpperLeftTriangle::draw,
        DrawLowerRightTriangle::draw,
        DrawLowerLeftTriangle::draw
    );

    private static int nextColor(float rand) {
        if(rand < 0.1) {
            if(rand < 0.6) {
                return compliment;
            } else {
                return complimentPalette[(int)(rand * 4)];
            }
        } else {
            if (rand < 0.6) {
                return baseColor;
            } else {
                return baseColorPalette[(int)(rand * 4)];
            }
        }
    }

    public static BufferedImage draw(Random random, int squareSize, int numberOfSquares) {
        BufferedImage image = new BufferedImage(
                squareSize * numberOfSquares,
                squareSize * numberOfSquares,
                BufferedImage.TYPE_INT_RGB
        );
        for(int x = 0; x < numberOfSquares; x++) {
            for(int y = 0; y < numberOfSquares; y++) {
                ImageDraw.drawables.get(
                        random.nextInt(
                                ImageDraw.drawables.size()
                        )
                ).draw(
                        image,
                        ImageDraw.nextColor(random.nextFloat()),
                        x,
                        y,
                        squareSize
                );
            }
        }
        return image;
    }

}
