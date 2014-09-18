package com.backfield.imagegenerator.java.sep2014;

import com.backfield.imagegenerator.java.sep2014.drawables.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

public class ImageGenerator {

    public static int squareSize = 20;

    public static int numberOfSquares = 10;

    private String name;

    private Map<String, Drawable> drawables = new HashMap<String, Drawable>();

    private List<String> drawableTypes = new LinkedList<String>();

    public Random createRandom(String name) {
        Random random = new Random();
        long seed = 0;
        for (byte b : name.getBytes()) {
            seed += b;
        }
        random.setSeed(seed);
        return random;
    }

    public ImageGenerator(String name) {
        this.name = name;
        drawables.put(SquareDrawable.NAME, new SquareDrawable());
        drawableTypes.add(SquareDrawable.NAME);
        drawables.put(LowerLeftTriangleDrawable.NAME, new LowerLeftTriangleDrawable());
        drawableTypes.add(LowerLeftTriangleDrawable.NAME);
        drawables.put(LowerRightTriangleDrawable.NAME, new LowerRightTriangleDrawable());
        drawableTypes.add(LowerRightTriangleDrawable.NAME);
        drawables.put(UpperLeftTriangleDrawable.NAME, new UpperLeftTriangleDrawable());
        drawableTypes.add(UpperLeftTriangleDrawable.NAME);
        drawables.put(UpperRightTriangleDrawable.NAME, new UpperRightTriangleDrawable());
        drawableTypes.add(UpperRightTriangleDrawable.NAME);
    }

    public BufferedImage generateImage() {
        Random random = createRandom(this.name);
        Color color = new Color();
        BufferedImage image = new BufferedImage(squareSize * numberOfSquares, squareSize * numberOfSquares, BufferedImage.TYPE_INT_RGB);
        for(int x = 0; x < numberOfSquares; x++) {
            for(int y = 0; y < numberOfSquares; y++) {
                String key = drawableTypes.get(random.nextInt(drawableTypes.size()));
                drawables.get(key).draw(image, x, y, color.nextColor(random));
            }
        }
        image.flush();
        return image;
    }

    public static void main(String[] args) {
        ImageGenerator generator = new ImageGenerator("jbackfield@gmail.com");
        File file = new File("test.png");
        try {
            ImageIO.write(generator.generateImage(), "png", file);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
