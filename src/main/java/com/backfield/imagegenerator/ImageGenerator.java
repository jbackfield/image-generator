package com.backfield.imagegenerator;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class ImageGenerator {

    public static void main(String[] args) {
        if(args.length != 1) {
            throw new IllegalArgumentException("Expected email as argument");
        }
        Random random = new Random();
        random.setSeed(args[0].hashCode());
        File file = new File("test.png");
        try {
            ImageIO.write(ImageDraw.draw(random), "png", file);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
