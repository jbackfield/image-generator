package com.backfield.imagegenerator;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ImageDraw {

    public static final int squareSize = 20;
    private static final int numberOfSquares = 10;

    public final static List<Drawable> drawables = Arrays.asList(
            (image, color, x, y) -> {
                for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
                    for (int squareY = squareX; squareY < ImageDraw.squareSize; squareY++) {
                        image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
                    }
                }
            },
            (image, color, x, y) -> {
                for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
                    for (int squareY = (ImageDraw.squareSize - squareX); squareY < ImageDraw.squareSize; squareY++) {
                        image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
                    }
                }
            },
            (image, color, x, y) -> {
                for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
                    for (int squareY = 0; squareY < ImageDraw.squareSize; squareY++) {
                        image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
                    }
                }
            },
            (image, color, x, y) -> {
                for (int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
                    for (int squareY = 0; squareY < squareX; squareY++) {
                        image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
                    }
                }
            },
            (image, color, x, y) -> {
                for(int squareX = 0; squareX < ImageDraw.squareSize; squareX++) {
                    for(int squareY = 0; squareY < ImageDraw.squareSize; squareY++) {
                        image.setRGB(x * ImageDraw.squareSize + squareX, y * ImageDraw.squareSize + squareY, color);
                    }
                }
            }
    );

    private static final int baseColor = 0x313A75;

    private static final int[] baseColorPalette = {0x182157, 0x080F3A, 0x525B92, 0x7C93AF};

    private static final int compliment = 0xAA8A39;

    private static final int[] complimentPalette = {0xFFE7AA, 0xD4B66A, 0x806115, 0x553D00};

    private static int nextColor(Random random) {
        float rand = random.nextFloat();
        int base;
        int[] palette;
        if(rand < 0.1) {
            base = ImageDraw.compliment;
            palette = ImageDraw.complimentPalette;
        } else {
            base = ImageDraw.baseColor;
            palette = ImageDraw.baseColorPalette;
        }
        if(rand < 0.6) {
            return base;
        } else {
            return palette[(int)(rand * 4)];
        }
    }

    public static BufferedImage draw(Random random) {
        BufferedImage image = new BufferedImage(
                ImageDraw.squareSize * ImageDraw.numberOfSquares,
                ImageDraw.squareSize * ImageDraw.numberOfSquares,
                BufferedImage.TYPE_INT_RGB
        );
        for(int x = 0; x < ImageDraw.numberOfSquares; x++) {
            for(int y = 0; y < ImageDraw.numberOfSquares; y++) {
                drawables.get(
                        (int)(random.nextFloat()*drawables.size())
                ).draw(image, nextColor(random), x, y);
            }
        }
        return image;
    }

}
